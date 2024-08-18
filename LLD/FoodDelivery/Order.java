package LLD.FoodDelivery;

import java.util.*;

public class Order {
    
    private String id;
    private String restrauntId;
    private Map<String, Integer> food;
    private Integer totalItems;
    private String paymentType;
    private Double price;
    private String status;

    public Order( String orderId, String restrauntId, Map<String, Integer> food){
        this.restrauntId = restrauntId;
        this.food = food;
        id = orderId;
        totalItems = food.values().stream().reduce(0, Integer::sum);
    }

    public String getId(){
        return id;
    }

    public String getRestrauntId(){
        return restrauntId;
    }

    public Map<String, Integer> getFood(){
        return food;
    }

    // Other getters
}
