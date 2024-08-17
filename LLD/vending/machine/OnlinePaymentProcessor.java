package LLD.vending.machine;

public class OnlinePaymentProcessor implements PaymentProcessor {
    
    @Override
    public boolean processPayment(float price) {
        // TODO Process online payment for price
        return false;
    }

    @Override
    public boolean refund() {
        // TODO Auto-generated method stub
        return false;
    }
}
