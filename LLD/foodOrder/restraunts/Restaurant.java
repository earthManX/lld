package foodOrder.restraunts;
import java.util.*;

import foodOrder.users.Feedback;

public class Restaurant {
    
    private final String name;
    private final List<String> pincodes;
    private final String foodItem;
    private int price;
    private int quantity;
    private long rating;
    private Map<String, Feedback> userFeedback;

    public Restaurant(String resturant_name, String pinCodes, String foodItem,  int price, int quantity){
        this.name = resturant_name;
        this.foodItem = foodItem;
        this.price = price;
        this.quantity = quantity;
        this.pincodes = Arrays.asList(pinCodes.split("/"));
        rating = 0;
        userFeedback = new HashMap<>();
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public String getItem(){
        return foodItem;
    }

    public int getQuantity(){
        return quantity;
    }

    public long getRating(){
        return rating;
    }

    public void updateQuantity( int addition ){
        quantity += addition;
    }

    public void addRating(String userId, int rating , String comment){
        Feedback feedback = new Feedback(rating, comment);
        userFeedback.put(userId, feedback);
        calculateRating(rating);
    }

    public void addRating(String userId, int rating ){
        Feedback feedback = new Feedback(rating);
        userFeedback.put(userId, feedback);
        calculateRating(rating);
    }

    public void placeOrder( int quantity){
        //Order placing workflow
        this.quantity -= quantity;
    }

    private void calculateRating(int rating){
        this.rating = (long) (this.rating * (userFeedback.size()-1) + rating)/userFeedback.size();
    }

    public List<String> getPincode(){
        System.out.println(pincodes);
        return pincodes;
    }

}
