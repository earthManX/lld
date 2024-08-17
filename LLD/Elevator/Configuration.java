package LLD.Elevator;

public class Configuration {
    
    private static int floors;
    private static int elevators;

    private Configuration(){

    }

    public static int getFloors(){
        return floors;
    }

    public static int getElevators(){
        return elevators;
    }

    void updateFloorConfiguration(int floors){
        Configuration.floors = floors;
    }

    void updateElevatorConfiguration(int elevators){
        Configuration.elevators = elevators;
    }

}
