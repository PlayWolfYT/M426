/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbzsogr.playwolf.swingtest;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import javax.swing.JMenu;

/**
 *
 * @author Ruben Martins
 */
public class SwingUtils {
    
    static int counter;
    
     public static Component getChildIndexed(
            Component parent, String klass, int index) {
        counter = 0;
   
         // Step in only owned windows and ignore its components in JFrame
         if (parent instanceof Window) {
           Component[] children = ((Window)parent).getOwnedWindows();
   
           for (int i = 0; i < children.length; ++i) {
            // Take only active windows
               if (children[i] instanceof Window &&
                     !((Window)children[i]).isActive()) { continue; }
   
               Component child = getChildIndexedInternal(
                    children[i], klass, index);
               if (child != null) { return child; }
            }
         }
   
         return null;
      }
    
    private static Component getChildIndexedInternal(Component parent, String klass, int index) {
        if(parent.getClass().toString().endsWith(klass)) {
            if(counter == index) {
                return parent;
            }
            ++counter;
        }
        if (parent instanceof Container) {
            Component[] children = (parent instanceof JMenu) ?
                  ((JMenu)parent).getMenuComponents() :
                  ((Container)parent).getComponents();
   
            for (int i = 0; i < children.length; ++i) {
               Component child = getChildIndexedInternal(
                     children[i], klass, index);
               if (child != null) { return child; }
            }
         }
         
         return null;
    }
    
}
