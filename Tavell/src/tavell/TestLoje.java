/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Klesti H
 */
public class TestLoje extends JFrame {
    private JPanel panel;
    private Fushe fusha;
    private JPanel paneliLojtareve;
    private JPanel paneliLojtarit1;
    private JPanel paneliLojtarit2;
    private JLabel emriLojtarit1;
    
    
    public TestLoje() {
        setTitle("Test Tavell");
        
        panel = (JPanel)getContentPane();
        fusha = new Fushe();
        fusha.setBounds(0,0,Fushe.WIDTH,Fushe.HEIGHT);
        panel.setPreferredSize(new java.awt.Dimension(Fushe.WIDTH,Fushe.HEIGHT));
        panel.setLayout(null);
        
        
        //-------------PANELI LOJTAREVE---------------------------
        paneliLojtareve = new JPanel(null);
        paneliLojtareve.setBounds(Fushe.WIDTH+5,0,1100-Fushe.WIDTH-15,Fushe.HEIGHT);
        paneliLojtareve.setBorder(new LineBorder(Color.black));
        
        //Paneli i Lojtarit 1
        paneliLojtarit1 = new JPanel(null);        
        paneliLojtarit1.setBounds(10,20,200,310);
        paneliLojtarit1.setBorder(new TitledBorder("Lojtari 1"));
        
        
        
        //Paneli Lojtarit2
        paneliLojtarit2 = new JPanel(null);        
        paneliLojtarit2.setBounds(10,340,200,310);
        paneliLojtarit2.setBorder(new TitledBorder("Lojtari 2"));
            
        paneliLojtareve.add(paneliLojtarit1);
        paneliLojtareve.add(paneliLojtarit2);
        //-------------FUND PANELI LOJTAREVE----------------------
        
        //Futje e komponenteve ne panelin kryesor
        panel.add(fusha);
        panel.add(paneliLojtareve);
       
        setBounds(0,0,1100,700);
        setResizable(false);        
        setVisible(true);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    

}
