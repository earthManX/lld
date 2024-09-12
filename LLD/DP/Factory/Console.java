package LLD.DP.Factory;

public class Console {
    Game game;
    GameFactory gameFactory;
    public void initializeGame( String type){
        if( type == "PS5"){
            gameFactory = new PSGameFactory();
            game = gameFactory.getGame();
            game.play();
        }
        if( type == "Windows"){
            gameFactory = new WindowsGameFactory();
            game = gameFactory.getGame();
            game.play();
        }
        //Default behavious
    }
}
