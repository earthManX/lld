package LLD.FoodDelivery;

import java.util.*;

public class QueueManager {

    static QueueManager manager;
    private Queue<Order> orders;
    private Queue<Delivery> deliveries;
    private Queue<HashMap<String, String>> orderUpdates;
    
    private QueueManager(){
        if( orders == null ){
            orders = new LinkedList<>();
        }
        if( deliveries == null){
            deliveries = new LinkedList<>();
        }
        if( orderUpdates == null){
            orderUpdates = new LinkedList<HashMap<String, String>>();
        }
    }

    public static QueueManager getQueueManager(){
        if( manager != null){
            return manager;
        }
        manager = new QueueManager();
        return manager;
    }

    public Queue<Order> getOrders(){
        return orders;
    }

    public Queue<Delivery> getDeliveries(){
        return deliveries;
    }

    public Queue<HashMap<String, String>> getUpdates(){
        return orderUpdates;
    }
}
