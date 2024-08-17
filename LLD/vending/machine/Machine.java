package LLD.vending.machine;

import java.util.*;

public class Machine {
    
    private Map<String , Item> itemMap;
    private Panel panel;
    private State currentState;
    private Map<State, List<State>> statemachine;
    private String currentSelection;
    PaymentProcessor processor;

    private Machine(){}

    public Machine getMachine( List<Item> items ){
        this.init(items);
        return this;
    }
    
    private void init( List<Item> items){
        currentState = State.SELECT_ITEM;
        items.forEach(item -> {
            itemMap.put(item.getCode(), item);
        });
        panel = new Panel( new ArrayList<>(Arrays.asList("1", "2", "Proceed", "Cancel")) );
        statemachine.put( State.SELECT_ITEM, new ArrayList<>(Arrays.asList(State.SELECT_PAYMENT)));
        statemachine.put( State.SELECT_PAYMENT, new ArrayList<>(Arrays.asList(State.CASH_PAYMENT, State.CANCEL)));
        statemachine.put( State.CASH_PAYMENT, new ArrayList<>(Arrays.asList(State.CASH_PAYMENT, State.CANCEL, State.DISPENSE)));
        statemachine.put( State.DISPENSE, new ArrayList<>(Arrays.asList(State.SELECT_ITEM)));
        statemachine.put( State.CANCEL, new ArrayList<>(Arrays.asList(State.SELECT_ITEM)));
        panel.showOnDisplay("Please select the item");
    }

    public void pressButton(Button button){
        if( button.getCode() == "Proceed"){
            processProceed();
        }else if( button.getCode() == "Cancel" ){
            processCancel();
        }else{
            panel.showOnDisplay(button.getCode());
            processCode(button.getCode());
        }
    }

    private void processProceed(){
        switch (currentState) {
            case SELECT_ITEM:
                if( currentSelection.isBlank() || currentSelection.isEmpty()){
                    panel.showOnDisplay("Please select a product id");
                }else{
                    if( itemMap.containsKey(currentSelection)){
                        currentState = State.SELECT_PAYMENT;
                        panel.showOnDisplay("Price for selected item: " + itemMap.get(currentSelection).getPrice());
                        panel.showOnDisplay("Press 1 for Cash or Press 2 for UPI");
                        return;
                    }
                    panel.showOnDisplay("Invalid product code. Please select valid code");
                    currentSelection = "";
                    break;
                }
                break;
            case SELECT_PAYMENT:
                panel.showOnDisplay("Press 1 for Cash or Press 2 for UPI");
                break;
            case CASH_PAYMENT:
                panel.showOnDisplay("Processing cash payment");
                scanCash();
                float remainingCash = ((CashPaymentProcessor) processor).remainingCash(itemMap.get(currentSelection).getPrice());
                if(remainingCash == 0){
                    processPayment();
                }else{
                    panel.showOnDisplay("Insufficient cash inserted. Insert " + remainingCash + " more to continue"); 
                }
                break;
            case ONLINE_PAYMENT:
                panel.showOnDisplay("Processing cash payment");
                break;
            default:
                panel.showOnDisplay("Invalid input");
                break;
        }
    }

    private void processCancel(){
        switch (currentState) {
            case SELECT_ITEM:
                currentSelection = "";
                break;
            case SELECT_PAYMENT:
                currentSelection = "";
                currentState = State.SELECT_ITEM;
                break;
            case CASH_PAYMENT:
                if( processor.refund()){
                    panel.showOnDisplay("Please collect refund cash from cash tray");
                }else{
                    panel.showOnDisplay("Please proceed with item selection");
                }
                currentSelection = "";
                currentState = State.SELECT_ITEM;
                break;
            case ONLINE_PAYMENT:
                if( processor.refund()){
                    panel.showOnDisplay("Refund request is successfull");
                }else{
                    panel.showOnDisplay("Please proceed with item selection");
                }
                currentSelection = "";
                currentState = State.SELECT_ITEM;
                break;
            default:
                panel.showOnDisplay("Invalid input");
                break;
        }
    }

    private void processCode(String code){
        switch (currentState) {
            case SELECT_ITEM:
                currentSelection = code;
                break;
            case SELECT_PAYMENT:
                if( code == "1"){
                    processor = new CashPaymentProcessor();
                    panel.showOnDisplay("Insert cash in the cash tray. Press proceed after cash has been inserted");
                    currentState = State.CASH_PAYMENT;
                }else if( code == "2"){
                    processor = new OnlinePaymentProcessor();
                    panel.showOnDisplay("Scan QR and make payment");
                    currentState = State.CASH_PAYMENT;
                }else{
                    panel.showOnDisplay("Press 1 for Cash or Press 2 for UPI");
                }
                break;
            case CASH_PAYMENT:
                panel.showOnDisplay("Invalid input");
                break;
            case ONLINE_PAYMENT:
                panel.showOnDisplay("Invalid input");
                break;
            default:
                panel.showOnDisplay("Invalid input");
                break;
        }
    }

    public void processPayment(){
        if( processor.processPayment(itemMap.get(currentSelection).getPrice())){
            panel.showOnDisplay("Payment successfull");
            currentState = State.DISPENSE;
            dispenseItem();
        }else{
            panel.showOnDisplay("Payment unsuccessfull. Please try again or press cancel to abort.");
        }
    }

    private void dispenseItem(){
        panel.showOnDisplay("Dispensing item");
        // Dispense
        currentState = State.SELECT_ITEM;
        currentSelection = "";
    }

    private void scanCash(){
        ((CashPaymentProcessor) processor).scanCash();
    }
}
