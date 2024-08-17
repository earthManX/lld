package LLD.vending.machine;

public class CashPaymentProcessor implements PaymentProcessor{

    float insertedCash;

    @Override
    public boolean processPayment(float price) {
        // TODO Process payment for cash price : price
        return false;
    }
    
    public float remainingCash(float price){
        return 0;
    }

    public void scanCash(){
        //Set inserted cash
    }

    @Override
    public boolean refund() {
        // TODO Auto-generated method stub
        return false;
    }
}
