/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomItemListener implements ItemListener {

    Printer context;

    public CustomItemListener(Printer f) {
        context = f;
        coverPage();
    	layout();
    	mediaquality();
    	paperHanding();
    	paperfeed();
    	printerfeatures();

    }

    @Override
    public void itemStateChanged(ItemEvent e) {        
        Component estorbo;
        String command = e.getItem().toString();
        switch (command) {
            case "Layout":
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                if ( context.panel_Layout!=null){
                    context.add(context.panel_Layout);
                }else layout();
                break;
            case "Preview":
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                if ( context.panel_preview!=null){
                    context.add(context.panel_preview);
                    //System.out.println("Impresora.CustomItemListener.itemStateChanged()");
                }else preview();
                break;
            case "Paper Handing":
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                if ( context.panel_PaperHandling!=null){
                    context.add(context.panel_PaperHandling);
                }else paperHanding();
                break;
            case "Cover Page":
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                if ( context.panel_CoverPage!=null){
                    context.add(context.panel_CoverPage);
                }else coverPage();
                break;
            case "Printer Features":
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                if ( context.panel_PrinterFeactures!=null){
                    context.add(context.panel_PrinterFeactures);
                }else printerfeatures();
                break;
            case "Paper Feed":
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                if ( context.panel_PaperFeed!=null){
                    context.add(context.panel_PaperFeed);
                }else paperfeed();
                break;
            case "Media & Quality":
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                if ( context.panel_MediaQuality!=null){
                    context.add(context.panel_MediaQuality);
                }else mediaquality();
                break;
            case "White&Black":
                if (context.getChbox_pageOnColor().getState()) {
                    context.page_lookPage.setColor("BLACK");
                } else {
                    context.page_lookPage.setColor("COLOR");
                }
                break;
            /**
             * Aqui empiezan las opciones de impresora
             */
            ///////////////////////////////////////////////////////////////
            case "HP LaserJet 1010":
                Setter.setChoice(context.choice_preview, context.items_laserjet1010, null);
                Setter.setChoice(context.ch_presets, context.items_presets, null);
                context.chbox_pageOnColor.setVisible(false);
                context.page_lookPage.setColor("COLOR");
                
                
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                context.getPage_lookPage().setColor("COLOR");
                if ( context.panel_preview!=null){
                    context.add(context.panel_preview);
                }else preview();
                break;

            case "Show Presets...":
                if (context.ch_printer.getSelectedIndex() == 0) {
                    PresetsColor p;
                    p = new PresetsColor();
                    context.ch_presets.select(0);
                } else {
                    Presets p;
                    p = new Presets();
                    context.ch_presets.select(0);
                }
                break;

            case "HP Color LaserJet Pro MFP M176n":
                Setter.setChoice(context.choice_preview, context.items_preview, null);
                Setter.setChoice(context.ch_presets, context.items_presets_color, null);
                context.chbox_pageOnColor.setVisible(true);
                context.chbox_pageOnColor.setState(false);
                estorbo = context.getComponentAt(new Point(490, 410));
                if (estorbo != null) {
                    context.remove(estorbo);
                }
                context.getPage_lookPage().setColor("COLOR");
                if ( context.panel_preview!=null){
                    context.add(context.panel_preview);
                }else preview();
                break;
            ////////////////////////////////////////////////////////////////
            /**
             * case "": break; case "": break; case "": break; case "": break;
             */

            /**
             * Aqui empiezan los eventos del los checkboxgroup
             */
            case "All":
            case "Selected Page in Sidebar":
                context.getTxt_from().setEnabled(false);
                context.getTxt_to().setEnabled(false);
                context.txt_from.setText("");
                context.txt_to.setText("");

                context.getPage_lookPage().reset();
                break;
            case "From:":
                context.getTxt_from().setEnabled(true);
                context.getTxt_to().setEnabled(true);
                context.getTxt_from().setText("1");
                context.getTxt_to().setText("");
                break;
            
            case "1":case "2":case "4":case "8":case "16":
                if (e.getSource().equals( context.choice_PagesPerSheet))
                context.page_lookPage.setCopiesperpage(Integer.parseInt(command));
                break;
            case "Scale:":
               
                context.getTxt_ScaletoFit().setEnabled(true);
                context.chbox_PrintEntireImage.setEnabled(false);
                context.chbox_FillEntirePaper.setEnabled(false);
                
                break;
            case "Scale to Fit:":
                context.getTxt_ScaletoFit().setEnabled(false);
                context.chbox_PrintEntireImage.setEnabled(true);
                context.chbox_FillEntirePaper.setEnabled(true);
                break;
                
            case "Collate pages":
                 context.ch_DestimationPaperSize.setEnabled(false);
                 context.chbox_Scaledownonly.setEnabled(false);
                 context.ch_PagesToPrint.setEnabled(true);
                 context.ch_PageOrder.setEnabled(true);
                break;
            case "Scale to fit paper size":
                context.ch_PagesToPrint.setEnabled(false);
                context.ch_PageOrder.setEnabled(false);
                context.ch_DestimationPaperSize.setEnabled(true);
                 context.chbox_Scaledownonly.setEnabled(true);
                break;
           
            case "None":
                context.choice_TwoSided.setEnabled(false);
                context.lb_TwoSided.setEnabled(false) ;
                
                break;
            case "3D":
                context.choice_TwoSided.setEnabled(true);
                context.lb_TwoSided.setEnabled(true) ;
                break;
            case "Square":
                context.choice_TwoSided.setEnabled(true);
                context.lb_TwoSided.setEnabled(true) ;
                break;
            case "All Pages From:":
                 context.ch_AllagesFrom.setEnabled(true);
                 context.ch_FirstPageFrom.setEnabled(false);
                 context.ch_RemainingFrom.setEnabled(false);
                 context.lb_RemainingFrom.setEnabled(false);
                break;
            case "First Page From:":
                context.ch_AllagesFrom.setEnabled(false);
                 context.ch_FirstPageFrom.setEnabled(true);
                 context.ch_RemainingFrom.setEnabled(true);
                 context.lb_RemainingFrom.setEnabled(true);
                break;
            case "None.":
                 context.ch_CoverPageType.setEnabled(false);
                 context.lb_CoverPageType.setEnabled(false);
                break;
            case "Before document":
                 context.ch_CoverPageType.setEnabled(true);
                 context.lb_CoverPageType.setEnabled(true);
                break;
            case "After document":
                context.ch_CoverPageType.setEnabled(true);
                 context.lb_CoverPageType.setEnabled(true);
                break;
            
        }
    }

void mediaquality() {
        //codigo para build panel
        context.panel_MediaQuality = Builder.createPanel(context, new Rectangle(390, 390, 390, 190));

        context.lb_Feedfrom = Builder.createLabel(context.panel_MediaQuality, "Feed from:", new Rectangle(30, 5, 150, 20));
        context.lb_Mediatype = Builder.createLabel(context.panel_MediaQuality, "Media type:", new Rectangle(20, 35, 150, 20));

        context.che_AllagesFrom = Builder.createChoice(context.panel_MediaQuality, new Rectangle(190, 5, 150, 20), context.items_AllagesFrom, this);
        context.che_FirstPageFrom = Builder.createChoice(context.panel_MediaQuality, new Rectangle(190, 35, 150, 20), context.items_FirstPageFrom, this);
    context.remove(context.panel_MediaQuality);
}

    void preview() {
        //codigo para build panel
        context.panel_preview = Builder.createPanel(context, new Rectangle(390, 390, 390, 190));

        //CHECAR EL GROUP
        context.chbox_AutoRotate = Builder.createCheckbox(context.panel_preview, "Auto Rotate", new Rectangle(20, 5, 100, 20), context.Auto_Show, false);
        context.chbox_ShowNotes = Builder.createCheckbox(context.panel_preview, "Show Notes", new Rectangle(190, 5, 100, 20), context.Auto_Show, false);
        context.chbox_Scale = Builder.createCheckbox(context.panel_preview, "Scale:", new Rectangle(20, 35, 100, 20), context.chbg_Scale, false,context.items);
        context.chbox_ScaletoFit = Builder.createCheckbox(context.panel_preview, "Scale to Fit:", new Rectangle(20, 65, 100, 20), context.chbg_Scale, false,context.items);
        context.chbox_PrintEntireImage = Builder.createCheckbox(context.panel_preview, "Print Entire Image", new Rectangle(190, 65, 120, 20), null, false);
        context.chbox_FillEntirePaper = Builder.createCheckbox(context.panel_preview, "Fill Entire Paper", new Rectangle(190, 95, 120, 20), null, false);

        context.txt_ScaletoFit = Builder.createTextField(context.panel_preview, new Rectangle(190, 35, 30, 20), "91", "Scaletxt", context.keys, true);
        context.lb_Scale =  Builder.createLabel(context.panel_preview, "%", new Rectangle(210, 35, 30, 20));
        context.lb_Copiesperpage = Builder.createLabel(context.panel_preview, "Copies per page:", new Rectangle(20, 125, 150, 20));

        context.ch_Copiesperpage = Builder.createChoice(context.panel_preview, new Rectangle(190, 125, 125, 20), context.items_CopiesPerPage, this);

    }

    void paperfeed() {
        //codigo para build panel
        context.panel_PaperFeed = Builder.createPanel(context, new Rectangle(390, 390, 390, 190));

        context.lb_RemainingFrom = Builder.createLabel(context.panel_PaperFeed, "Remaining From:", new Rectangle(35, 65, 150, 20));

        context.ch_AllagesFrom = Builder.createChoice(context.panel_PaperFeed, new Rectangle(190, 5, 150, 20), context.items_AllagesFrom, this);
        context.ch_FirstPageFrom = Builder.createChoice(context.panel_PaperFeed, new Rectangle(190, 35, 150, 20), context.items_FirstPageFrom, this);
        context.ch_RemainingFrom = Builder.createChoice(context.panel_PaperFeed, new Rectangle(190, 65, 150, 20), context.items_RemainingFrom, this);

        context.chbox_AllPagesFrom = Builder.createCheckbox(context.panel_PaperFeed, "All Pages From:", new Rectangle(20, 5, 150, 20), context.paper_feed, false,this);
        context.chbox_FirstPageFrom = Builder.createCheckbox(context.panel_PaperFeed, "First Page From:", new Rectangle(20, 35, 150, 20), context.paper_feed, false,this);
        context.remove(context.panel_PaperFeed);
    
    }

    void printerfeatures() {
        //codigo para build panel
        context.panel_PrinterFeactures = Builder.createPanel(context, new Rectangle(390, 390, 390, 190));

        context.lb_MediaType = Builder.createLabel(context.panel_PrinterFeactures, "Media Type:", new Rectangle(20, 5, 150, 20));
        context.lb_Resolution = Builder.createLabel(context.panel_PrinterFeactures, "Resolution:", new Rectangle(20, 35, 150, 20));

        context.ch_MediaType = Builder.createChoice(context.panel_PrinterFeactures, new Rectangle(190, 5, 150, 20), context.items_MediaType, this);
        context.ch_Resolution = Builder.createChoice(context.panel_PrinterFeactures, new Rectangle(190, 35, 150, 20), context.items_Resolution, this);

        context.chbox_REt = Builder.createCheckbox(context.panel_PrinterFeactures, "REt", new Rectangle(20, 65, 150, 20), null, false);
        context.chbox_EconoMode = Builder.createCheckbox(context.panel_PrinterFeactures, "EconoMode(Save Toner)", new Rectangle(20, 95, 150, 20), null, false);
        context.remove(context.panel_PrinterFeactures);
    }

    void coverPage() {
        //codigo para build panel
        context.panel_CoverPage = Builder.createPanel(context, new Rectangle(390, 390, 390, 190));

        context.chbox_None = Builder.createCheckbox(context.panel_CoverPage, "None.", new Rectangle(190, 5, 150, 20), context.chbg_NoneBeforeAfter, false,this);
        context.chbox_Beforedocument = Builder.createCheckbox(context.panel_CoverPage, "Before document", new Rectangle(190, 35, 150, 20), context.chbg_NoneBeforeAfter, false,this);
        context.chbox_Afterdocument = Builder.createCheckbox(context.panel_CoverPage, "After document", new Rectangle(190, 65, 150, 20), context.chbg_NoneBeforeAfter, false,this);

        context.lb_PrintCoverPage = Builder.createLabel(context.panel_CoverPage, "Print Cover Page:", new Rectangle(20, 5, 150, 20));
        context.lb_CoverPageType = Builder.createLabel(context.panel_CoverPage, "Cover Page Type:", new Rectangle(20, 95, 150, 20));

        context.ch_CoverPageType = Builder.createChoice(context.panel_CoverPage, new Rectangle(190, 95, 150, 20), context.items_CoverPageType, this);
        
        context.chbg_NoneBeforeAfter.setSelectedCheckbox(context.chbox_Beforedocument);
           context.remove(context.panel_CoverPage);
    }

    void paperHanding() {
        //codigo para build panel
        context.panel_PaperHandling = Builder.createPanel(context, new Rectangle(390, 390, 390, 190));

        context.chbox_Collatepages = Builder.createCheckbox(context.panel_PaperHandling, "Collate pages", new Rectangle(190, 5, 180, 20), context.paper_halding, false,this);
        context.chbox_Scaletofitpapersize = Builder.createCheckbox(context.panel_PaperHandling, "Scale to fit paper size", new Rectangle(190, 95, 180, 20),context.paper_halding, false,this);
        context.chbox_Scaledownonly = Builder.createCheckbox(context.panel_PaperHandling, "Scale down only", new Rectangle(190, 155, 180, 20), null, false);
        context.paper_halding.setSelectedCheckbox(context.chbox_Collatepages);
        context.lb_PagestoPrint = Builder.createLabel(context.panel_PaperHandling, "Pages to Print:", new Rectangle(20, 35, 150, 20));
        context.lb_PageOrder = Builder.createLabel(context.panel_PaperHandling, "Page Order:", new Rectangle(20, 65, 150, 20));
        context.lb_DestinationPaperSize = Builder.createLabel(context.panel_PaperHandling, "Destination Paper Size:", new Rectangle(20, 125, 150, 20));

        context.ch_PagesToPrint = Builder.createChoice(context.panel_PaperHandling, new Rectangle(190, 35, 180, 20), context.items_PagesToPrint, this);
        context.ch_PageOrder = Builder.createChoice(context.panel_PaperHandling, new Rectangle(190, 65, 180, 20), context.items_PageOrder, this);
        context.ch_DestimationPaperSize = Builder.createChoice(context.panel_PaperHandling, new Rectangle(190, 125, 180, 20), context.items_DestimationPaperSize, this);
        context.remove(context.panel_PaperHandling);
    }

    void layout() {
        //codigo para build panel
        context.panel_Layout = Builder.createPanel(context, new Rectangle(390, 390, 390, 190));

        context.lb_PagesperSheet = Builder.createLabel(context.panel_Layout, "Pages per Sheet", new Rectangle(20, 5, 150, 20));
        context.lb_LayoutDirection = Builder.createLabel(context.panel_Layout, "Layout Direction", new Rectangle(20, 35, 100, 20));
        context.lb_Border = Builder.createLabel(context.panel_Layout, "Border", new Rectangle(20, 65, 150, 20));
        context.lb_TwoSided = Builder.createLabel(context.panel_Layout, "Two-Sided", new Rectangle(20, 95, 150, 20));

        context.choice_Border = Builder.createChoice(context.panel_Layout, new Rectangle(190, 65, 150, 20), context.items_Border, this);
        context.choice_PagesPerSheet = Builder.createChoice(context.panel_Layout, new Rectangle(190, 5, 150, 20), context.items_PagesPerSheet, context.items);
        context.choice_TwoSided = Builder.createChoice(context.panel_Layout, new Rectangle(190, 95, 150, 20), context.items_TwoSided, this);
        //CHECAR IMAGENES
        context.btni_z = Builder.createButtonIcon(context.panel_Layout, "z", new Rectangle(150, 35, 30, 20), context.clicks, "resources/icons/1.png");
        context.btni_z1 = Builder.createButtonIcon(context.panel_Layout, "z1", new Rectangle(190, 35, 30, 20), context.clicks, "resources/icons/2.png");
        context.btni_n = Builder.createButtonIcon(context.panel_Layout, "n", new Rectangle(230, 35, 30, 20), context.clicks, "resources/icons/3.png");
        context.btni_n1 = Builder.createButtonIcon(context.panel_Layout, "n1", new Rectangle(270, 35, 30, 20), context.clicks, "resources/icons/4.png");

        context.chbox_Reversepageorientation = Builder.createCheckbox(context.panel_Layout, "Reverse page orientation", new Rectangle(190, 125, 200, 20), null, false);
        context.chbox_Fliphorizontally = Builder.createCheckbox(context.panel_Layout, "Flip horizontally", new Rectangle(190, 155, 150, 20), null, false);
        context.remove(context.panel_Layout);
    }
    
   
}
