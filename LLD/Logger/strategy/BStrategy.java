public class BStrategy implements Strategy {

    @Override
    public String format( String message){
        return String.format("This is strategy B format : %s", message);
    }

}
