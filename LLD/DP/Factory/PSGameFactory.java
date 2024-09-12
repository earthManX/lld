package LLD.DP.Factory;

public class PSGameFactory implements GameFactory{
    
    @Override
    public Game getGame(){
        return new PSGame();
    }
}
