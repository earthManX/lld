package LLD.DP.Decorator;

public class FlyPowerDecorator extends PowerDecorator{

    FlyPowerDecorator(Power p) {
        super(p);
    }
    
    public void usePower() {
        super.usePower();
        // Some Fly power logic        
    }
    
}
