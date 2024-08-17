package LLD.Elevator;

import java.util.PriorityQueue;

public class Elevator{

    int id;
    int currFloor;
    Direction direction;
    boolean isOverweight;
    Status status;
    PriorityQueue<Integer> upFloorQueue;
    PriorityQueue<Integer> downFloorQueue;
    int maxFloors;
    
    public Elevator(int currFloor, Direction direction, int floors){
        this.currFloor = currFloor;
        this.direction = direction;
        this.status = Status.IDLE;
        maxFloors = floors;
        // Min Queue
        upFloorQueue = new PriorityQueue<>(floors, (f1, f2) -> {
            return f1-f2;
        });
        // Max Queue
        downFloorQueue = new PriorityQueue<>(floors, (f1,f2) -> {
            return f2-f1;
        });
        //Initialize queues
    }

    public boolean addFloor(int floor, Direction direction){
        if( status == Status.MOVING){
            if( direction == Direction.UP){
                if( floor < currFloor || direction == Direction.DOWN){
                    return false;
                }
                upFloorQueue.add(floor);
            }else{
                if( floor > currFloor || direction == Direction.UP){
                    return false;
                }
                downFloorQueue.add(floor);
            }
            return true;
        }else{
            status = Status.MOVING;
            if( direction == Direction.UP){
                upFloorQueue.add(floor);
            }else{
                downFloorQueue.add(floor);
            }
            return true;
        }
    }

    private int nextFloor(int currFloor, Direction direction){
        if( currFloor == 0 ){
            this.direction = Direction.UP;
            direction = Direction.UP;
            Scheduler.updateElevatorDirection(id, Direction.UP);
        }
        if(  currFloor == maxFloors ){
            this.direction = Direction.DOWN;
            direction = Direction.DOWN;
            Scheduler.updateElevatorDirection(id, Direction.DOWN);
        }
        if( direction == Direction.UP){
            //Nowhere to go
            if( upFloorQueue.isEmpty()){
                setIdle( currFloor);
            }
            //Somewhere to go
            status = Status.MOVING;
            return upFloorQueue.poll();
        }else if(direction == Direction.DOWN){
            if( downFloorQueue.isEmpty()){
                setIdle( currFloor);
            }
            //Somewhere to go
            status = Status.MOVING;
            return downFloorQueue.poll();
        }else{
            if( !upFloorQueue.isEmpty()){
                status = Status.MOVING;
                return upFloorQueue.poll();
            }else if(!downFloorQueue.isEmpty()){
                status = Status.MOVING;
                return downFloorQueue.poll();
            }
        }
        return -1;
    }   

    private void setIdle(int currFloor){
        this.direction = Direction.ALL;
        this.currFloor = currFloor;
        status = Status.IDLE;
        Scheduler.setIdleElevator(id);
    }

}