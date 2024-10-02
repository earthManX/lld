package wallet.users;

import java.util.*;

import wallet.wallets.*;
import wallet.payments.*;;

public class User implements IUser{

    private final int id;
    private Wallet wallet;
    private final List<Transaction> transactions;

    public User(int id){
        this.id = id;
        transactions = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }
    
    public int getBalance(){
        return wallet.getBalance();
    }

    public void addMoney( int amount){
        wallet.addMoney(amount);
    }

    public void deductMoney( int amount){
        wallet.deductMoney(amount);
    }

    public void addTransaction(Transaction txn){
        transactions.add(txn);
    }

    public List<Transaction> geTransactions(){
        return transactions;
    }

}
