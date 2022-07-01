package mian;

import javax.swing.*;
import java.awt.event.*;
 
public class Main extends JFrame {
 
    public Main() {
 
        JPanel panel = new JPanel();
 
        JLabel label = new JLabel("ID : ");
 
        JLabel pswrd = new JLabel("PassWord : ");
 
        JTextField txtID= new JTextField(10);
 
        JPasswordField txtPass = new JPasswordField(10);
 
        JButton logBtn = new JButton("Log in");
 
 
        panel.add(label);
        panel.add(txtID);
        panel.add(pswrd);
        panel.add(txtPass);
        panel.add(logBtn);
        
        add(panel);
        
        
        setVisible(true);
 
        setSize( 600 , 400);
 
        setLocationRelativeTo(null);
 
        setResizable(false);
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public static void main(String[] args) {
    	 
        new Main();
 
 
  }
}