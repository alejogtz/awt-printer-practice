 

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;

public class Setter {

    public static Choice setChoice(Choice choice, String[] opts, Rectangle r, Object... configs) {
        Choice c = choice;
        if (c == null) {
            c = new Choice();
        }
        if (r != null) {
            choice.setBounds(r);
        }
        if (opts != null) {
            c.removeAll();
            for (String o : opts) {
                c.add(o);
            }
        }
        if (configs != null) {
            //TODO: agregar las configuraciones que sean necesarias
        }
        return c;
    }

    public static void setTxt(TextField txt, String text, Rectangle r, Boolean visible, Boolean enabled, Object... configs) {
        TextField t = txt;
        if (t == null) {
            t = new TextField();
        }
        if (text != null) {
            t.setText(text);
        }
        if (r != null) {
            t.setBounds(r);
        }
        if (visible != null) {
            t.setVisible(visible);
        }
        if (enabled != null) {
            t.setEnabled(enabled);
        }
        if (configs != null) {

        }
    }

    public static void setLabel(Label txt, String text, Rectangle r, Boolean visible, Boolean enabled, Object... configs) {
        Label t = txt;
        if (t == null) {
            t = new Label();
        }
        if (configs != null) {
            //configs [0] es contenedor
            Container p = (Frame)configs [0];
            p.add(txt);
        }
        if (text != null) {
            t.setText(text);
        }
        if (r != null) {
            t.setBounds(r);
        }
        if (visible != null) {
            t.setVisible(visible);
        }
        if (enabled != null) {
            t.setEnabled(enabled);
        }
    }

    public static void setPanel(Frame contenedor, Panel panel, Rectangle r, Boolean visible, Boolean enabled, Object... configs) {
        Panel t = panel;
        
        if (r != null) {
            t.setBounds(r);
        }
        if (visible != null) {
            t.setVisible(visible);
        }
        if (enabled != null) {
            t.setEnabled(enabled);
        }
        if (configs != null) {

        }
    }
}
