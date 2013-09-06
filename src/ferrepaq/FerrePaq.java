/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.awt.Dimension;
import java.awt.Toolkit;


/**
 *
 * @author omar
 */
public class FerrePaq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormLoading a = new FormLoading();
        a.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = a.getSize().width;
        int h = a.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        
        // Move the window
        a.setLocation(x, y);
        MainFrame.main(args);
    }
}
