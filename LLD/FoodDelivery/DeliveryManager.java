package LLD.FoodDelivery;

public class DeliveryManager {
    
    static DeliveryManager manager;
    private DeliveryStrategyManager strategyManager;
    private QueueManager queueManager;

    private DeliveryManager(){
        strategyManager = DeliveryStrategyManager.getDSM();
        queueManager = QueueManager.getQueueManager();
    }

    public static DeliveryManager getDeliveryManager(){
        if( manager != null){
            return manager;
        }
        manager = new DeliveryManager();
        return manager;
    }
    
    public void createDelivery( Delivery delivery){
        assignDelivery( strategyManager.getDPMS().getDeliveryPartner(delivery), delivery);
    }

    private void assignDelivery( String deliveryPartnerId , Delivery deliveryS){
        //Do the assignment
        queueManager.getUpdates().add(null);// Delivery partner assgnment update
    }
}
