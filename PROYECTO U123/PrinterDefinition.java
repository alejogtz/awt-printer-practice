 
//import Impresora.ManagerEvents.*;

import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;

public abstract class PrinterDefinition extends VariablesDefinition {

    /**
     * Configuration of impresion
     */
    //End Configuration
    public PrinterDefinition() {
    }
    CustomItemListener items;
    CustomActionListener clicks;// = new CustomActionListener(null);
    CustomKeyListener keys;
    CustomFocusListener focus;
    Page page_lookPage;

    public abstract void imprimir();

    protected void prepareGUI() {
        int w = 110, h = 30;
        lb_printer = Builder.createLabel(this, "Printer:", new Rectangle(395, 55, w, h));
        lb_presets = Builder.createLabel(this, "Presets:", new Rectangle(395, 90, w, h));
        lb_copies = Builder.createLabel(this, "Copies:", new Rectangle(395, 125, w, h));
        lb_pages_group = Builder.createLabel(this, "Pages:", new Rectangle(395, 165, w, h));
        lb_paperSize = Builder.createLabel(this, "Paper Size:", new Rectangle(395, 260, w, h));
        lb_paper_size_dim = Builder.createLabel(this, "216 by 279", new Rectangle(765, 265, 80, h), Label.LEFT);
        lb_orientation = Builder.createLabel(this, "Orientation:", new Rectangle(395, 310, w, h));
        lb_from_to_pages = Builder.createLabel(this, "to", new Rectangle(640, 230, 20, 20));
        
        lb_of_to = Builder.createLabel(this, "1 of ", new Rectangle(140, 430, 60, 24), Label.CENTER);

        ch_printer = Builder.createChoice(this, new Rectangle(430 + 100, 60, 220, 21), items_printer, items);
        ch_presets = Builder.createChoice(this, new Rectangle(430 + 100, 95, 220, 21), items_presets, items);
        ch_paper_size = Builder.createChoice(this, new Rectangle(430 + 100, 265, 220, 21), items_paper_size, items);

        chbox_pageOnColor = Builder.createCheckbox(this, "White&Black", new Rectangle(660, 125, 120, 21), null, false, items, true, true);
        txt_copies = Builder.createTextField(this, new Rectangle(430 + 100, 130, 70, 21),"1","txtCopies", keys, true);
        
        group_opts_pages = new CheckboxGroup();
        chbox_all = Builder.createCheckbox(this, "All", new Rectangle(430 + 100, 170, 190, 21), group_opts_pages, true, items);
        chbox_select_pages = Builder.createCheckbox(this, "Selected Page in Sidebar", new Rectangle(430 + 100, 200, 190, 20), group_opts_pages, false, items);
        chbox_from = Builder.createCheckbox(this, "From:", new Rectangle(430 + 100, 230, 63, 21), group_opts_pages, false, items);
        
        txt_from = Builder.createTextField(this, new Rectangle(430 + 170, 230, 30, 20),"1","txtFrom", keys, false, focus);
        txt_to = Builder.createTextField(this, new Rectangle(430 + 250, 230, 30, 20),"","txtTo", keys, false, focus);      
        
        
        btn_first = Builder.createButton(this, "<<", new Rectangle(50, 430, 30, 24), clicks);
        btn_first.setEnabled(false);
        btn_back = Builder.createButton(this, "<", new Rectangle(100, 430, 23, 24), clicks);
        btn_back.setEnabled(false);
        btn_next = Builder.createButton(this, ">", new Rectangle(220, 430, 23, 24), clicks);
        btn_last = Builder.createButton(this, ">>", new Rectangle(263, 430, 30, 24), clicks);
        
        btn_Cancel = Builder.createButton(this, "Cancel", new Rectangle(620, 590 , 100, 24), clicks);
        btn_print = Builder.createButton(this, "Print", new Rectangle(740, 590 , 90, 24), clicks);

        btn_horizontal = Builder.createButtonIcon(this, "btn_horizontal", new Rectangle(430 + 100, 300, 40, 40), clicks, "./resources/icons/Horizontal.png");
        btn_vertical = Builder.createButtonIcon(this, "btn_vertical", new Rectangle(430 + 160, 300, 40, 40), clicks, "./resources/icons/Vertical.png");

        btn_hide_details = Builder.createButton(this, "Hide Details", new Rectangle(200, 590 , 90, 24), clicks);
        choice_opt_export = Builder.createChoice(this, new Rectangle(30, 590, 140, 20), items_opt_export, items);
        choice_preview = Builder.createChoice(this, new Rectangle(490 , 360, 150, 20), items_preview, items);
        //panel_preview = Builder.createPanel(this, new Rectangle(480,350,390,240));

        /**Agregando el panel Hoja*/
        page_lookPage = new Page(lb_of_to);
        Builder.add(this, page_lookPage, new Rectangle(30, 50, 281, 363));
        /**
         * Panel preview, es el que inicia por default
         */   
        //Modificado x = 480 y= 360
        panel_preview = Builder.createPanel(this, new Rectangle(390, 390, 390, 190));

        //CHECAR EL GROUP
        chbox_AutoRotate = Builder.createCheckbox(this.panel_preview, "Auto Rotate", new Rectangle(20, 5, 100, 20), Auto_Show, false);
        chbox_ShowNotes = Builder.createCheckbox(this.panel_preview, "Show Notes", new Rectangle(190, 5, 100, 20), Auto_Show, false);
        chbox_Scale = Builder.createCheckbox(this.panel_preview, "Scale:", new Rectangle(20, 35, 100, 20), chbg_Scale, false, items);
        chbox_ScaletoFit = Builder.createCheckbox(this.panel_preview, "Scale to Fit:", new Rectangle(20, 65, 100, 20), chbg_Scale, false, items);
        chbox_PrintEntireImage = Builder.createCheckbox(this.panel_preview, "Print Entire Image", new Rectangle(190, 65, 100, 20), null, false,items);
        chbox_FillEntirePaper = Builder.createCheckbox(this.panel_preview, "Fill Entire Paper", new Rectangle(190, 95, 100, 20), null, false);

        txt_ScaletoFit = Builder.createTextField(this.panel_preview, new Rectangle(190, 35, 30, 20),"91","Scaletxt", keys, true);
        lb_Scale =  Builder.createLabel(this.panel_preview, "%", new Rectangle(210, 35, 30, 20)); 
        lb_Copiesperpage = Builder.createLabel(this.panel_preview, "Copies per page:", new Rectangle(20, 125, 150, 20));

        ch_Copiesperpage = Builder.createChoice(this.panel_preview, new Rectangle(190, 125, 125, 20), items_CopiesPerPage, items);
    
    }
     
    public Page getPage_lookPage() {
        return page_lookPage;
    }

}
