public class AStrategy implements Strategy {

    @Override
    public String format( String message){
        return String.format("This is strategy A format : %s", message);
    }

}
