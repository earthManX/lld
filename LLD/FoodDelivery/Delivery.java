package LLD.FoodDelivery;

public class Delivery {
    
    String id;
    String orderId;
    String restrauntId;
    Integer totalItems;
    String paymentType;
    Double price;
    String location;
    String restrauntName;

    public Delivery( String id, String orderId, String restrauntId){
        this.id = id;
        this.orderId = orderId;
        this.restrauntId = restrauntId;
    }
}
