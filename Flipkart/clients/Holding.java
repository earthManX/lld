package clients;

import shares.*;

public class Holding {
    
    private Share share;
    private int quantity;
    private int day;

    public void setShare(Share share) {
        this.share = share;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Share getShare() {
        return share;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDay() {
        return day;
    }

    public Holding( Share share, int q, int d){
        this.share = share;
        this.quantity = q;
        this.day = d;
    }
}
