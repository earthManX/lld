package LLD.DP.Factory;

public class WindowsGameFactory implements GameFactory{
    
    @Override
    public Game getGame(){
        return new WindowsGame();
    }
}
