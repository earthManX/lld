public class ConsoleSubscriber implements Subscriber{
    
    @Override
    public void logMessage( String message){
        System.out.println("Console - " + message);
    }

}
