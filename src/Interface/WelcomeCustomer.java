package Interface;

import databaseFunctions.DatabaseFunctions;
import javafx.scene.text.Font;

import static databaseFunctions.DatabaseFunctions.conn;
import static databaseFunctions.DatabaseFunctions.connectToDatabase;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;
import javax.swing.text.StyleConstants.FontConstants;

import java.awt.event.*;

public class WelcomeCustomer extends JFrame {

	int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int parentWidth = (int) Math.round(screenWidth/1.2);
	int parentHeight = (int) Math.round((float)screenHeight /1.5);
	int rightPanelHeight = parentHeight;
	int rightPanelWidth = parentWidth*3/4;
	
	
    public WelcomeCustomer() {
    	initComponents();
    	this.setLayout(null);
    	this.setBounds(screenWidth/8, screenHeight/6, parentWidth, parentHeight);
    	 
    	initButtonPanel();
    	initBrowseCatagoryPanel();
    	DatabaseFunctions.UpdateMyCart();
    	initViewCartPanel();
    	this.setTitle("Home Page");
    //	initBrowseSubCatagoryPanel();
    	//Add Panels To Frame
    	
    	this.add(ButtonPanel);
    	this.add(CardDeck);
    	
    	this.setVisible(true);
    }
    
    
    public void setDefaultMenuButtonColor(){
    	BrowseCatalogue.setBackground(Color.white);
    	BrowseCatalogue.setBorder(BorderFactory.createLineBorder(Color.black,1));
       	ViewCart.setBackground(Color.white);
    	ViewCart.setBorder(BorderFactory.createLineBorder(Color.black,1));
       	ProceedToCheckout.setBackground(Color.white);
    	ProceedToCheckout.setBorder(BorderFactory.createLineBorder(Color.black,1));
    	LogOut.setBackground(Color.white);
    	LogOut.setBorder(BorderFactory.createLineBorder(Color.black,1));
    }
    
    public void setTheme(){
   
    	//Button themes
        Exp1.setBackground(new Color(10,200,20));
        ConfirmOrder.setBackground(new Color(10,200,20));
        Exp2.setBackground(new Color(10,200,20));
        SelectProduct.setBackground(new Color(10,200,20));
        AddToCart.setBackground(new Color(10,200,20));
        SCtoC_Back.setBackground(new Color(10,200,20));
        PtoSC_Back.setBackground(new Color(10,200,20));
        RemoveFromCart.setBackground(new Color(10,200,20));
        
        Exp1.setBorder(BorderFactory.createLineBorder(Color.black,1));
        ConfirmOrder.setBorder(BorderFactory.createLineBorder(Color.black,1));
        Exp2.setBorder(BorderFactory.createLineBorder(Color.black,1));
        SelectProduct.setBorder(BorderFactory.createLineBorder(Color.black,1));
        AddToCart.setBorder(BorderFactory.createLineBorder(Color.black,1));
        SCtoC_Back.setBorder(BorderFactory.createLineBorder(Color.black,1));
        PtoSC_Back.setBorder(BorderFactory.createLineBorder(Color.black,1));
        RemoveFromCart.setBorder(BorderFactory.createLineBorder(Color.black,1));

        Exp1.setForeground(Color.white);
        ConfirmOrder.setForeground(Color.white);
        Exp2.setForeground(Color.white);
        SelectProduct.setForeground(Color.white);
        AddToCart.setForeground(Color.white);
        SCtoC_Back.setForeground(Color.white);
        PtoSC_Back.setForeground(Color.white);
        RemoveFromCart.setForeground(Color.white);

        //Panel Colors
   
        ButtonPanel.setBackground(Color.white);
    	ViewCartPanel.setBackground(Color.white);
    	ProceedToCheckoutPanel.setBackground(Color.white);
    	BrowseCatagoryPanel.setBackground(Color.white);
    	BrowseSubCatagoryPanel.setBackground(Color.white);
    	BrowseProductsPanel.setBackground(Color.white);
    	ProductHome.setBackground(Color.white);
    	ThankYouPanel.setBackground(Color.white);
    	
    }
    
    
    public void initButtonPanel(){
    	setDefaultMenuButtonColor();
    	BrowseCatalogue.setBounds(30, 100, 200, 35);
    	ViewCart.setBounds(30, 165, 200, 35);
    	ProceedToCheckout.setBounds(30, 230, 200, 35);
    	LogOut.setBounds(30, 300, 200, 35);
    	ButtonPanel.add(BrowseCatalogue);
    	ButtonPanel.add(ProceedToCheckout);
    	ButtonPanel.add(ViewCart);
    	ButtonPanel.add(LogOut);
    	ButtonPanel.setBackground(new Color(10,200,20));
    }

