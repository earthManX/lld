package LLD.FoodDelivery;

import java.util.Random;

public class DeliveryStrategyManager {

    static DeliveryStrategyManager manager;

    private DeliveryStrategyManager(){}

    public static DeliveryStrategyManager getDSM(){
        if( manager != null){
            return manager;
        }
        manager = new DeliveryStrategyManager();
        return manager;
    }

    public DeliveryPartnerMatchingStrategy getDPMS(){
        Random r = new Random();
        switch (r.nextInt(5)) {
            case 1:
                return new LocationDPMS();
        // Similarly other stategy based DPMS.
            default:
            return new LocationDPMS();
        }
    }
}

