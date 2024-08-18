package LLD.FoodDelivery;

public class LocationDPMS implements DeliveryPartnerMatchingStrategy {

    @Override
    public String getDeliveryPartner(Delivery delivery) {
        return "someId";
        // Match a delivery partner
    }
    
}
