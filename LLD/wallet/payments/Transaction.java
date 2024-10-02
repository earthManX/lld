package wallet.payments;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private String id;
    private int amount;
    private TransactionType type;
    private int userId;
    private LocalDateTime dateTime;

    public Transaction( int amount, TransactionType type, int userId){
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.type = type;
        this.userId = userId;
        this.dateTime = LocalDateTime.now();
    }

    public TransactionType getType(){
        return type;
    }

    public int getAmount(){
        return amount;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }
}


