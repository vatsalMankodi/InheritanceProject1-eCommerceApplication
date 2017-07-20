/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginMechanism;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class StartupFrame extends JFrame {

	public static Border buttonBorder;
    public StartupFrame() {
    	initComponents();
		int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int parentWidth = screenWidth/4;
		int parentHeight = screenHeight /2;
		this.setBounds(screenWidth/3, screenHeight/3, parentWidth, parentHeight);
		inStartupFrame.setBounds(0, 0, parentWidth, parentHeight);
		inStartupFrame.setBackground(Color.white);
		this.setLayout(null);
		inStartupFrame.setLayout(null);
		jLabel1.setBounds(parentWidth/6, 30, 200, 80);;
		jLabel2.setBounds(parentWidth/7, 150, 300, 25);
		jLabel3.setBounds(parentWidth/7, 210, 300, 25);
		jButton2.setBounds(parentWidth/7+150, 150, 80, 25); //Login
		jButton2.setBackground(new Color(10,200,20));
		
		jButton2.setForeground(Color.white);
		jButton3.setBounds(parentWidth/7+150, 210, 80, 25); //Signup
		jButton3.setBackground(new Color(10,200,20));
		jButton3.setForeground(Color.white);
		jButton1.setBounds(parentWidth/3, 280, 80, 25);
		jButton1.setBackground(new Color(10,200,20));
		jButton1.setForeground(Color.white);
		
		
		inStartupFrame.add(jLabel1);
		inStartupFrame.add(jLabel2);
		inStartupFrame.add(jLabel3);
		inStartupFrame.add(jButton2);
		inStartupFrame.add(jButton3);
		inStartupFrame.add(jButton1);
		this.add(inStartupFrame);
		
		this.setVisible(true);
    }

    private void initComponents() {
    	
    	inStartupFrame = new JPanel();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jLabel3 = new JLabel();
  
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Exit");
        jButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Arial",Font.BOLD, 24)); // NOI18N
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("WELCOME");
        jLabel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Existing User ");

        jButton2.setText("Login");
        jButton2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sign Up ");
        jButton3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("New User");

       
    }
    
    
    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        System.exit(0);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        LoginFrameCustomer.main(null);
        setVisible(false);
    }
    
    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        SignupFrame.main(null);
        setVisible(false);
    }
    
    
    public static void main(String args[]) {
    	
    	StartupFrame thisFrame = new StartupFrame();

    }

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel inStartupFrame;
    
}
