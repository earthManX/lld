package foodOrder;

import foodOrder.utils.Gender;
import foodOrder.utils.SortType;

public class App {
    
    public static void main( String[] args){
        UserInterface ui = new UserInterface();

        ui.place_order("jkfdn", 0);
        ui.register_user("sheldon", Gender.MALE, "1", "400000");
        ui.register_user("leonard", Gender.MALE, "2", "400001");
        ui.register_user("howard", Gender.FEMALE, "3", "400002");
        ui.login_user("1");
        ui.register_restaurant("Picasso1", "400000/400001", "Cheese Cake", 500, 3);
        ui.register_restaurant("Picasso2", "400000/400002", "Brownie", 100, 5);
        ui.register_restaurant("Picasso3", "400000/400001/400002", "Cup Cake", 300, 10);
        ui.show_restaurant(SortType.PRICE);
        ui.login_user("2");
        ui.place_order("Picasso2", 1);
        ui.login_user("3");
        ui.place_order("Picasso2", 4);
        ui.rate_restaurant("Picasso2", 3, "meh");
        ui.place_order(null, 0);
        ui.show_restaurant(SortType.RATING);
        ui.getOrderHistory();
    }
}
