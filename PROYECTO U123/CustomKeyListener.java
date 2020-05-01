 

import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class CustomKeyListener extends KeyAdapter {

    Printer context;

    public CustomKeyListener(Printer f) {
        context = f;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	//System.err.println(e.getKeyChar() + " - " + e.getKeyCode());
    	//if (!valido(e)) e.consume();
    	String name = e.getComponent().getName();
    	TextField x;
    	Integer from;
    	switch (name) {
        	case "txtCopies":
            	if (!isValido(e)) {
                	e.consume();
            	}
            	break;
        	case "txtFrom":
            	if (Character.isDigit(e.getKeyChar())) {
                	x = (TextField) e.getComponent();
                	if (x.getSelectedText().equals("")) {
                    	from = Integer.parseInt(x.getText() + "" + e.getKeyChar());
                	} else {
                    	from = Integer.parseInt("" + e.getKeyChar());
                	}
                	if (from > context.getPage_lookPage().getCantPages()) {
                    	e.consume();
                    	break;
                	}
                	context.getPage_lookPage().setLIMIT_LEFT(from);
 
            	} else if (!isControl(e)) {
                	e.consume();
            	}
            	break;
        	case "txtTo":
            	if (Character.isDigit(e.getKeyChar())) {
                	x = (TextField) e.getComponent();
                	Integer to;
                	if (x.getSelectedText().equals("")) {
                    	to = Integer.parseInt(x.getText() + "" + e.getKeyChar());
                	} else {
                    	to = Integer.parseInt("" + e.getKeyChar());
                	}
                	from = !context.txt_from.getText().equals("") ? Integer.parseInt(context.txt_from.getText()) : 1;
                	if (to > context.getPage_lookPage().getCantPages() || to < from) {
                    	e.consume();
                    	break;
                	}
                	context.getPage_lookPage().setLIMIT_RIGHT(to);
            	} else if (!isControl(e)) {
                	e.consume();
            	}
            	break;
                
                case "Scaletxt":
                x = (TextField) e.getComponent();
                Integer Scale = Integer.parseInt(x.getText().concat("" + e.getKeyChar()));
                 
                if (Scale > 100 ) {
                    e.consume();
                    break;
                }
                
                   break;
 
    	}
	}
 
	/**
 	* @Override public void keyReleased(KeyEvent e) { String name =
 	* e.getComponent().getName(); TextField x; Integer from; switch (name) {
 	* case "txtFrom": if (Character.isDigit(e.getKeyChar())){ x = (TextField)
 	* e.getComponent();
 	*
 	* from = Integer.parseInt(x.getText()); if (from >
 	* context.getPage_lookPage().getCantPages()) { e.consume(); break; }
 	* context.getPage_lookPage().setLIMIT_LEFT(from); } break; } }
 	*/
	private boolean isValido(KeyEvent e) {
    	return (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || Character.isDigit(e.getKeyChar())
            	|| e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT
            	|| e.getKeyCode() == KeyEvent.VK_DELETE);
	}
 
	private boolean isControl(KeyEvent e) {
    	return (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_LEFT
            	|| e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_DELETE);
	}

}
