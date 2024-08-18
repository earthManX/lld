package LLD.FoodDelivery;
import java.util.*;

public class RestrauntManger {
    static RestrauntManger manager;
    private Map< String, Restraunt> restraunts;

    private RestrauntManger(){
        if( restraunts == null){
            restraunts = new HashMap<>();
        }
    }

    public static RestrauntManger getRestrauntManger(){
        if( manager != null){
            return manager;
        }
        manager = new RestrauntManger();
        return manager;
    }

    public Restraunt getRestraunt( String id){
        return restraunts.get(id);
    }

    public void submitOrder( String id, Order order){
        Restraunt restraunt = restraunts.get(id);
        restraunt.submitOrder( order.getId(), order.getFood() );
    }

}

