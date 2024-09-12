package LLD.DP.AbstractFactory;

//Concrete Factory class 
public class MacFactory implements GUIFactory{
        
    public Button getButton(){
        return new MacButton();
    }

    public CheckBox getCheckBox(){
        return new MacCheckBox();
    }
}
