 
//import Impresora.ManagerEvents.*;

import java.awt.Choice;

public class Printer extends PrinterDefinition{
    
    public Printer() {
        clicks = new CustomActionListener(this);
        items = new CustomItemListener(this);
        keys = new CustomKeyListener(this);
        focus = new CustomFocusListener(this);
    }
    
    /** Prueb
     * @param args
     * @param argsa*/
    public static void main
        (String [] args){
        Printer p = new Printer();
        //Tamaño del frame principal
        Builder.buildFrame(p, "Printer", 860, 640, 300, 30, false).setVisible(true);            
        p.prepareGUI();
        
    }

    @Override
    public void imprimir() {
        
    }
    
}