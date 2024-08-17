package LLD.Elevator;

import java.util.HashSet;
import java.util.Map;

public class Scheduler {
    
    private static Map<Integer, Elevator> elevatorMap;
    private static HashSet<Elevator> upElevators;
    private static HashSet<Elevator> downElevators;
    private static HashSet<Elevator> idleElevators;
    
    private Scheduler(){
    }

    public void initializeSystem(){
        for( int i =0 ; i < Configuration.getElevators(); i++){
            Elevator elevator = new Elevator(0, Direction.UP, Configuration.getFloors() );
            elevatorMap.put(elevator.id, elevator);
            upElevators.add(elevator);
        }
        downElevators = new HashSet<>(Configuration.getElevators());
        idleElevators = new HashSet<>(Configuration.getElevators());
    }

    public static boolean callElevator(int floor, Direction direction){
        //Send elevator to the floor
        int elevatorId = findElevator( floor, direction);
        return scheduleElevator(elevatorId, floor, direction);
    }

    private static boolean scheduleElevator( int id, int floor, Direction d){
        Elevator e = elevatorMap.get(id);
        boolean isScheduled = e.addFloor(floor, d);
        if( d == Direction.UP){
            upElevators.add(e);
            idleElevators.remove(e);
        }
        return isScheduled;
    }

    private static int findElevator(int floor, Direction direction){
        int closest = 0 , dist = Integer.MAX_VALUE;
        if( direction == Direction.UP){
            for (Elevator elevator : upElevators) {
                if( floor > elevator.currFloor && dist < floor - elevator.currFloor){
                    dist = floor - elevator.currFloor;
                    closest = elevator.id;
                }
            }for( Elevator elevator : idleElevators){
                if( floor > elevator.currFloor && dist < floor - elevator.currFloor){
                    dist = floor - elevator.currFloor;
                    closest = elevator.id;
                }
            }
        }else{
            for (Elevator elevator : downElevators) {
                if( floor < elevator.currFloor && dist < - floor + elevator.currFloor){
                    dist = - floor + elevator.currFloor;
                    closest = elevator.id;
                }
            }for( Elevator elevator : idleElevators){
                if( floor <  elevator.currFloor && dist < - floor + elevator.currFloor){
                    dist = - floor + elevator.currFloor;
                    closest = elevator.id;
                }
            }
        }
        return closest;
    }

    public static void setIdleElevator( int id){
        Elevator e = elevatorMap.get(id);
        idleElevators.add(e);
        upElevators.remove(e);
        downElevators.remove(e);
    }

    public static void updateElevatorDirection(int id, Direction d){
        Elevator e = elevatorMap.get(id);
        if( d == Direction.UP){
            upElevators.add(e);
            idleElevators.remove(e);
            downElevators.remove(e);
        }else{
            upElevators.remove(e);
            idleElevators.remove(e);
            downElevators.add(e);
        }
    }
}
