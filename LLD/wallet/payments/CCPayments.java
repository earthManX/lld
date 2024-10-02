package wallet.payments;

public class CCPayments extends Payments {
    @Override
    public boolean process(int amount){
        return true;
    }
}
