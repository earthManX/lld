package foodOrder.restraunts;

import java.util.*;

import foodOrder.exceptions.RestaurantNotFoundException;

public class RestrauntManager {
    
    private static RestrauntManager manager;
    private static Map<String, Restaurant> restaurants;

    private RestrauntManager(){};

    public static RestrauntManager getInstance(){
        if( manager == null){
            manager = new RestrauntManager();
            restaurants = new HashMap<>();
        }
        return manager;
    }

    public Restaurant getRestaurant(String name) throws RestaurantNotFoundException {
        if( restaurants.keySet().contains(name)){
            return restaurants.get(name);
        }else{
            throw new RestaurantNotFoundException();
        }
    }

    public void addRestaurant( Restaurant restaurant){
        restaurants.put( restaurant.getName(), restaurant);
    }

    public void updateQuantity( String restaurantName, int additionalQuantity) throws RestaurantNotFoundException{
        if( restaurants.keySet().contains(restaurantName)){
            restaurants.get(restaurantName).updateQuantity(additionalQuantity);
        }else{
            throw new RestaurantNotFoundException();
        }
    }

    public void rateRestaurant( String userId, String name, int rating, String comment) throws RestaurantNotFoundException {
        if( restaurants.keySet().contains(name)){
            restaurants.get(name).addRating(userId, rating);
        }else{
            throw new RestaurantNotFoundException();
        }
    }

    public List<Restaurant> getRestaurants(){
        List<Restaurant> rL = restaurants.values().stream().toList();
        return rL;
    }
}
