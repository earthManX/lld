import shares.TransactionType;

public class App {
    
    public static void main(String[] args){
        StockBroker broker = new StockBroker();
        broker.createClient(1, 6000);
        // broker.createClient(2, 1000);
        System.out.println();
        broker.updateShare(1, 100); 
        broker.updateShare(2, 200);   
        broker.updateShare(3, 200); 
        System.out.println();
        broker.transact(TransactionType.BUY, 1, 1, 1, 0);
        broker.getHoldings(1);
        System.out.println();
        broker.transact(TransactionType.BUY, 1, 2, 1, 1);
        broker.getHoldings(1);
        System.out.println();
        broker.transact(TransactionType.BUY, 1, 3, 1, 1);
        broker.getHoldings(1);
        System.out.println();
        broker.updateShare(1, 200); 
        broker.updateShare(2, 300);   
        broker.updateShare(3, 400); 
        System.out.println();
        broker.transact(TransactionType.BUY, 1, 1, 1, 0);
        broker.getHoldings(1);
        System.out.println();
        broker.transact(TransactionType.BUY, 1, 2, 1, 1);
        broker.getHoldings(1);
        System.out.println();
        broker.transact(TransactionType.BUY, 1, 3, 1, 1);
        broker.getHoldings(1);
        System.out.println();
        // System.out.println();
        // broker.getHoldings();
        // broker.transact(TransactionType.SELL, 1, 1, 1, 0);
        // System.out.println();
        // broker.getHoldings(1);
        // broker.transact(TransactionType.SELL, 1, 3, 1, 2);
        // System.out.println();
        // broker.getHoldings(1);
        // broker.transact(TransactionType.BUY, 2, 1, 1, 0);
        // broker.transact(TransactionType.BUY, 2, 2, 2, 1);
        // broker.transact(TransactionType.BUY, 2, 3, 1, 1);
        
        // broker.getHoldings(2);
        // System.out.println();
        broker.getHoldings();
    }
}
