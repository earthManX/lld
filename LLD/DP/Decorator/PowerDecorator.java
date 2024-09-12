package LLD.DP.Decorator;

public class PowerDecorator implements Power{
    
    Power wrapee;
    PowerDecorator( Power p ){
        wrapee = p;
    }
    @Override
    public void usePower() {
        wrapee.usePower();        
    }

}
