package shares;

public class Share {
    
    private final int shareId;
    private int price;

    public Share(int shareId, int price){
        this.shareId = shareId;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getShareId() {
        return shareId;
    }
    public int getPrice() {
        return price;
    }


}
