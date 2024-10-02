package foodOrder;

import foodOrder.restraunts.*;
import foodOrder.users.*;
import foodOrder.utils.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import foodOrder.exceptions.*;

public class UserInterface {
    
    private RestrauntManager restrauntManager;
    private UserManager userManager;
    private User user;

    public UserInterface(){
        restrauntManager = RestrauntManager.getInstance();
        userManager = UserManager.getInstance();
    }

    public void register_user(String name, Gender gender, String phoneNumber, String pincode){
        User newUser = new User(name, gender, phoneNumber, pincode);
        userManager.addUser(newUser);
        System.out.println("User registered with id - " + phoneNumber);
    }

    public void login_user( String user_id){
        try{
            user = userManager.getUser(user_id);
        }catch( UserNotFoundException e){
            System.out.println("User with id " + user_id + " is not registered");
        }
    }

    public void register_restaurant(String resturant_name, String pinCodes, String foodItem, int price, int quantity){
        if( !isUserLoggedIn()){
            return;
        }
        Restaurant restaurant = new Restaurant(resturant_name, pinCodes, foodItem, price, quantity);
        restrauntManager.addRestaurant(restaurant);
        System.out.println("Restaurant registered with name - " + resturant_name);
    }

    public void update_quantity(String name, int quantity){
        if( !isUserLoggedIn()){
            return;
        }
        try{
            restrauntManager.updateQuantity(name, quantity);
        }catch( RestaurantNotFoundException e){
            System.out.println("Restaurant with name " + name + " is not registered");
        }
    }

    public void rate_restaurant(String name, int rating, String comment){
        if( !isUserLoggedIn()){
            return;
        }
        try{
            restrauntManager.rateRestaurant( user.getId(), name, rating, comment);
        }catch( RestaurantNotFoundException e){
            System.out.println("Restaurant with name " + name + " is not registered");
        }
    }

    public void show_restaurant( SortType type){
        if( !isUserLoggedIn()){
            return;
        }
        List<Restaurant> rL = restrauntManager.getRestaurants();

        rL = rL.stream()
            .filter( r -> r.getPincode().contains(user.getPincode()))
            .filter( r -> r.getQuantity() > 0 )
            .collect(Collectors.toList());

        System.out.println(rL);
        if( type.equals(SortType.PRICE)){
            Collections.sort(rL, (r1, r2) -> {
                return Integer.compare(r2.getPrice(), r1.getPrice());
            });

        }else if( type.equals(SortType.RATING)){
            rL.sort( (r1, r2) -> {
                return Long.compare(r2.getRating(), r1.getRating());
            });
        }
        rL.forEach(r -> {
            System.out.println("Restaurant name - " + r.getName() + " Item - " + r.getItem() + " Price - " + r.getPrice() );
        });
    }

    public void place_order(String name, int quantity){
        if( !isUserLoggedIn()){
            return;
        }
        try {
            Restaurant restaurant = restrauntManager.getRestaurant(name);
            if( restaurant.getQuantity() >= quantity && restaurant.getPincode().contains(user.getPincode()) ){
                restaurant.placeOrder(quantity);
                user.addOrder( name, quantity);
                System.out.println("Order placed - " + name + " " + quantity);
            }else{
            System.out.println("Cannot place order");

            }
        } catch (RestaurantNotFoundException e) {
            System.out.println("Restaurant with name " + name + " is not registered");
        }
        
    }

    private boolean isUserLoggedIn(){
        if( user == null){
            System.out.println("User should be logged in to perform this action");
            return false;
        }
        return true;
    }

    public void getOrderHistory(){
        user.getOrders().forEach(o -> {
            System.out.println("Order - " + o.getRestaurantName() + " " + o.getQuantity());
        });
    }
    
}
