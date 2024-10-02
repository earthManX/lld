package wallet.payments;

public class DCPayments extends Payments {
    
    @Override
    public boolean process(int amount){
        return true;
    }
}
