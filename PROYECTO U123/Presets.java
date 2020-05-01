/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author carlosA
 */
import java.awt.*;
import java.awt.event.*;
public class Presets
{
    private Frame mainFrame;
    private Button Duplicate;
    private Button Delete;
    private Button OK;
    private Label presets;
    private Label setting;
    private Label value;
    private Button Cancel;
    private Panel controlPanel;
    private Panel controlScroll;
    private Scrollbar verticalScroller;
    private Checkbox marcar;
    public Presets(){
        prepareGUI();
        showListDemo();
    }

   

    public void prepareGUI(){

        mainFrame = new Frame("Java AWT Examples");
        mainFrame.setSize(700,700);
        mainFrame.setLocation(350, 30);
        mainFrame.setLayout(null);
         mainFrame.setUndecorated(true);

        presets = new Label("Presets");
        presets.setBounds(30,30,200,20);
        presets.setBackground(Color.lightGray);

        setting = new Label("Setting");
        setting.setBounds(240,30,250,20);
        setting.setBackground(Color.lightGray);

        value = new Label("Value");
        value.setBounds(490,30,180,20);
        value.setBackground(Color.lightGray);

        Delete = new Button("Delete");
        Delete.setBounds(30,480,70,20);
         Delete.setEnabled(false);

        Duplicate = new Button("Duplicate");
        Duplicate.setBounds(110,480,70,20);
         Duplicate.setEnabled(false);

        OK = new Button("OK");
        OK.setBounds(600,650,70,20);
        OK.setBackground(Color.BLUE);
        OK.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent we){
                    mainFrame.dispose();
                }
            });

        Cancel = new Button("Cancel");
        Cancel.setBounds(520,650,70,20);
        Cancel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent we){
                    mainFrame.dispose();
                }
            });

        marcar = new Checkbox("Reset presets Menu to Default Settings After Printing");
        marcar.setBounds(30,520,350,20);

        controlPanel = new Panel();
        controlPanel.setLayout(null);
        controlPanel.setSize(700, 700);
        controlPanel.add(Delete);
        controlPanel.add(presets);
        controlPanel.add(setting);
        controlPanel.add(value);
        controlPanel.add(Duplicate);
        controlPanel.add(OK);
        controlPanel.add(Cancel);
        controlPanel.add(marcar);

        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    private void showListDemo(){

        final List OptionsList = new List(35,false);
        OptionsList.setBounds(30,50, 200, 400);
        OptionsList.setBackground(Color.lightGray);

        verticalScroller = new Scrollbar();
        verticalScroller.setOrientation(Scrollbar.VERTICAL);


        OptionsList.add("Current");
        OptionsList.add("Default Settings");
        OptionsList.add("Last Used Settings");

        ScrollPane panel = new ScrollPane();
        panel.setBounds(240,50, 430, 400);
        panel.setBackground(Color.lightGray);

        controlScroll = new Panel();
        controlScroll.setBackground(Color.lightGray);
        controlScroll.setLayout(null);
        controlScroll.setBounds(240,50, 400, 900);

        Label option1 = new Label();
        option1.setText(">Copies & Pages");
        option1.setBounds(10, 10, 100,15);

        Label copies = new Label();
        copies.setText("Copies");
        copies.setBounds(50, 40, 50,20);

        Label pages = new Label();
        pages.setText("Pages");
        pages.setBounds(50, 70, 55,20);

        Label paperSize = new Label();
        paperSize.setText("PaperSize");
        paperSize.setBounds(50, 100, 70,20);

        Label orientation = new Label();
        orientation.setText("Orientation");
        orientation.setBounds(50, 130, 70,20);

        Label option2 = new Label();
        option2.setText(">Preview");
        option2.setBounds(10, 160, 100,15);

        Label A_rotate = new Label();
        A_rotate.setText("Auto rotate");
        A_rotate.setBounds(50, 190,100,20);

        Label S_Notes = new Label();
        S_Notes.setText("Show Notes");
        S_Notes.setBounds(50, 220, 100,20);

        Label S_Mode = new Label();
        S_Mode.setText("Scale Mode");
        S_Mode.setBounds(50, 250, 100,20);

        Label SF_Mode = new Label();
        SF_Mode.setText("Scale to Fit Mode");
        SF_Mode.setBounds(50, 280, 100,20);

        Label option3 = new Label();
        option3.setText(">Layout");
        option3.setBounds(10, 310, 100,15);

        Label PP_Sheet = new Label();
        PP_Sheet.setText("Pages Per Sheet");
        PP_Sheet.setBounds(50, 340, 100,20);

        Label L_Direction = new Label();
        L_Direction.setText("Layout Direction");
        L_Direction.setBounds(50,370, 100,20);

        Label Border = new Label();
        Border.setText("Border");
        Border.setBounds(50, 400, 70,20);

        Label T_Sided = new Label();
        T_Sided.setText("Two-Sided");
        T_Sided.setBounds(50, 430, 70,20);

        Label Booklet = new Label();
        Booklet.setText("Booklet");
        Booklet.setBounds(50,460, 55,20);

        Label RP_Orientation = new Label();
        RP_Orientation.setText("Reverse Page Orientation");
        RP_Orientation.setBounds(50, 490, 150,20);

        Label F_Horizontally = new Label();
        F_Horizontally.setText("Flip Horizontally");
        F_Horizontally.setBounds(50, 520, 100,20);

        Label option4 = new Label();
        option4.setText(">Paper Handling");
        option4.setBounds(10, 550, 100,15);

        Label C_pages = new Label();
        C_pages.setText("Collate pages");
        C_pages.setBounds(50, 580,100,20);

        Label PT_print = new Label();
        PT_print .setText("Pages To print ");
        PT_print .setBounds(50, 610, 100,20);

        Label DP_Size = new Label();
        DP_Size.setText("Destination Paper Size");
        DP_Size.setBounds(50, 640, 180,20);

        Label P_Order = new Label();
        P_Order.setText("Page Order");
        P_Order.setBounds(50, 670, 100,20);

        Label option5 = new Label();
        option5.setText(">Paper Feed");
        option5.setBounds(10, 700, 100,15);

        Label AP_From = new Label();
        AP_From.setText("All Pages From");
        AP_From.setBounds(50, 730,100,20);

        Label option6 = new Label();
        option6.setText(">Cover Page");
        option6.setBounds(10, 760, 100,15);

        Label PC_Page = new Label();
        PC_Page.setText("Print Cover Page");
        PC_Page.setBounds(50, 790,100,20);

        Label R_copies = new Label();
        R_copies.setText("1");
        R_copies.setBounds(250, 40, 50,20);

        Label R_pages = new Label();
        R_pages.setText("1 to 1");
        R_pages.setBounds(250, 70, 50,20);

        Label R_paperSize = new Label();
        R_paperSize.setText("US Letter");
        R_paperSize.setBounds(250, 100, 70,20);

        Label R_orientation = new Label();
        R_orientation.setText("Portrait");
        R_orientation.setBounds(250,130, 50,20);

        Label R_A_rotate = new Label();
        R_A_rotate.setText("On");
        R_A_rotate.setBounds(250, 190,100,20);

        Label R_S_Notes = new Label();
        R_S_Notes.setText("Off");
        R_S_Notes.setBounds(250, 220, 100,20);

        Label R_S_Mode = new Label();
        R_S_Mode.setText("Scale to Fit");
        R_S_Mode.setBounds(250, 250, 100,20);

        Label R_SF_Mode = new Label();
        R_SF_Mode.setText("Print Entire Image");
        R_SF_Mode.setBounds(250, 280, 100,20);

        Label R_PP_Sheet = new Label();
        R_PP_Sheet.setText("1");
        R_PP_Sheet.setBounds(250, 340, 100,20);

        Label R_L_Direction = new Label();
        R_L_Direction.setText("Left-Right-Top-Bottom");
        R_L_Direction.setBounds(250,370, 200,20);

        Label R_Border = new Label();
        R_Border.setText("None");
        R_Border.setBounds(250, 400, 70,20);

        Label R_T_Sided = new Label();
        R_T_Sided.setText("Off");
        R_T_Sided.setBounds(250, 430, 70,20);

        Label R_Booklet = new Label();
        R_Booklet.setText("Off");
        R_Booklet.setBounds(250,460, 55,20);

        Label R_RP_Orientation = new Label();
        R_RP_Orientation.setText("Off");
        R_RP_Orientation.setBounds(250, 490, 150,20);

        Label R_F_Horizontally = new Label();
        R_F_Horizontally.setText("Off");
        R_F_Horizontally.setBounds(250, 520, 100,20);

        Label R_C_pages = new Label();
        R_C_pages.setText("On");
        R_C_pages.setBounds(250, 580,100,20);

        Label R_PT_print = new Label();
        R_PT_print .setText("All pages");
        R_PT_print .setBounds(250, 610, 100,20);

        Label R_DP_Size = new Label();
        R_DP_Size.setText("Document paper: US Letter");
        R_DP_Size.setBounds(250, 640, 180,20);

        Label R_P_Order = new Label();
        R_P_Order.setText("Automatic");
        R_P_Order.setBounds(250, 670, 100,20);

        Label R_AP_From = new Label();
        R_AP_From.setText("Auto Select");
        R_AP_From.setBounds(250, 730,100,20);

        Label R_PC_Page = new Label();
        R_PC_Page.setText("None");
        R_PC_Page.setBounds(250, 790,100,20);

        controlScroll.add(option1);
        controlScroll.add(copies);
        controlScroll.add(R_copies);
        controlScroll.add(pages);
        controlScroll.add(R_pages);
        controlScroll.add(paperSize);
        controlScroll.add(R_paperSize);
        controlScroll.add(orientation);
        controlScroll.add(R_orientation);

        controlScroll.add(option2);
        controlScroll.add(A_rotate);
        controlScroll.add(R_A_rotate);
        controlScroll.add(S_Notes);
        controlScroll.add(R_S_Notes);
        controlScroll.add(S_Mode);
        controlScroll.add(R_S_Mode);
        controlScroll.add(SF_Mode);
        controlScroll.add(R_SF_Mode);

        controlScroll.add(option3);
        controlScroll.add(PP_Sheet);
        controlScroll.add(R_PP_Sheet);
        controlScroll.add(L_Direction);
        controlScroll.add(R_L_Direction);
        controlScroll.add(Border);
        controlScroll.add(R_Border);
        controlScroll.add(T_Sided);
        controlScroll.add(R_T_Sided);
        controlScroll.add(Booklet);
        controlScroll.add(R_Booklet);
        controlScroll.add(RP_Orientation);
        controlScroll.add(R_RP_Orientation);
        controlScroll.add(F_Horizontally);
        controlScroll.add(R_F_Horizontally);

        controlScroll.add(option4);
        controlScroll.add(C_pages);
        controlScroll.add(R_C_pages);
        controlScroll.add(PT_print);
        controlScroll.add(R_PT_print);
        controlScroll.add(DP_Size);
        controlScroll.add(R_DP_Size);
        controlScroll.add(P_Order);
        controlScroll.add(R_P_Order);

        controlScroll.add(option5);
        controlScroll.add(AP_From);
        controlScroll.add(R_AP_From);

        controlScroll.add(option6);
        controlScroll.add(PC_Page);
        controlScroll.add(R_PC_Page);

        
        controlScroll.add(verticalScroller);

        panel.add(controlScroll);

        controlPanel.add(panel);
        controlPanel.add(OptionsList);
        mainFrame.setVisible(true);
    }
}
