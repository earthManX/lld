package wallet;

import java.util.Collections;
import java.util.List;

import wallet.payments.*;
import wallet.users.*;

public class UserInterface {
    
    UserManager userManager;
    PaymentsProcessor paymentsProcessor;

    public UserInterface(){
        userManager = UserManager.getUserManagerInstance();
        paymentsProcessor = PaymentsProcessor.getPaymentsProcessorInstance();
    }

    // Registers a user
    // returns user id
    public int addUser(){
        return userManager.addUser();
    }

    public boolean loadMoney( int srcUserId, int amount, PaymentType type){
        User user = userManager.getUser(srcUserId);
        boolean payStatus = paymentsProcessor.processPayment(amount, type);
        if( payStatus){
            user.addMoney(amount);
            user.addTransaction(new Transaction(amount, TransactionType.RECEIVE, srcUserId));
            System.out.println("Payment SUCCESS , Current balance : " + getBalance(srcUserId));
            return true;
        }else{
            System.out.println("Payment failed");
            return false;
        }
    }

    public boolean sendMoney( int srcUserId, int destUserId, int amount ){
        // Check if dest user exists
        User src = userManager.getUser(srcUserId);
        User dest = userManager.getUser(destUserId);
        if( src.getBalance() > amount){
            dest.addMoney( amount );
            dest.addTransaction(new Transaction(amount, TransactionType.RECEIVE, srcUserId));
            src.deductMoney( amount );
            src.addTransaction(new Transaction(amount, TransactionType.SEND, destUserId));
            return true;
        }
        return false;
    }

    public int getBalance( int userId){
        return userManager.getUser(userId).getBalance();
    }

    public List<Transaction> getHistory(int userId, SortType sortType, List<TransactionType> filterList ){
        List<Transaction> transactions = userManager.getUser(userId).geTransactions();
        if(!filterList.isEmpty()){
            transactions = transactions.stream().filter( t -> filterList.contains(t.getType())).toList();
        }
        if(!sortType.equals(SortType.NONE)){
            switch( sortType ){
                case AMOUNT:
                    Collections.sort(transactions, (t1, t2) -> {
                        return t1.getAmount() - t2.getAmount();
                    });
                    break;
                case DATETIME:
                    transactions.sort( (t1, t2) -> {
                        return t1.getDateTime().compareTo(t2.getDateTime());
                    });
                    break;
                default:
                    transactions.sort( (t1, t2) -> {
                        return t1.getDateTime().compareTo(t2.getDateTime());
                    });
                    break;
            }
        }
        return transactions;
    }

}
