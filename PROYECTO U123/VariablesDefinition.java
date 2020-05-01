 

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public abstract class VariablesDefinition extends Frame {

    /**
     * Items para los choices
     */
    String[] items_printer = {"HP Color LaserJet Pro MFP M176n", "HP LaserJet 1010", "Samsung M2020 Series", "Add Printer...", "Printers & Scanners Preferences..."}; //completar completar
    
    String[] items_presets = {"Default Settings", "Last Used Settings ", "Save Current Settings as Preset...", "Show Presets..."}; //completar completar
    //// AGREGAR DESPUES 
    String[] items_presets_color ={"Default Settings", "Last Used Settings ","Black and White","Black and White - Draft","Color", "Save Current Settings as Preset...", "Show Presets..."};
    //////////////////////////////////////////////
    String[] items_paper_size = {"Manage Custom Size", "US Letter","US Legal", "Postcard Double Longe Edge", "Postcard", "Photo or 5x7 inch index card ", "Photo or 4x6 inch index card ", "JIS B5", "Excutive (JIS) ",
        "Excutive", "Evelope Monarch", "Evelope DL", "Evelope C6", "Evelope C5", "Evelope B5", "Evelope #10 ", "CD or DVD 120 mm", "CD or DVD 80 mm", "A6", "A5", "A4", "16K", "5 x 8", "3 x 5"};
    String[] items_opt_export = {"Open PDF in Preview", "Save as PDF...", "Save as PostScript...", "Add PDF to iBooks", "Mail PDF", "Save PDF to iCloud", "Save PDF to Web Receipts Folder", "Send PDF via Messages"};
    String[] items_preview = {"Preview", "Layout", "Paper Handing","Media & Quality","Cover Page"};
    String[] items_laserjet1010 = {"Preview", "Layout", "Paper Handing", "Paper Feed", "Cover Page", "Printer Features"};
    
    /**
     * Variables para los items de los paneles que se abren cada que se crea un nuevo panel Made by Carlos
     */
    String [] items_PagesPerSheet = { "1","2","4","8","16" };
    String [] items_Border = { "None","3D","Square" };
    String [] items_TwoSided = { "On","Off"};
    String [] items_CopiesPerPage = {"1","2","3","4","5"};
    String [] items_PagesToPrint = { "All pages","Actual page"};
    String [] items_PageOrder = { "Automatic"};
    String [] items_DestimationPaperSize = { "Suggested Paper: US Letter"};
    String [] items_CoverPageType = { "Standard","Unclassified","Secret","Top Secret"};
    String [] items_MediaType = {"Plain Paper","Bond","Color","Evelope","Labels","Lettherhead","Prepinted","Prepunched","Recycled","Transparency","Cardstock(106-176g/sq.m)"};
    String [] items_Resolution ={"FastRes 1200","EconoMode(Save Toner)"};
    String [] items_AllagesFrom ={"Auto Select","Manual Feed","Tray 1"};
    String [] items_FirstPageFrom ={"Printer Auto Selection","Manual Feed","Auto Select"};
    String [] items_RemainingFrom ={"Printer Auto Selection","Manual Feed","Auto Select"};
    String [] items_FeedFrom ={};
    String [] items_MediaType_MediaQuality = {"Auto Select","Manual Select"};


    public VariablesDefinition() {
    }
    Frame Imprimir;
    //Panel panel_preview;
    Panel panel_Layout;
    Panel panel_PaperHandling;
    Panel panel_PaperFeed;
    Panel panel_CoverPage;
    Panel panel_PrinterFeactures;
    Panel panel_MediaQuality;
    // Choice choice_copiesxpage;
    Choice choice_opt_export;
    Choice choice_preview;
    //
    Choice choice_presets;
    Choice choice_presets_color;
    Choice choice_printer;
    Choice choice_paperSize;
    Choice choice_HD_copies;
    Choice chborder;
    
    //Formato de nombre {tipo_componente}_{nombre}
    Label lb_printer;
    Label lb_presets;
    Label lb_copies;
    Label lb_pages_group;
    Label lb_paperSize;
    Label lb_orientation;
    Label lb_Scale;
    ////Paneles de la impresora LaserJet
    Panel panel_preview;
    //    Panel panel_Layout;
    Panel panel_Paper;
    Panel panel_Feed;
    Panel panel_Page;
    Panel p_Feactures;
    ////////////////////////////
    /**
     *
     */
    Choice ch_printer, ch_presets;
    TextField txt_copies;
    Checkbox chbox_pageOnColor;
    CheckboxGroup group_opts_pages = new CheckboxGroup();
    Checkbox chbox_all, chbox_select_pages, chbox_from;
    Label lb_from_to_pages;
    TextField txt_from;
    
    TextField txt_to;
    Choice ch_paper_size;
    Label lb_paper_size_dim;

    //Buttons
    ButtonIcon btn_horizontal;
    ButtonIcon btn_vertical;

    //Botones para controlar la hoja
    Button btn_back;
    Button btn_next;
    Label lb_of_to;
    Button btn_first;
    Button btn_last;
    //Botones de la barra opciones de control de Panel de impresion
    Button btn_hide_details;
    Button btn_info;
    Button btn_Acept;
    Button btn_print;
    Button btn_Cancel;
    
    /**
     * CArlangas
     */

    Label lb_PagesperSheet;
    Label lb_LayoutDirection;
    Label lb_Border;
    Label lb_TwoSided;
    
    Choice choice_Border;
    Choice choice_PagesPerSheet;
    Choice choice_TwoSide;
    
    ButtonIcon btni_z;
    ButtonIcon btni_z1;
    ButtonIcon btni_n;
    ButtonIcon btni_n1;
    
    Checkbox chbox_Reversepageorientation;
    Checkbox chbox_Fliphorizontally;
    //panel_PREview
    CheckboxGroup chbg_Scale = new CheckboxGroup();
    CheckboxGroup Auto_Show = new CheckboxGroup();
    CheckboxGroup paper_halding = new CheckboxGroup();
    CheckboxGroup paper_feed = new CheckboxGroup();
    Checkbox chbox_AutoRotate;
    Checkbox chbox_ShowNotes;
    Checkbox chbox_Scale;
    Checkbox chbox_ScaletoFit ;
    Checkbox chbox_PrintEntireImage;
    Checkbox chbox_FillEntirePaper;
    
     TextField txt_ScaletoFit;
     
     Label lb_Copiesperpage;
     
     Choice ch_Copiesperpage;
     //panel_Paper handling
     Checkbox chbox_Collatepages;
    Checkbox chbox_Scaletofitpapersize;
    Checkbox chbox_Scaledownonly;
    
    Label lb_PagestoPrint;
    Label lb_PageOrder;
    Label lb_DestinationPaperSize;
    
    Choice ch_PagesToPrint;
    Choice ch_PageOrder;
    Choice ch_DestimationPaperSize;
    //panel_Cover page
    CheckboxGroup chbg_NoneBeforeAfter = new CheckboxGroup();
    Checkbox chbox_None;
    Checkbox chbox_Beforedocument;
    Checkbox chbox_Afterdocument;
    
    Label lb_PrintCoverPage;
    Label lb_CoverPageType;
    
    Choice ch_CoverPageType;
    
    //panel_Printer Features
    Label lb_MediaType;
    Label lb_Resolution;
    
    Choice ch_MediaType;
    Choice ch_Resolution;
    
    Checkbox chbox_REt;
    Checkbox chbox_EconoMode;
    
    //panel_Paper Feed
     Label lb_RemainingFrom;
     
     Choice ch_AllagesFrom;
    Choice ch_FirstPageFrom;
    Choice ch_RemainingFrom;
    
    Checkbox chbox_AllPagesFrom;
    Checkbox chbox_FirstPageFrom;
    //panel_Media & Quality
    Label lb_Feedfrom;
    Label lb_Mediatype;
    
    Choice che_AllagesFrom;
    Choice che_FirstPageFrom ;

    Choice choice_TwoSided;

    public String[] getItems_printer() {
        return items_printer;
    }

    public String[] getItems_presets() {
        return items_presets;
    }

    public String[] getItems_paper_size() {
        return items_paper_size;
    }

    public String[] getItems_opt_export() {
        return items_opt_export;
    }

    public String[] getItems_preview() {
        return items_preview;
    }

    public String[] getItems_PagesPerSheet() {
        return items_PagesPerSheet;
    }

    public String[] getItems_Border() {
        return items_Border;
    }

    public String[] getItems_TwoSided() {
        return items_TwoSided;
    }

    public String[] getItems_CopiesPerPage() {
        return items_CopiesPerPage;
    }

    public String[] getItems_PagesToPrint() {
        return items_PagesToPrint;
    }

    public String[] getItems_PageOrder() {
        return items_PageOrder;
    }

    public String[] getItems_DestimationPaperSize() {
        return items_DestimationPaperSize;
    }

    public String[] getItems_CoverPageType() {
        return items_CoverPageType;
    }

    public String[] getItems_MediaType() {
        return items_MediaType;
    }

    public String[] getItems_Resolution() {
        return items_Resolution;
    }

    public String[] getItems_AllagesFrom() {
        return items_AllagesFrom;
    }

    public String[] getItems_FirstPageFrom() {
        return items_FirstPageFrom;
    }

    public String[] getItems_RemainingFrom() {
        return items_RemainingFrom;
    }

    public String[] getItems_FeedFrom() {
        return items_FeedFrom;
    }

    public String[] getItems_MediaType_MediaQuality() {
        return items_MediaType_MediaQuality;
    }

    public Panel getPanel_Layout() {
        return panel_Layout;
    }

    public Panel getPanel_PaperHandling() {
        return panel_PaperHandling;
    }

    public Panel getPanel_PaperFeed() {
        return panel_PaperFeed;
    }

    public Panel getPanel_CoverPage() {
        return panel_CoverPage;
    }

    public Panel getPanel_PrinterFeactures() {
        return panel_PrinterFeactures;
    }

    public Panel getPanel_MediaQuality() {
        return panel_MediaQuality;
    }

    public Choice getChoice_opt_export() {
        return choice_opt_export;
    }

    public Choice getChoice_preview() {
        return choice_preview;
    }

    public Choice getChoice_presets() {
        return choice_presets;
    }

    public Choice getChoice_presets_color() {
        return choice_presets_color;
    }

    public Choice getChoice_printer() {
        return choice_printer;
    }

    public Choice getChoice_paperSize() {
        return choice_paperSize;
    }

    public Choice getChoice_HD_copies() {
        return choice_HD_copies;
    }

    public Choice getChborder() {
        return chborder;
    }

    public Panel getPanel_preview() {
        return panel_preview;
    }

    public Panel getPanel_Paper() {
        return panel_Paper;
    }

    public Panel getPanel_Feed() {
        return panel_Feed;
    }

    public Panel getPanel_Page() {
        return panel_Page;
    }

    public Panel getP_Feactures() {
        return p_Feactures;
    }

    public Choice getCh_printer() {
        return ch_printer;
    }

    public Choice getCh_presets() {
        return ch_presets;
    }

    public TextField getTxt_copies() {
        return txt_copies;
    }

    public Checkbox getChbox_pageOnColor() {
        return chbox_pageOnColor;
    }

    public CheckboxGroup getGroup_opts_pages() {
        return group_opts_pages;
    }

    public Checkbox getChbox_all() {
        return chbox_all;
    }

    public Checkbox getChbox_select_pages() {
        return chbox_select_pages;
    }

    public Checkbox getChbox_from() {
        return chbox_from;
    }

    public TextField getTxt_from() {
        return txt_from;
    }

    public TextField getTxt_to() {
        return txt_to;
    }

    public Choice getCh_paper_size() {
        return ch_paper_size;
    }

    public ButtonIcon getBtn_horizontal() {
        return btn_horizontal;
    }

    public ButtonIcon getBtn_vertical() {
        return btn_vertical;
    }

    public Button getBtn_back() {
        return btn_back;
    }

    public Button getBtn_next() {
        return btn_next;
    }

    public Label getLb_of_to() {
        return lb_of_to;
    }

    public Button getBtn_first() {
        return btn_first;
    }

    public Button getBtn_last() {
        return btn_last;
    }

    public Button getBtn_hide_details() {
        return btn_hide_details;
    }

    public Button getBtn_info() {
        return btn_info;
    }

    public Button getBtn_Acept() {
        return btn_Acept;
    }

    public Button getBtn_print() {
        return btn_print;
    }

    public Button getBtn_Cancel() {
        return btn_Cancel;
    }

    public Choice getChoice_Border() {
        return choice_Border;
    }

    public Choice getChoice_PagesPerSheet() {
        return choice_PagesPerSheet;
    }

    public Choice getChoice_TwoSide() {
        return choice_TwoSide;
    }

    public ButtonIcon getBtni_z() {
        return btni_z;
    }

    public ButtonIcon getBtni_z1() {
        return btni_z1;
    }

    public ButtonIcon getBtni_n() {
        return btni_n;
    }

    public ButtonIcon getBtni_n1() {
        return btni_n1;
    }

    public Checkbox getChbox_Reversepageorientation() {
        return chbox_Reversepageorientation;
    }

    public Checkbox getChbox_Fliphorizontally() {
        return chbox_Fliphorizontally;
    }

    public CheckboxGroup getChbg_Scale() {
        return chbg_Scale;
    }

    public Checkbox getChbox_AutoRotate() {
        return chbox_AutoRotate;
    }

    public Checkbox getChbox_ShowNotes() {
        return chbox_ShowNotes;
    }

    public Checkbox getChbox_Scale() {
        return chbox_Scale;
    }

    public Checkbox getChbox_ScaletoFit() {
        return chbox_ScaletoFit;
    }

    public Checkbox getChbox_PrintEntireImage() {
        return chbox_PrintEntireImage;
    }

    public Checkbox getChbox_FillEntirePaper() {
        return chbox_FillEntirePaper;
    }

    public TextField getTxt_ScaletoFit() {
        return txt_ScaletoFit;
    }

    public Choice getCh_Copiesperpage() {
        return ch_Copiesperpage;
    }

    public Checkbox getChbox_Collatepages() {
        return chbox_Collatepages;
    }

    public Checkbox getChbox_Scaletofitpapersize() {
        return chbox_Scaletofitpapersize;
    }

    public Checkbox getChbox_Scaledownonly() {
        return chbox_Scaledownonly;
    }

    public Choice getCh_PagesToPrint() {
        return ch_PagesToPrint;
    }

    public Choice getCh_PageOrder() {
        return ch_PageOrder;
    }

    public Choice getCh_DestimationPaperSize() {
        return ch_DestimationPaperSize;
    }

    public CheckboxGroup getChbg_NoneBeforeAfter() {
        return chbg_NoneBeforeAfter;
    }

    public Checkbox getChbox_None() {
        return chbox_None;
    }

    public Checkbox getChbox_Beforedocument() {
        return chbox_Beforedocument;
    }

    public Checkbox getChbox_Afterdocument() {
        return chbox_Afterdocument;
    }

    public Choice getCh_CoverPageType() {
        return ch_CoverPageType;
    }

    public Choice getCh_MediaType() {
        return ch_MediaType;
    }

    public Choice getCh_Resolution() {
        return ch_Resolution;
    }

    public Checkbox getChbox_REt() {
        return chbox_REt;
    }

    public Checkbox getChbox_EconoMode() {
        return chbox_EconoMode;
    }

    public Choice getCh_AllagesFrom() {
        return ch_AllagesFrom;
    }

    public Choice getCh_FirstPageFrom() {
        return ch_FirstPageFrom;
    }

    public Choice getCh_RemainingFrom() {
        return ch_RemainingFrom;
    }

    public Checkbox getChbox_AllPagesFrom() {
        return chbox_AllPagesFrom;
    }

    public Checkbox getChbox_FirstPageFrom() {
        return chbox_FirstPageFrom;
    }

    public Choice getChe_AllagesFrom() {
        return che_AllagesFrom;
    }

    public Choice getChe_FirstPageFrom() {
        return che_FirstPageFrom;
    }

    public Choice getChoice_TwoSided() {
        return choice_TwoSided;
    }
    
}
