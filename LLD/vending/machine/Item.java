package LLD.vending.machine;

public class Item {
    
    private String code;
    private Float price;

    public Item( String code, Float price ){
        this.code = code;
        this.price = price;
    }

    public String getCode(){
        return this.code;
    }

    public Float getPrice(){
        return this.price;
    }
}
