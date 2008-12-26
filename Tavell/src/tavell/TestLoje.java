/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Klesti H
 */
public class TestLoje extends JFrame {
    private JPanel panel;
    private Fushe fusha;
    
    
    public TestLoje() {
        setTitle("Test Tavell");
        
        panel = (JPanel)getContentPane();
        fusha = new Fushe();
        fusha.setBounds(0,0,Fushe.WIDTH,Fushe.HEIGHT);
        panel.setPreferredSize(new java.awt.Dimension(Fushe.WIDTH,Fushe.HEIGHT));
        panel.setLayout(null);
        panel.add(fusha);        
        
        setBounds(0,0,900,700);
        setVisible(true);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    

}
