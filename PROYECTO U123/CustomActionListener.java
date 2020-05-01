 

import java.awt.Component;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CustomActionListener implements ActionListener {

    Printer context;

    public CustomActionListener(Printer f) {
        context = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "<<":
                context.btn_back.setEnabled(false);
                context.btn_first.setEnabled(false);
                context.btn_next.setEnabled(true);
                context.btn_last.setEnabled(true);
                context.getPage_lookPage().first();
                break;
            case "<":
                context.getPage_lookPage().back();
                if (context.page_lookPage.isFirst()) {
                    context.btn_first.setEnabled(false);
                    context.btn_back.setEnabled(false);
                }
                context.btn_next.setEnabled(true);
                context.btn_last.setEnabled(true);
                break;
            case ">>":
                context.btn_back.setEnabled(true);
                context.btn_first.setEnabled(true);
                context.btn_next.setEnabled(false);
                context.btn_last.setEnabled(false);

                context.getPage_lookPage().last();
                break;
            case ">":
                context.getPage_lookPage().next();
                if (context.page_lookPage.isLast()){
                context.btn_next.setEnabled(false);
                context.btn_last.setEnabled(false);
                }
                context.btn_back.setEnabled(true);
                context.btn_first.setEnabled(true); 
                break;
            case "btn_horizontal":
                context.getPage_lookPage().setPosition(Page.Positions.HORIZONTAL);
                break;
            case "btn_vertical":
                context.getPage_lookPage().setPosition(Page.Positions.VERTICAL);
                break;
            case "Cancel":
                System.exit(0);
                break;
            case "Aceptar":
                System.exit(0);
                break;
            case "Hide Details":
                hideDetails();
                context.setVisible(false);
                break;
            case "Show Details":
                showDetails();
                context.repaint();
                context.btn_hide_details.setActionCommand("Hide Details");
                context.btn_hide_details.setLabel("Hide Details");
                break;
            case "z":
                context.page_lookPage.setLocacion("arriba-izq");
                break;
            case "z1":
                context.page_lookPage.setLocacion("arriba-der");
                break;
            case "n":
                context.page_lookPage.setLocacion("abajo-izq");
                break;
            case "n1":
                context.page_lookPage.setLocacion("abajo-der");
                break;
            case "Print":
                print();
                break;
        }
    }
    Component[] lista;
    Rectangle[] ubic;
    Frame hide;

    public void showDetails() {
        int i = 0;
        if (lista == null || ubic == null) {
            return;
        }
        for (Component c : lista) {
            Builder.add(context, c, ubic[i++]);
        }
        if (context.ch_printer.getSelectedIndex()!=0)context.chbox_pageOnColor.setVisible(false);
        lista = null;
        ubic = null;
        hide.setVisible(false);
        hide = null;
        context.setVisible(true);
    }

    public void hideDetails() {
        //Printer hidedetails = new Printer();
        hide = Builder.createFrame("Hide Details", 450, 650, 600, 30, true);
        Component[] list = {context.lb_printer, context.ch_printer, context.lb_presets, context.ch_presets,
            context.lb_copies, context.txt_copies, context.chbox_pageOnColor, context.lb_pages_group,
            context.page_lookPage, context.btn_first, context.btn_back, context.btn_last, context.btn_next,
            context.btn_hide_details, context.choice_opt_export, context.btn_Cancel, context.btn_print};
        /**
         * Transicion
         */
        lista = list;
        Rectangle[] respaldo = new Rectangle[list.length];
        int i = 0;
        for (Component c : list) {
            respaldo[i++] = c.getBounds();
        }
        ubic = respaldo;
        /**
         * Fin de la transicion
         */
        Builder.buildFrame(hide, "Hide Details", 450, 650, 600, 30, true);
        Builder.add(hide, context.lb_printer, new Rectangle(0, 40, 140, 24));
        Builder.add(hide, context.ch_printer, new Rectangle(150, 40, 140, 24));
        Builder.add(hide, context.lb_presets, new Rectangle(0, 70, 140, 24));
        Builder.add(hide, context.ch_presets, new Rectangle(150, 70, 140, 24));

        Builder.add(hide, context.lb_copies, new Rectangle(0, 100, 140, 24));
        Builder.add(hide, context.txt_copies, new Rectangle(150, 100, 60, 24));

        Builder.add(hide, context.chbox_pageOnColor, new Rectangle(230, 100, 140, 24));
        if (context.ch_printer.getSelectedIndex()!=0)context.chbox_pageOnColor.setVisible(false);
        

        Builder.add(hide, context.lb_pages_group, new Rectangle(0, 130, 140, 24));
        Builder.add(hide, new TextField("1"), new Rectangle(150, 130, 140, 24));
        if (context.page_lookPage.position == Page.Positions.HORIZONTAL) {
            Builder.add(hide, context.getPage_lookPage(), context.getPage_lookPage().getBounds());
            context.getPage_lookPage().setLocation(context.getPage_lookPage().getLocation().x, context.getPage_lookPage().getLocation().y + 100);
        } else {
            Builder.add(hide, context.getPage_lookPage(), new Rectangle(80, 170, 281, 363));
        }
        Builder.add(hide, context.getBtn_first(), new Rectangle(90, 540, 30, 24));
        Builder.add(hide, context.getBtn_back(), new Rectangle(140, 540, 30, 24));
        Builder.add(hide, context.getBtn_last(), new Rectangle(310, 540, 30, 24));
        Builder.add(hide, context.getBtn_next(), new Rectangle(260, 540, 30, 24));
        /**
         * context.chbox_pageOnColor = Builder.createCheckbox(context,
         * "White&Black", new Rectangle(230, 100, 140, 24), null, true,
         * context.items, context.chbox_pageOnColor.getState(),
         * context.ch_printer.getSelectedItem().equals("HP Color LaserJet Pro
         * MFP M176n") ? true : false);
         */
        Builder.add(hide, context.btn_hide_details, new Rectangle(160, 590, 90, 24));
        context.btn_hide_details.setActionCommand("Show Details");
        context.btn_hide_details.setLabel("Show Details");

        Builder.add(hide, context.choice_opt_export, new Rectangle(10, 590, 140, 20));
        Builder.add(hide, context.btn_Cancel, new Rectangle(260, 590, 100, 24));
        Builder.add(hide, context.btn_print, new Rectangle(370, 590, 90, 24));
        hide.setVisible(true);
        /**
         * context.btn_hide_details = Builder.createButton(context, "Show
         * Details", new Rectangle(160, 590, 90, 24), context.clicks);
         * context.choice_opt_export = Builder.createChoice(context, new
         * Rectangle(10, 590, 140, 20), context.items_opt_export,
         * context.items); Builder.add(context, context.getBtn_Cancel(), new
         * Rectangle(260, 590, 100, 24)); Builder.add(context,
         * context.getBtn_print(), new Rectangle(370, 590, 90, 24));
         */
    }
    
     void print(){
    context.Imprimir = Builder.createFrame("Imprimir", 350, 400,575, 200, true);
    //Builder.buildFrame(context.Imprimir, "Imprimir", 300, 300, 600, 250, true);
    Builder.createLabelL(context.Imprimir, "OPCIONES PREFERIDAS", new Rectangle(100, 35,200, 30));
    
    Builder.createLabel(context.Imprimir, "Printer:", new Rectangle(50,90,40, 30));
    Builder.createLabelL(context.Imprimir, context.getCh_printer().getSelectedItem(), new Rectangle(100,90,260, 30));
    
    Builder.createLabel(context.Imprimir, "Copies:", new Rectangle(45,120,45, 30));
    Builder.createLabelL(context.Imprimir,context.getTxt_copies().getText(), new Rectangle(100,120,260, 30));
    
    Builder.createLabel(context.Imprimir, "Page:", new Rectangle(40,150,50, 30));
    if(context.getGroup_opts_pages().getSelectedCheckbox().getLabel().equalsIgnoreCase("From:")){
    Builder.createLabelL(context.Imprimir, context.getTxt_from().getText()
                         +"-"+context.getTxt_to().getText(), new Rectangle(100,150,200, 30));
    }else{
      Builder.createLabelL(context.Imprimir,context.getGroup_opts_pages().getSelectedCheckbox().getLabel()
                          , new Rectangle(100,150,200, 30));
    }
    
    Builder.createLabel(context.Imprimir, "Paper Size:", new Rectangle(20,180,70, 30));
    Builder.createLabelL(context.Imprimir, context.getCh_paper_size().getSelectedItem(), new Rectangle(100,180,260, 30));
   
    Builder.createLabel(context.Imprimir, "Copie p/pg:", new Rectangle(20,210,70, 30));
    Builder.createLabelL(context.Imprimir, context.getCh_Copiesperpage().getSelectedItem(), new Rectangle(100,210,260, 30));
    
    Builder.createLabel(context.Imprimir, "Border:", new Rectangle(20,240,70, 30));
    Builder.createLabelL(context.Imprimir, context.choice_Border.getSelectedItem(), new Rectangle(100,240,260, 30));
    
     Builder.createLabel(context.Imprimir, "P. Handling:", new Rectangle(20,270,70, 30));
     Builder.createLabelL(context.Imprimir, context.paper_halding.getSelectedCheckbox().getLabel(), new Rectangle(100,270,260, 30));
     
     Builder.createLabel(context.Imprimir, "Cover Page:", new Rectangle(20,300,70, 30));
     Builder.createLabelL(context.Imprimir, context.chbg_NoneBeforeAfter.getSelectedCheckbox().getLabel(), new Rectangle(100,300,260, 30));
     
     Builder.createButton(context.Imprimir, "Aceptar", new Rectangle(130,350,100, 30), this);
    context.Imprimir.setVisible(true);
    }
}
