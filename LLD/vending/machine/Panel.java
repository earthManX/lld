package LLD.vending.machine;

import java.util.List;

public class Panel {
   
    List<Button> buttons;
    
    public Panel( List<String> labels){
        for (String label : labels) {
            buttons.add(new Button(label));
        }
    }

    public void pressButton(Button button ){
        showOnDisplay( button.getCode());
    }

    public void showOnDisplay( String s){
        // Print s
        System.out.println(s);
    }

}
