package wallet.payments;

public class UPIPayments extends Payments {
    
    @Override
    public boolean process(int amount){
        return true;
    }
}
