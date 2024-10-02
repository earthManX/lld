package foodOrder.restraunts;

import java.time.LocalDateTime;

public class Order {
    
    String restaurant ;
    int quantity;
    LocalDateTime dateTime;

    public Order( String name, int quantity){
        this.restaurant = name;
        this.quantity = quantity;
        dateTime = LocalDateTime.now();
    }

    public String getRestaurantName(){
        return restaurant;
    }

    public int getQuantity(){
        return quantity;
    }
}
