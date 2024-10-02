package wallet.wallets;

public class Wallet implements IWallet {


    private int balance;
    private final int userId;

    public Wallet( int userId){
        this.userId = userId;
        balance = 0;
    }

    @Override
    public void addMoney(int amount) {
        balance += amount;
    }

    @Override
    public int getBalance(){
        return this.balance;
    }

    @Override
    public void deductMoney( int amount){
        balance -= amount;
    }
    
}
