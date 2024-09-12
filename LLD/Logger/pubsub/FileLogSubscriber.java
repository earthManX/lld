public class FileLogSubscriber implements Subscriber{
    
    @Override
    public void logMessage( String msg){
        System.out.println("File - " + msg);
    }

}