    public void initBrowseCatagoryPanel(){
    	jLabel2.setBounds(rightPanelWidth/4, 35, 150 , 30);;
    	jTable1.setRowHeight(30);
        jScrollPane1.setBounds(rightPanelWidth/4, 100, rightPanelWidth/2, jTable1.getRowHeight()*jTable1.getRowCount()+35);
    	jTable1.getTableHeader().setBackground(new Color(10,200,20));
    	jTable1.getTableHeader().setForeground(Color.white);
    	jTable1.getTableHeader().setPreferredSize(new Dimension(rightPanelWidth/2,35));
    	Exp1.setBounds(rightPanelWidth*4/5, rightPanelHeight*4/5, 80, 25);
    	BrowseCatagoryPanel.add(jLabel2);
    	BrowseCatagoryPanel.add(jScrollPane1);
    	BrowseCatagoryPanel.add(Exp1);
    	
    }

    public void initBrowseSubCatagoryPanel(){
    	jLabel1.setBounds(rightPanelWidth/4, 35, 150 , 30);;
    	
    	jTable2.setRowHeight(30);
    	jScrollPane2.setBounds(rightPanelWidth/4, 100, rightPanelWidth/2, jTable2.getRowHeight()*jTable2.getRowCount()+35);
    	jTable2.getTableHeader().setBackground(new Color(10,200,20));
    	jTable2.getTableHeader().setForeground(Color.white);
    	jTable2.getTableHeader().setPreferredSize(new Dimension(rightPanelWidth/2,35));
    	Exp2.setBounds(rightPanelWidth*4/5, rightPanelHeight*4/5, 80, 25);
    	SCtoC_Back.setBounds(rightPanelWidth*1/5, rightPanelHeight*4/5, 80, 25);
    	BrowseSubCatagoryPanel.add(jLabel1);
    	BrowseSubCatagoryPanel.add(jScrollPane2);
    	BrowseSubCatagoryPanel.add(Exp2);
    	BrowseSubCatagoryPanel.add(SCtoC_Back);
    }

    public void initBrowseProductsPanel(){

    	jLabel4.setBounds(rightPanelWidth/4, 35, 150 , 30);;
    	
    	jTable3.setRowHeight(30);
        jScrollPane3.setBounds(rightPanelWidth/4, 100, rightPanelWidth/2, jTable3.getRowHeight()*jTable3.getRowCount()+35);
      	jTable3.getTableHeader().setBackground(new Color(10,200,20));
      	jTable3.getTableHeader().setForeground(Color.white);
      	jTable3.getTableHeader().setPreferredSize(new Dimension(rightPanelWidth/2,35));
      	SelectProduct.setBounds(rightPanelWidth*4/5, rightPanelHeight*4/5, 80, 25);
    	PtoSC_Back.setBounds(rightPanelWidth*1/5, rightPanelHeight*4/5, 80, 25);
    	BrowseProductsPanel.add(jLabel4);
    	BrowseProductsPanel.add(jScrollPane3);
    	BrowseProductsPanel.add(SelectProduct);
    	BrowseProductsPanel.add(PtoSC_Back);
    }
    
