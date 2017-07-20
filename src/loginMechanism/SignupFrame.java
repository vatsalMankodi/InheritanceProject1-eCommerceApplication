/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginMechanism;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import databaseFunctions.*;
import java.awt.event.*;

public class SignupFrame extends JFrame {
    
	int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int parentWidth = screenWidth/4;
	int parentHeight = screenHeight /2;

	public SignupFrame() {
    	initComponents();
    	
		this.setBounds(screenWidth/3, screenHeight/3, parentWidth, parentHeight);
		this.setTitle("Sign-Up");
		this.setLayout(null);
		inSignupFrame.setBounds(0, 0, parentWidth, parentHeight);
		inSignupFrame.setLayout(null);
		inSignupFrame.setBackground(Color.white);
		jButton1.setBounds(parentWidth/3,parentHeight*3/5 ,100 , 35 );
		jButton1.setForeground(Color.white);
		jLabel1.setBounds(parentWidth/3, 10, 300, 25);
		jLabel2.setBounds(parentWidth/5, 100, 300, 25);
		jLabel3.setBounds(parentWidth/5, 150, 300, 25);
		jLabel4.setBounds(20, parentHeight*3/5 + 60, 350, 20);
		jLabel5.setBounds(40, parentHeight*3/5 + 60, 350, 20);
		jLabel5.setForeground(Color.red);
		jLabel6.setBounds(40, parentHeight*3/5 + 60, 350, 20);
		jLabel6.setForeground(Color.red);
		jButton2.setBounds((int)(parentWidth/2.5), parentHeight*3/5 + 90 , 80, 25);
		jTextField1.setBounds((parentWidth/5)+80, 100, 120, 25);
		jPasswordField1.setBounds((parentWidth/5)+80, 150, 120, 25);
		inSignupFrame.add(jButton1);
		inSignupFrame.add(jButton2);
		inSignupFrame.add(jLabel1);
		inSignupFrame.add(jLabel2);
		inSignupFrame.add(jLabel3);
		inSignupFrame.add(jLabel4);
		inSignupFrame.add(jLabel5);
		inSignupFrame.add(jLabel6);
		inSignupFrame.add(jTextField1);
		inSignupFrame.add(jPasswordField1);
		
		this.add(inSignupFrame);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		this.setVisible(true);

    }

    private void initComponents() {

    	inSignupFrame = new JPanel(); 
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel6 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel4 = new JLabel();
        jButton2 = new JButton();
        jLabel5 = new JLabel();
        jPasswordField1 = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SignUp For Free!");

        jLabel2.setText("User ID");

        jLabel3.setText("Password");

        jButton1.setText("SIGN UP");
        jButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    	jButton1.setBackground(new Color(10,200,20));
    	
        jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel4.setText("Congratulations! SignUp Successful! Now Log In ?");

        jButton2.setText("OK");
       
        jButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
        jButton2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
    	jButton2.setBackground(new Color(10,200,20));
    	jButton2.setForeground(Color.white);
    	
        jLabel5.setText("User ID already exist ! Please try new User ID ");
        jLabel6.setText("Field Cannot be Empty !");
        jLabel4.setVisible(false);
        jButton2.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);

        pack();
    }
    
    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        User current = new Customer();
        current.setUserId(jTextField1.getText());
        current.setPassword(String.valueOf(jPasswordField1.getPassword()));
        if(jTextField1.getText().equals("") || jPasswordField1.getText().equals("")){
        	jLabel6.setVisible(true);
            jTextField1.setText("");
            jPasswordField1.setText("");
 
        }else if(DatabaseFunctions.isSignupCustomer(current)){
        	this.setBounds(screenWidth/3, screenHeight/3, parentWidth, parentHeight+30);;;
        	jLabel5.setVisible(false);
        	jLabel6.setVisible(false);
        	jLabel4.setVisible(true);
            jButton2.setVisible(true);
        }
        else{
            jLabel5.setVisible(true);
            jTextField1.setText("");
            jPasswordField1.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        LoginFrameCustomer.main(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
    	SignupFrame thisFrame = new SignupFrame();
    
    }
  
    private JPanel inSignupFrame;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
