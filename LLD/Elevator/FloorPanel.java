package LLD.Elevator;

public class FloorPanel {

    public boolean callElevator(int floor, Direction direction){
        return Scheduler.callElevator(floor, direction);
    }
}