    public void initProductHomePanel(){
    	
    	jLabel5.setBounds(rightPanelWidth/3, 30, 200, 35);;
    	jLabel6.setBounds(rightPanelWidth/3, 130, 200, 35);;
    	jLabel7.setBounds(rightPanelWidth/3, 180, 200, 35);;
    	jLabel8.setBounds(rightPanelWidth/3, 230, 200, 35);;
    	jLabel9.setBounds(rightPanelWidth/3, 280, 200, 35);;
    	jLabel10.setBounds(rightPanelWidth/3, 310, 200, 35);;
    	Message.setBounds(rightPanelWidth/3,420, 300,35);
    	//Values
    	modelHere.setBounds(rightPanelWidth/3+150, 130, 200, 35);;
    	brandHere.setBounds(rightPanelWidth/3+150, 180, 200, 35);;
    	detailsHere.setBounds(rightPanelWidth/3+150, 230, 200, 35);;
    	amountHere.setBounds(rightPanelWidth/3+150, 280, 200, 35);;
    	statusHere.setBounds(rightPanelWidth/3+150, 310, 200, 35);
    	// Button
    	AddToCart.setBounds(rightPanelWidth/3, 380, 200, 35);
    	
    	//Add Components
    	ProductHome.add(jLabel5);
    	ProductHome.add(jLabel6);
    	ProductHome.add(jLabel7);
    	ProductHome.add(jLabel8);
    	ProductHome.add(jLabel9);
    	ProductHome.add(jLabel10);
    	ProductHome.add(modelHere);
    	ProductHome.add(brandHere);
    	ProductHome.add(detailsHere);
    	ProductHome.add(amountHere);
    	ProductHome.add(AddToCart);
    	ProductHome.add(statusHere);
    	ProductHome.add(Message);
    }
    
    public void initViewCartPanel(){
    	
    	jLabel3.setBounds(rightPanelWidth/4, 35, 150 , 30);;
        
    	MyCart.setRowHeight(30);
    	jLabel12.setBounds(rightPanelWidth/5+240, rightPanelHeight*4/5, 150, 35);
    	jLabel11.setBounds(rightPanelWidth/5+400, rightPanelHeight*4/5, 150, 35);
        jScrollPane4.setBounds(rightPanelWidth/4, 100, rightPanelWidth/2, MyCart.getRowHeight()*MyCart.getRowCount()+35);
      	MyCart.getTableHeader().setBackground(new Color(10,200,20));
      	MyCart.getTableHeader().setForeground(Color.white);
      	MyCart.getTableHeader().setPreferredSize(new Dimension(rightPanelWidth/2,35));
      	RemoveFromCart.setBounds(rightPanelWidth/5, rightPanelHeight*4/5, 200, 35);
    	ViewCartPanel.add(jLabel3);
    	
    	ViewCartPanel.add(jLabel12);
    	ViewCartPanel.add(jLabel11);
    	ViewCartPanel.add(jScrollPane4);
    	ViewCartPanel.add(RemoveFromCart);
 
    }
   
