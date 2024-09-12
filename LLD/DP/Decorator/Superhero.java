package LLD.DP.Decorator;

public class Superhero {
    private Power power;

    public Superhero(){

    }

    public void givePowers(Superhero s){
        power = new StrengthPower();
        power = new ShootPowerDecorator(power);
        power = new FlyPowerDecorator(power);

        s.setPower(power);
    }

    private void setPower( Power p ){

    }
}
