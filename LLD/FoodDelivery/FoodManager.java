package LLD.FoodDelivery;

public class FoodManager {
    
    static FoodManager manager;
    private RestrauntManger restrauntManager;

    private FoodManager(){
        if( restrauntManager == null){
            restrauntManager = RestrauntManger.getRestrauntManger();
        }
    }

    public static FoodManager getFoodManager(){
        if( manager != null){
            return manager;
        }
        manager = new FoodManager();
        return manager;
    }

    public void createOrder( Order order ){
        restrauntManager.submitOrder( order.getRestrauntId(), order);

    }
}
