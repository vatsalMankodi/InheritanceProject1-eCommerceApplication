/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginMechanism;

import java.util.ArrayList;
import databaseFunctions.*;
import com.sun.javafx.tk.Toolkit;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrameCustomer extends JFrame{

	public LoginFrameCustomer() {
		initComponents();
		
		int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int parentWidth = screenWidth/4;
		int parentHeight = screenHeight /2;
		this.setBounds(screenWidth/3, screenHeight/3, parentWidth, parentHeight);
		this.setTitle("Login");
		this.setLayout(null);
		inLoginFrame.setBounds(0, 0, parentWidth, parentHeight);
		inLoginFrame.setLayout(null);
		inLoginFrame.setBackground(Color.white);
		jButton1.setBounds(parentWidth/3,parentHeight*3/5 ,100 , 35 );
		jButton1.setBackground(new Color(10,200,20));
		jButton1.setForeground(Color.white);
		jLabel1.setBounds(parentWidth/3, 10, 300, 25);
		jLabel2.setBounds(parentWidth/5, 100, 300, 25);
		jLabel3.setBounds(parentWidth/5, 150, 300, 25);
		jTextField1.setBounds((parentWidth/5)+80, 100, 120, 25);
		jPasswordField1.setBounds((parentWidth/5)+80, 150, 120, 25);
		inLoginFrame.add(jButton1);
		inLoginFrame.add(jLabel1);
		inLoginFrame.add(jLabel2);
		inLoginFrame.add(jTextField1);
		inLoginFrame.add(jPasswordField1);
		inLoginFrame.add(jLabel3);
		this.add(inLoginFrame);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		this.setVisible(true);
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jPasswordField1 = new JPasswordField();
        inLoginFrame = new JPanel();

        jLabel1.setText("Login - Enter Details ");

        jLabel2.setText("User ID");

        jLabel3.setText("Password");

        jButton1.setText("Login");
        jButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

      }
    
    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        User current = new Customer();
        current.setUserId(jTextField1.getText());
      
        current.setPassword(String.valueOf(jPasswordField1.getPassword()));
        DatabaseFunctions.loginCustomer(current);
        setVisible(false);
    }
    
    public static void main(String args[]) {
    	LoginFrameCustomer thisFrame = new LoginFrameCustomer();
    
    }

    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
    private JPanel inLoginFrame;
    
}
