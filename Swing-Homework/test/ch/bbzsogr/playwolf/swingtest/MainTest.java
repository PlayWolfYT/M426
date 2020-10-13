/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbzsogr.playwolf.swingtest;

import java.awt.Component;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ruben Martins
 */
public class MainTest {
    
    private JFrame frame;
    private JPanel panel;
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Starting setup");
        Main.main(null);
        frame = Main.getFrame();
        panel = Main.getPanel();
        System.setOut(new PrintStream(outContent));
        originalOut.println("Setup done.");
    }
    
    @After
    public void tearDown() {
        originalOut.println("Tearing down");
        frame.dispose();
        System.setOut(originalOut);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void test() throws InterruptedException {
        originalOut.println("Starting tests");
        
        assertNotNull(frame);
        
        Thread.sleep(200);
        
        assertNotNull(panel);
        
        JButton button1 = (JButton) panel.getComponent(0);
        assertNotNull(button1);
        
        
        
        button1.doClick();
        
        assertEquals(outContent.toString(), "Button clicked\r\n");
        
        System.setOut(originalOut);
        
        
        JTextField firstName = (JTextField) panel.getComponent(1);
        JTextField lastName = (JTextField) panel.getComponent(2);
        
        JButton submit = (JButton) panel.getComponent(3);
        
        assertNotNull(firstName);
        assertNotNull(lastName);
        assertNotNull(submit);
        
        firstName.setText("This is a test");
        lastName.setText("This is a test too");
        
        SwingUtilities.invokeLater(() -> {
            submit.doClick();
        });
        JButton okButton = null;
        for(int i = 0; okButton == null; i++) {
            Thread.sleep(200);
            okButton = (JButton) SwingUtils.getChildIndexed(frame, "JButton", 0);
            assertTrue(i < 10);
        }
        assertEquals(UIManager.getString("OptionPane.okButtonText"), okButton.getText());
        
        okButton.doClick();
        
        Thread.sleep(2000);
        
        
        // cancel button
        SwingUtilities.invokeLater(() -> {
            submit.doClick();
        });
        JButton cancelButton = null;
        for(int i = 0; cancelButton == null; i++) {
            Thread.sleep(200);
            cancelButton = (JButton) SwingUtils.getChildIndexed(frame, "JButton", 1);
            assertTrue(i < 10);
        }
        assertEquals(UIManager.getString("OptionPane.cancelButtonText"), cancelButton.getText());
        
        
        cancelButton.doClick();
        
        Thread.sleep(5000);
    }
    
    
}
