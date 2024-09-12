import java.util.*;

public class Publisher {
    
    Map< Integer, List<Subscriber>> subscriptions;

    Publisher(){
        subscriptions = new HashMap<>();
    }

    public void addSubcriber(int level, Subscriber subscriber){
        List<Subscriber> list = subscriptions.getOrDefault(level, new ArrayList<>());
        list.add(subscriber);
        subscriptions.put(level, list);
        // Add to resp list
    }

    public void removeSubscriber(int level, Subscriber subscriber){
        // Add to resp list
    }

    public void publishToSubscribers( int level, String msg){
        List<Subscriber> subs = subscriptions.get(level);
        if( subs != null){
            subs.forEach( s -> {
                s.logMessage(msg);
            });
        }
    }

}
