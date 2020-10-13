/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbzsogr.playwolf.swingtest;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * This file is the main start of the program
 * @author Ruben Martins
 */
public class Main {
    
    private static JFrame frame;
    private static JPanel panel;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing-Test");
        JPanel panel = preInitComponents(frame);
        initComponents(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Main.frame = frame;
        Main.panel = panel;
    }
    
    private static JPanel preInitComponents(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        
        //panel.setLayout(new FlowLayout());
        panel.setLayout(null);
        frame.add(panel);
        
        return panel;
    }
    
    private static void initComponents(JPanel panel) {
        JButton button = new JButton("This is a test");
        
        button.addActionListener(l -> {
            System.out.println("Button clicked");
        });
        
        button.setSize(250, 50);
        button.setLocation(panel.getSize().width / 2 - (button.getSize().width / 2), panel.getSize().height / 2 - (button.getSize().height / 2) - 150);
        button.setVisible(true);
        
        panel.add(button);
        
        JTextField firstName = new JTextField();
        firstName.setSize(250, 25);
        firstName.setLocation(panel.getSize().width/2-firstName.getSize().width/2, panel.getSize().height/2-firstName.getSize().height/2-75);
        firstName.setVisible(true);
        
        panel.add(firstName);

        JTextField lastName = new JTextField();
        lastName.setSize(250, 25);
        lastName.setLocation(panel.getSize().width/2-lastName.getSize().width/2, panel.getSize().height/2-lastName.getSize().height/2-25);
        lastName.setVisible(true);
        
        panel.add(lastName);
        
        button = new JButton("Show things");
        button.setSize(250,50);
        button.setLocation(panel.getSize().width / 2 - (button.getSize().width / 2), panel.getSize().height - button.getSize().height - 50);
        
        button.addActionListener(l -> {
            String first = firstName.getText();
            String last = lastName.getText();
            
            System.out.println("Opening popup");
            
            int answer = JOptionPane.showConfirmDialog(panel, "Hello " + first + " " + last, "Message", JOptionPane.OK_CANCEL_OPTION);
            
            switch (answer) {
                case JOptionPane.OK_OPTION:
                    System.out.println("Okay");
                    break;
                case JOptionPane.CANCEL_OPTION:
                    System.out.println("Cancelled");
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        });
        button.setVisible(true);
        
        panel.add(button);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static JPanel getPanel() {
        return panel;
    }
    
    
    
}
