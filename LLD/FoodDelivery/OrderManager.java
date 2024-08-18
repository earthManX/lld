package LLD.FoodDelivery;

import java.util.*;

public class OrderManager {
    
    static OrderManager manager;
    private DeliveryManager deliveryManager;
    private FoodManager foodManager;
    private QueueManager queueManager;
    private Queue<Order> orders;
    private Queue<Delivery> deliveries;
    private Queue<HashMap<String, String>> updates;
    private HashMap<String, Order> currentOrders; // All the orders which are currently getting processed.

    private OrderManager(){
        if( deliveryManager == null){
            deliveryManager = DeliveryManager.getDeliveryManager();
        }
        if( foodManager == null){
            foodManager = FoodManager.getFoodManager();
        }
        if( queueManager == null ){
            queueManager = QueueManager.getQueueManager();
        }
        orders = queueManager.getOrders();
        deliveries = queueManager.getDeliveries();
        updates = queueManager.getUpdates();
    }

    public static OrderManager getOrderManager(){
        if( manager != null){
            return manager;
        }
        manager = new OrderManager();
        return manager;
    }

    public void takeOrder( Order order){
        orders.add( order );
    }

     // @Listener to order queue with order details
    private void initiateFoodOrder(){
        Order order = orders.poll();
        foodManager.createOrder( order );
    }

    // @Listener to some queue with delivery details
    private void initiateDelivery(){
        deliveryManager.createDelivery(deliveries.poll());
        // Update status of order.
    }

    private void sendNotifications(){
        updates.poll();
        //Update the status of order.
    }
    //Restrautn confirms that they have accepted the order
    public void confirmOrder( String restrauntId, String orderId){
        //Initiate delivery flow
        deliveries.add( new Delivery( UUID.randomUUID().toString(), orderId, restrauntId)); // Other order data to be added to delivery
    }

    public String getOrderStatus(String orderId){
        //Fetch the order and fetch its status.
        return "status";
    }

}
