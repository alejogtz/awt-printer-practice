 

import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CustomFocusListener implements FocusListener {

    Printer context;

    public CustomFocusListener(Printer f) {
        context = f;
    }

    @Override
    public void focusGained(FocusEvent e) {
        /**String command = e.getComponent().getName();
        switch (command) {
            case "txtTo":
                context.txt_to.setText(context.txt_from.getText());
                break;
        }*/
    }

    @Override
   public void focusLost(FocusEvent e) {
    	String command = e.getComponent().getName();
    	TextField from = (TextField) e.getComponent();
    	switch (command) {
        	case "txtFrom":
            	if (!context.txt_from.getText().equals("")) {
                	context.txt_to.setText(context.txt_from.getText());
                	context.page_lookPage.setLIMIT_RIGHT(Integer.parseInt(context.txt_to.getText()));
            	}
    	}
	}


}
