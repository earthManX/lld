package wallet.wallets;

public interface IWallet {
    
    void addMoney(int amount);
    void deductMoney(int amount);
    int getBalance();
}
