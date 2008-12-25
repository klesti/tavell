/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import javax.swing.UIManager;

/**
 *
 * @author Klesti
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new TestLoje();
        
        /*//Try catch duhet per te vendosur Look and Feel si i sistemit te operimit
        try {	    
        UIManager.setLookAndFeel(
        UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception e){}
        new ZgjidhLojeGUI().setVisible(true);*/
    }

}
