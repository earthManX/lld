package LLD.Library;
import java.util.*;

public class ReservationSystem {
    
    Map<String, PriorityQueue<String[]>> reservations;
    // Each reservation should have an id;

    ReservationSystem(){
        reservations = new HashMap<>();
    }

    public List<String[]> getReservations(String id){

        return reservations.get(id) != null ? reservations.get(id).stream().toList() : new ArrayList<>();
    }

    public void addReservation(String id, String fromDate, String toDate){
        reservations.getOrDefault( id , new PriorityQueue<String[]>( (r1, r2) ->{
                return r1[0].compareTo(r2[0]);
            } ))
        .add(new String[] {fromDate, toDate});
    }

    public void returnArtifact( String id, String time){
        reservations.get(id).removeIf( a -> (a[1].compareTo(time) < 0) || (a[0].compareTo(time) >= 0 && a[1].compareTo(time) <= 0));
    }
}
