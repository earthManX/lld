package foodOrder.users;

import java.util.*;

import foodOrder.restraunts.Order;
import foodOrder.utils.Gender;

public class User {
    
    private String phoneNumber;
    private Gender gender;
    private String pincode;
    private String name;
    private List<Order> orders;

    public User(String name, Gender gender, String phoneNumber, String pincode){
        this.gender = gender;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
        orders = new ArrayList<>();
    }

    public String getId(){
        return phoneNumber;
    }

    public String getPincode(){
        return pincode;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public void addOrder( String name, int quantity){
        orders.add(new Order(name, quantity));
    }
}
