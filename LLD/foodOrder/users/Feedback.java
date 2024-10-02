package foodOrder.users;

public class Feedback {
    
    private int rating;
    private String comment;

    public Feedback( int rating, String comment){
        this.rating = rating;
        this.comment = comment;
    }

    public Feedback( int rating){
        this.rating = rating;
    }
}
