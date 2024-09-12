package LLD.DP.Decorator;

public class ShootPowerDecorator extends PowerDecorator{
    
    ShootPowerDecorator(Power p) {
        super(p);
    }
    
    public void usePower() {
        super.usePower();
        // Some Fly power logic        
    }

}
