package LLD.DP.AbstractFactory;

//Concrete Factory class 
public class WindowsFactory implements GUIFactory{
    
    public Button getButton(){
        return new WinButton();
    }

    public CheckBox getCheckBox(){
        return new WinCheckBox();
    }
}
