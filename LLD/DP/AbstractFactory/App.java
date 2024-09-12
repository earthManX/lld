package LLD.DP.AbstractFactory;

//Client
public class App {
    
    GUIFactory factory;

    public App(String type){
        factory = (type.equalsIgnoreCase("Windows") ? new WindowsFactory() : new MacFactory()) ;
    }

    public boolean clickButton(){
        return factory.getButton().isClicked();
    }
}
