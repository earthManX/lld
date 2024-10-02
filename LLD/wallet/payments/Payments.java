package wallet.payments;

public abstract class Payments {
    boolean processPayment(int amount){
        if( amount < 0 ){
            System.out.println("Min amount is 0 INR");
            return false;
        }
        return process(amount);
    }

    abstract boolean process(int amount);
}