    public void initProceedToCheckoutPanel(){
    	jLabel13.setBounds(rightPanelWidth/6, 40, 200, 40);
    	jLabel14.setBounds(rightPanelWidth/4, 120, 100, 30);
    	jLabel15.setBounds(rightPanelWidth/4, 250, 100, 40);
    	jLabel16.setBounds(rightPanelWidth/4, 300, 200, 40);
    	jLabel18.setBounds(rightPanelWidth*3/4, 370, 230, 25);
    	jLabel19.setBounds(rightPanelWidth/4, 400, 230, 25);
    	jLabel20.setBounds(rightPanelWidth/2, 400, 230, 25);  //amount
    	ConfirmOrder.setBounds(rightPanelWidth*3/4, 400, 120, 35);
    	jScrollPane5.setBounds(rightPanelWidth/4+100, 120, 220, 110);
    	jScrollPane5.setViewportView(jTextArea1);
    	jScrollPane5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	jTextField1.setBounds(rightPanelWidth/4+100, 255, 100, 25);
    	jTextField2.setBounds(rightPanelWidth/4+100, 305, 100, 25);
    	jCheckBox1.setBounds(rightPanelWidth/4, 350, 230, 25);
    	jCheckBox2.setBounds(rightPanelWidth*3/4-80, 120, 200, 30);
    	
    	
    	//Add ELements
    	ProceedToCheckoutPanel.add(jLabel13);
    	ProceedToCheckoutPanel.add(jLabel14);
    	ProceedToCheckoutPanel.add(jLabel15);
    	ProceedToCheckoutPanel.add(jLabel16);
    	ProceedToCheckoutPanel.add(jLabel18);
    	ProceedToCheckoutPanel.add(jLabel19);
    	ProceedToCheckoutPanel.add(jLabel20);
    	ProceedToCheckoutPanel.add(jScrollPane5);
    	ProceedToCheckoutPanel.add(jTextField1);
    	ProceedToCheckoutPanel.add(jTextField2);
    	ProceedToCheckoutPanel.add(jCheckBox1);
    	ProceedToCheckoutPanel.add(jCheckBox2);
    	ProceedToCheckoutPanel.add(ConfirmOrder);
        
    }
    
    public void initThankYouPanel(){
    	jLabel21.setBounds(rightPanelWidth/3, rightPanelHeight/3, 500, 40);;
    	jLabel22.setBounds(rightPanelWidth/3, rightPanelHeight/3+80, 500, 40);;
    	ThankYouPanel.add(jLabel21);
    	ThankYouPanel.add(jLabel22);
    }
    static int selectedProductId;
    static int selectedCatagoryIndex;
    
    private void initComponents() {
    	
 

        ButtonPanel = new JPanel();
        BrowseCatalogue = new JButton();
        ViewCart = new JButton();
        ProceedToCheckout = new JButton();
        LogOut = new JButton();
        CardDeck = new JPanel();
        BrowseCatagoryPanel = new JPanel();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        
        Exp1 = new JButton();
        ViewCartPanel = new JPanel();
        jLabel3 = new JLabel();
        jScrollPane4 = new JScrollPane();
        MyCart = new JTable();
        RemoveFromCart = new JButton();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        BrowseSubCatagoryPanel = new JPanel();
        jLabel1 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        Exp2 = new JButton();
        PtoSC_Back = new JButton();
        BrowseProductsPanel = new JPanel();
        jLabel4 = new JLabel();
        jScrollPane3 = new JScrollPane();
        jTable3 = new JTable();
        SelectProduct = new JButton();
        SCtoC_Back = new JButton();
        ProductHome = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        statusHere = new JLabel();
        modelHere = new JLabel();
        brandHere = new JLabel();
        detailsHere = new JLabel();
        amountHere = new JLabel();
        AddToCart = new JButton();
        Message = new JLabel();
        jLabel10 = new JLabel();
        jLabel17 = new JLabel();
        ProceedToCheckoutPanel = new JPanel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jScrollPane5 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        ConfirmOrder = new JButton();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        ThankYouPanel = new JPanel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        
        BrowseCatagoryPanel.setLayout(null);
        BrowseProductsPanel.setLayout(null);;
        BrowseSubCatagoryPanel.setLayout(null);
        CardDeck.setLayout(new CardLayout());;
        ProceedToCheckoutPanel.setLayout(null);;
        ProductHome.setLayout(null);;
        ViewCartPanel.setLayout(null);;
        ThankYouPanel.setLayout(null);;
        ButtonPanel.setLayout(null);
        

        setTheme();

    	BrowseCatagoryPanel.setBounds(parentWidth/4, 0, parentWidth*3/4, parentHeight);
        BrowseProductsPanel.setBounds(parentWidth/4, 0, parentWidth*3/4, parentHeight);;
        BrowseSubCatagoryPanel.setBounds(parentWidth/4, 0, parentWidth*3/4, parentHeight);
        CardDeck.setBounds(parentWidth/4, 0, parentWidth*3/4, parentHeight);;
        ProceedToCheckoutPanel.setBounds(parentWidth/4, 0, parentWidth*3/4, parentHeight);;
        ProductHome.setBounds(parentWidth/4, 0, parentWidth*3/4, parentHeight);;
        ViewCartPanel.setBounds(parentWidth/4, 0, parentWidth*3/4, parentHeight);;
        ThankYouPanel.setBounds(parentWidth/4, 0, parentWidth*3/4, parentHeight);;
    	ButtonPanel.setBounds(0, 0, parentWidth/4, parentHeight);
     
    	jTable1.setRowHeight(35);
    	
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BrowseCatalogue.setText("Browse Catalogue");
        BrowseCatalogue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BrowseCatalogueActionPerformed(evt);
            }
        });

        ViewCart.setText("View Cart");
        ViewCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ViewCartActionPerformed(evt);
            }
        });

        ProceedToCheckout.setText("Proceed To Checkout");
        ProceedToCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProceedToCheckoutActionPerformed(evt);
            }
        });

        LogOut.setText("Log Out");
        LogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        jLabel2.setText("Browse Catalogue");

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Sr No", "Catagory"
            }) {
                Class[] types = new Class [] {
                        java.lang.Integer.class, java.lang.Object.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                }
        ) ;
        
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try{
            showCatagoryTable();
        }catch(SQLException se){
            se.printStackTrace();
        }

        Exp1.setText("Explore");
        Exp1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Exp1ActionPerformed(evt);
            }
        });

        CardDeck.add(BrowseCatagoryPanel, "BrowseCatalogue");

        ViewCartPanel.setFocusable(false);

        jLabel3.setText("Your Cart :-");

        MyCart.setModel(new DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Sr No", "Catagory", "Model ", "Brand", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MyCart.setName("MyCart"); // NOI18N
        jScrollPane4.setViewportView(MyCart);
        if (MyCart.getColumnModel().getColumnCount() > 0) {
            MyCart.getColumnModel().getColumn(1).setPreferredWidth(150);
            MyCart.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        RemoveFromCart.setText("Remove Product From Cart");
        RemoveFromCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RemoveFromCartActionPerformed(evt);
            }
        });

        jLabel12.setText("YOUR TOTAL AMOUNT");

        CardDeck.add(ViewCartPanel, "ViewCart");

        jLabel1.setText("Browse Sub-Catagory");

        jTable2.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "Sr No", "Sub Catagory"
                }) {
                    Class[] types = new Class [] {
                            java.lang.Integer.class, java.lang.Object.class
                        };
                        boolean[] canEdit = new boolean [] {
                            false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                            return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
            ) ;
        jScrollPane2.setViewportView(jTable2);

        Exp2.setText("Explore");
        Exp2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Exp2ActionPerformed(evt);
            }
        });

        PtoSC_Back.setText("Back");
        PtoSC_Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PtoSC_BackActionPerformed(evt);
            }
        });

        CardDeck.add(BrowseSubCatagoryPanel, "BrowseSubCatagoryPanel");

        jLabel4.setText("Browse Products");

        jTable3.setModel(new DefaultTableModel(
            new Object [][] {
             },
            new String [] {
                "Sr No", "Model", "Brand", "ID", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        SelectProduct.setText("Select");
        SelectProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SelectProductActionPerformed(evt);
            }
        });

        SCtoC_Back.setText("Back");
        SCtoC_Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SCtoC_BackActionPerformed(evt);
            }
        });


        CardDeck.add(BrowseProductsPanel, "BrowseProductPanel");

        jLabel5.setText("Your Selected Product : ");

        jLabel6.setText("Model Name : ");

        jLabel7.setText("Brand : ");

        jLabel8.setText("Description : ");

        jLabel9.setText("Amount : ");

        AddToCart.setText("Add to Cart");
        AddToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddToCartActionPerformed(evt);
            }
        });

        jLabel10.setText("Status :");


        CardDeck.add(ProductHome, "ProductHome");

        jLabel13.setText("Proceed To Checkout : ");

        jLabel14.setText("Address :");

        jLabel15.setText("City :");

        jLabel16.setText("Pincode: ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);
        
        jCheckBox1.setText("Save This As My Home Address");
        jCheckBox1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        

        jCheckBox2.setText("Auto-Fill Home Address");
        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        ConfirmOrder.setText("Confirm Order");
        ConfirmOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ConfirmOrderActionPerformed(evt);
            }
        });

        jLabel18.setText("Cash On Delivery Available");

        jLabel19.setText("YOUR TOTAL AMOUNT");


        CardDeck.add(ProceedToCheckoutPanel, "ProceedToCheckoutPanel");

        jLabel21.setText("Your Order has been placed Successfully! You will recieve your order soon!");

        jLabel22.setText("Thank you for shopping with us !!");
        
        ThankYouPanel.setLayout(new GroupLayout(ThankYouPanel));;
        ThankYouPanel.add(jLabel21);
        ThankYouPanel.add(jLabel22);

        CardDeck.add(ThankYouPanel, "ThankYouPanel");
    }
    
    private void BrowseCatalogueActionPerformed(ActionEvent evt) {//GEN-FIRST:event_BrowseCatalogueActionPerformed

    	setDefaultMenuButtonColor();
    	BrowseCatalogue.setBackground(new Color(178,255,102));
    
    	CardLayout c1 = (CardLayout)(CardDeck.getLayout());
        c1.show(CardDeck, "BrowseCatalogue");
    }
    
    private void ViewCartActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ViewCartActionPerformed

    	setDefaultMenuButtonColor();
    	ViewCart.setBackground(new Color(178,255,102));
    
        DatabaseFunctions.UpdateMyCart();
        initViewCartPanel();
        CardLayout c1 = (CardLayout)(CardDeck.getLayout());
        c1.show(CardDeck, "ViewCart");
    }
    
    private void Exp1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Exp1ActionPerformed
        int selectedRow;
        clearSubCatagoryTable();
        selectedRow = jTable1.getSelectedRow();
        try{
        	
            System.out.println(selectedRow+1);
            showSubCatagoryTable(selectedRow+1);
        	initBrowseSubCatagoryPanel();
            CardLayout c1 = (CardLayout)CardDeck.getLayout();
            c1.show(CardDeck,"BrowseSubCatagoryPanel");
        }catch(SQLException se){
        se.printStackTrace();
        }
    }   
    private void Exp2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Exp2ActionPerformed
        
        int selectedRow;
        clearProductTable();
        selectedRow = jTable2.getSelectedRow();
        try{
            showProductsTable(selectedRow+1);
           	initBrowseProductsPanel();
            CardLayout c2 = (CardLayout)(CardDeck.getLayout());
            c2.show(CardDeck,"BrowseProductPanel");
        }catch(SQLException se){
        se.printStackTrace();
        }
       
    }
    
    private void SelectProductActionPerformed(ActionEvent evt) {//GEN-FIRST:event_SelectProductActionPerformed
        
        int selectedRow = jTable3.getSelectedRow();
        System.out.println(selectedRow);
        selectedProductId =(Integer) jTable3.getValueAt(selectedRow, 3);
        showProductHome();
        initProductHomePanel();
        CardLayout c1 = (CardLayout)(CardDeck.getLayout());
        c1.show(CardDeck,"ProductHome");
    }

    private void AddToCartActionPerformed(ActionEvent evt) {//GEN-FIRST:event_AddToCartActionPerformed
        try {
            
            DatabaseFunctions.addToCart(selectedProductId) ;
            initViewCartPanel();
            Message.setText("Product Added To Cart Successfully ! ");
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }//GEN-LAST:event_AddToCartActionPerformed

    private void SCtoC_BackActionPerformed(ActionEvent evt) {//GEN-FIRST:event_SCtoC_BackActionPerformed
            
            CardLayout c1 = (CardLayout) CardDeck.getLayout();
            c1.show(CardDeck, "BrowseCatalogue");
    }
    
    private void PtoSC_BackActionPerformed(ActionEvent evt) {//GEN-FIRST:event_PtoSC_BackActionPerformed
        
            CardLayout c1 = (CardLayout) CardDeck.getLayout();
            c1.show(CardDeck,"BrowseSubCatagoryPanel");
            
    }
    
    private void RemoveFromCartActionPerformed(ActionEvent evt) {//GEN-FIRST:event_RemoveFromCartActionPerformed
        
            DatabaseFunctions.removeFromCart((String) MyCart.getValueAt(MyCart.getSelectedRow(), 2));
            initViewCartPanel();
            
    }
    
    private void ProceedToCheckoutActionPerformed(ActionEvent evt) {
        
    		setDefaultMenuButtonColor();
    		ProceedToCheckout.setBackground(new Color(178,255,102));
    
    		initProceedToCheckoutPanel();
    		CardLayout c1 = (CardLayout) (CardDeck.getLayout());
    		c1.show(CardDeck,"ProceedToCheckoutPanel");
    }
    
    private void jCheckBox1StateChanged(ChangeEvent evt) {
        DatabaseFunctions.updateMyHomeAddress(jTextArea1.getText(), jTextField1.getText(), Integer.parseInt( jTextField2.getText()));
           
    }
    
    
    private void jCheckBox2ActionPerformed(ActionEvent evt) {
        try {
            
            ResultSet homeAddress = DatabaseFunctions.getMyHomeAddress();
            while(homeAddress.next()){
                jTextArea1.setText(homeAddress.getString("address"));
                jTextField1.setText(homeAddress.getString("city"));
                jTextField2.setText(String.valueOf(homeAddress.getInt("pincode")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WelcomeCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LogOutActionPerformed(ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        
        System.exit(0);
    }
    private void ConfirmOrderActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ConfirmOrderActionPerformed
        
        DatabaseFunctions.confirmOrder(jTextArea1.getText(), jTextField1.getText(),Integer.parseInt( jTextField2.getText()));
        initThankYouPanel();
        CardLayout c1 = (CardLayout) CardDeck.getLayout();
        c1.show(CardDeck, "ThankYouPanel");
    }
    
    public static void main(String args[]) {
    	WelcomeCustomer thisFrame = new WelcomeCustomer();
    
    }
    
    public static void showCatagoryTable() throws SQLException{
    
        DatabaseFunctions.connectToDatabase();
        Statement stmt = null;
        String sql = "SELECT DISTINCT catagory,catagoryId FROM productdetails ";
        try{
        stmt=DatabaseFunctions.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        	DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
        	m.addRow(new Object[] {rs.getInt("catagoryId"),rs.getString("catagory")});
        }    
        
        }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
      
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
    }
public static void showSubCatagoryTable(int selectedCatagoryId) throws SQLException{
        
        selectedCatagoryIndex=selectedCatagoryId;
        DatabaseFunctions.connectToDatabase();
        Statement stmt = null;
        String sql = "SELECT DISTINCT subCatagory,subCatagoryId FROM productdetails WHERE catagoryId="+selectedCatagoryId;
        try{
        stmt=DatabaseFunctions.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

    	DefaultTableModel m1 = (DefaultTableModel)jTable2.getModel();
    	
        while(rs.next()){
       
        	m1.addRow(new Object[] {rs.getInt("subCatagoryId"), rs.getString("subCatagory")});
            
        }    
        
        }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
}     
   
    public static void showProductsTable(int selectedSubCatagoryId) throws SQLException{
    	
        DatabaseFunctions.connectToDatabase();
        Statement stmt = null;
        String sql = "SELECT modelName,brand,id,amount  FROM productdetails WHERE catagoryId="+selectedCatagoryIndex+" AND subCatagoryId="+selectedSubCatagoryId;
        try{
        stmt=DatabaseFunctions.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        int i=1;
    	DefaultTableModel m1 = (DefaultTableModel) jTable3.getModel();
        while(rs.next()){
        	m1.addRow(new Object[]{i, rs.getString("modelName"),rs.getString("brand"), rs.getInt("ID"), rs.getInt("amount")});
        }   
        
        
        }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
      
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
}
    public static void showProductHome(){
        Message.setText("");
        DatabaseFunctions.connectToDatabase();
        Statement stmt = null;
        try{
            stmt=DatabaseFunctions.conn.createStatement();
            String sql = "SELECT modelName,brand,details,amount,stock FROM productdetails WHERE id="+selectedProductId;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("modelName"));
                modelHere.setText(rs.getString("modelName"));
                brandHere.setText(rs.getString("brand"));
                detailsHere.setText(rs.getString("details"));
                amountHere.setText(rs.getString("amount"));
                statusHere.setText(checkStock(rs.getInt("stock")));
            }
            
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
      
      try{
         if(stmt!=null)
           conn.close();
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
 }
    
  public static String checkStock(int stock){
      if(stock==0){
          AddToCart.setVisible(false);
          return "Not Available";
      }else if(stock<5 && stock>0){
      AddToCart.setVisible(true);
          return "Hurry! Limited Stock Left! " ;
          
      }else if(stock>5){
          AddToCart.setVisible(true);
          return "Available " ;
          
      }
      return null;
  }
  public static void clearCartTable(){
      DefaultTableModel m = (DefaultTableModel) MyCart.getModel();
      m.setRowCount(0);
  }

  public static void clearProductTable(){
	  DefaultTableModel m2 = (DefaultTableModel) jTable3.getModel();
	  m2.setRowCount(0);
  }

  public static void clearSubCatagoryTable(){
	  DefaultTableModel m2 = (DefaultTableModel) jTable2.getModel();
	  m2.setRowCount(0);
  }

    private JPanel BrowseCatagoryPanel;
    private JPanel BrowseProductsPanel;
    private JPanel BrowseSubCatagoryPanel;
    private JPanel CardDeck;
    private JPanel ProceedToCheckoutPanel;
    private JPanel ProductHome;
    private JPanel ViewCartPanel;
    private JPanel ThankYouPanel;
    private JPanel ButtonPanel;
    private static JLabel Message;
    public static JTable MyCart;
    private JButton ViewCart;
    private static JLabel amountHere;
    private static JLabel brandHere;
    private static JLabel detailsHere;
    private JButton BrowseCatalogue;
    private JButton Exp1;
    private JButton ConfirmOrder;
    private JButton Exp2;
    private JButton SelectProduct;
    private JButton ProceedToCheckout;
    private JButton LogOut;
    private static JButton AddToCart;
    private JButton SCtoC_Back;
    private JButton PtoSC_Back;
    private JButton RemoveFromCart;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JLabel jLabel1;
    private JLabel jLabel10;
    public static JLabel jLabel11;
    private JLabel jLabel12;
    // Label 13,14,15,16 for Proceed To Checkout Panel
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    public static JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel3;
    private JLabel jLabel4;
    // Labels 5,6,7,8,9 are for ProductHome
    private JLabel jLabel5; 
    private JLabel jLabel6; 
    private JLabel jLabel7;
    private JLabel jLabel8;
    private static JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private static JTable jTable1; //Catagory Table
    private static JTable jTable2; //SubCatagory Table
    private static JTable jTable3; //Product Table
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private static JLabel modelHere;
    private static JLabel statusHere;
}
