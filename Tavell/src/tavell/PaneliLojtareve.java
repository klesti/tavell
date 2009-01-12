/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
/**
 *
 * @author Arbri
 */
public class PaneliLojtareve extends JPanel{    
    private JPanel paneliLojtarit1;
    private JPanel paneliLojtarit2;
    private JPanel paneliButonave;
    private JLabel emri1;
    private JLabel emri2;
    private JLabel emriLojarit1;
    private JLabel emriLojarit2;
    private JLabel emriAvatar1;
    private JLabel emriAvatar2;
    private AvatarImage avatar1;
    private AvatarImage avatar2;
    private JLabel emriPips1;
    private JLabel emriPips2;
    private JLabel pips1;
    private JLabel pips2;
    private JLabel emriPike1;
    private JLabel emriPike2;
    private JLabel pike1;
    private JLabel pike2;    
    private JButton ruajLojen;
    private JButton lojeRe;
    private JButton ngarko;
    private JButton dorezohu;
    private Loje l;            
    private Fushe fusha;
    
    public PaneliLojtareve() {        
        
        this.setBounds(Fushe.WIDTH+5,0,1100-Fushe.WIDTH-15,Fushe.HEIGHT);
        this.setBorder(new LineBorder(Color.black));
        this.setLayout(null);
        
        //-------------PANELI LOJTAREVE---------------------------   
        
                      
        //Paneli i Lojtarit 1
        paneliLojtarit1 = new JPanel(null);        
        paneliLojtarit1.setBounds(10,20,200,250);
        paneliLojtarit1.setBorder(new TitledBorder("Lojtari 1"));        
             
        emri1 = new JLabel("Emri: ");
        emri1.setBounds(10, 40, 100, 15);
        
        emriLojarit1 = new JLabel("Lojtari 1");
        emriLojarit1.setBounds(50, 40, 200, 15);
        
        emriAvatar1 = new JLabel("Avatar: ");
        emriAvatar1.setBounds(10, 70, 100, 15);
        
        avatar1 = new AvatarImage("male.jpg");
        avatar1.setBounds(60, 60, 40, 40);
        
        emriPips1 = new JLabel("Pips: ");
        emriPips1.setBounds(10, 110, 100, 15);
        
        pips1 = new JLabel("123"); //Do behet lojtar.getPips();
        pips1.setBounds(60, 110, 100, 15);
        
        emriPike1 = new JLabel("Piket: ");
        emriPike1.setBounds(10, 130, 100, 15);
        
        pike1 = new JLabel("3"); // Do behet lojtar.getPike();
        pike1.setBounds(60, 130, 100, 15);
                
        paneliLojtarit1.add(emri1);
        paneliLojtarit1.add(emriLojarit1);
        paneliLojtarit1.add(emriAvatar1);
        paneliLojtarit1.add(avatar1);
        paneliLojtarit1.add(emriPips1);
        paneliLojtarit1.add(pips1);
        paneliLojtarit1.add(emriPike1);
        paneliLojtarit1.add(pike1);
        
        //Paneli Butonave
        paneliButonave = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));        
        paneliButonave.setBounds(10,275,200,120);
        paneliButonave.setBorder(new TitledBorder(""));
        
        ruajLojen = new JButton("Ruaj");
        lojeRe = new JButton("Loje e Re");
        ngarko = new JButton("Ngarko");
        dorezohu = new JButton("Dorezohu");
        
        lojeRe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.fillo();
                getLojeRe().setEnabled(false);
                fusha.rifresko();
                JOptionPane.showMessageDialog(paneliButonave, "Rradhen e ka " +
                        l.getRadha().getLojtar().getEmri());
            }
        });
        
        paneliButonave.add(ruajLojen);
        paneliButonave.add(lojeRe);
        paneliButonave.add(ngarko);
        paneliButonave.add(dorezohu);
        
        //Paneli Lojtarit2
        paneliLojtarit2 = new JPanel(null);        
        paneliLojtarit2.setBounds(10,400,200,250);
        paneliLojtarit2.setBorder(new TitledBorder("Lojtari 2"));
        
        emri2 = new JLabel("Emri: ");
        emri2.setBounds(10, 40, 100, 15);
        
        emriLojarit2 = new JLabel("Lojtari 2");
        emriLojarit2.setBounds(50, 40, 200, 15);
        
        emriAvatar2 = new JLabel("Avatar: ");
        emriAvatar2.setBounds(10, 70, 100, 15);
        
        avatar2 = new AvatarImage("female.jpg");
        avatar2.setBounds(60, 60, 40, 40);
        
        emriPips2= new JLabel("Pips: ");
        emriPips2.setBounds(10, 110, 100, 15);
        
        pips2 = new JLabel("133"); //Do behet lojtar2.merrPips();
        pips2.setBounds(60, 110, 100, 15);
        
        emriPike2 = new JLabel("Pike: ");
        emriPike2.setBounds(10, 130, 100, 15);
        
        pike2 = new JLabel("5");
        pike2.setBounds(60, 130, 100, 15);
        
        paneliLojtarit2.add(emri2);
        paneliLojtarit2.add(emriLojarit2);
        paneliLojtarit2.add(emriAvatar2);
        paneliLojtarit2.add(avatar2);
        paneliLojtarit2.add(emriPips2);
        paneliLojtarit2.add(pips2);
        paneliLojtarit2.add(emriPike2);
        paneliLojtarit2.add(pike2);
        
        
        this.add(paneliLojtarit2); 
        this.add(paneliButonave);
        this.add(paneliLojtarit1);        
        
        //-------------FUND PANELI LOJTAREVE----------------------        
    }
    
    public PaneliLojtareve(Lojtar l1,Lojtar l2, AvatarImage avatar1, AvatarImage avatar2, Loje loja, Fushe f) {        
        
        this.setBounds(Fushe.WIDTH+5,0,1100-Fushe.WIDTH-15,Fushe.HEIGHT);
        this.setBorder(new LineBorder(Color.black));
        this.setLayout(null);
        this.l = loja;
        this.fusha = f;
        
        //-------------PANELI LOJTAREVE---------------------------        
                
        //Paneli i Lojtarit 1
        paneliLojtarit1 = new JPanel(null);        
        paneliLojtarit1.setBounds(10,20,200,250);
        paneliLojtarit1.setBorder(new TitledBorder("Lojtari 1"));        
             
        emri1 = new JLabel("Emri: ");
        emri1.setBounds(10, 40, 100, 15);
        
        emriLojarit1 = new JLabel(l1.getEmri());
        emriLojarit1.setBounds(50, 40, 200, 15);
        
        emriAvatar1 = new JLabel("Avatar: ");
        emriAvatar1.setBounds(10, 70, 100, 15);
        
        avatar1.setBounds(60, 60, 40, 40);
        
        emriPips1 = new JLabel("Pips: ");
        emriPips1.setBounds(10, 110, 100, 15);
        
        pips1 = new JLabel(String.valueOf(l1.getPips()));
        pips1.setBounds(60, 110, 100, 15);
        
        emriPike1 = new JLabel("Piket: ");
        emriPike1.setBounds(10, 130, 100, 15);
        
        pike1 = new JLabel(String.valueOf(l1.getPike()));
        pike1.setBounds(60, 130, 100, 15);
                
        paneliLojtarit1.add(emri1);
        paneliLojtarit1.add(emriLojarit1);
        paneliLojtarit1.add(emriAvatar1);
        paneliLojtarit1.add(avatar1);
        paneliLojtarit1.add(emriPips1);
        paneliLojtarit1.add(pips1);
        paneliLojtarit1.add(emriPike1);
        paneliLojtarit1.add(pike1);
        
        //Paneli Butonave
        paneliButonave = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));        
        paneliButonave.setBounds(10,275,200,120);
        paneliButonave.setBorder(new TitledBorder(""));
        
        ruajLojen = new JButton("Ruaj");
        lojeRe = new JButton("Loje e Re");
        ngarko = new JButton("Ngarko");
        dorezohu = new JButton("Dorezohu");
        
         lojeRe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.fillo();
                getLojeRe().setEnabled(false);
                fusha.rifresko();
                JOptionPane.showMessageDialog(paneliButonave, "Rradhen e ka " +
                        l.getRadha().getLojtar().getEmri());
            }
        });
        
        paneliButonave.add(ruajLojen);
        paneliButonave.add(lojeRe);
        paneliButonave.add(ngarko);
        paneliButonave.add(dorezohu);
        
        //Paneli Lojtarit2
        paneliLojtarit2 = new JPanel(null);        
        paneliLojtarit2.setBounds(10,400,200,250);
        paneliLojtarit2.setBorder(new TitledBorder("Lojtari 2"));
        
        emri2 = new JLabel("Emri: ");
        emri2.setBounds(10, 40, 100, 15);
        
        emriLojarit2 = new JLabel(l2.getEmri());
        emriLojarit2.setBounds(50, 40, 200, 15);
        
        emriAvatar2 = new JLabel("Avatar: ");
        emriAvatar2.setBounds(10, 70, 100, 15);
        
        //avatar2 = new AvatarImage("female.jpg");
        avatar2.setBounds(60, 60, 40, 40);
        
        emriPips2= new JLabel("Pips: ");
        emriPips2.setBounds(10, 110, 100, 15);
        
        pips2 = new JLabel(String.valueOf(l2.getPips()));
        pips2.setBounds(60, 110, 100, 15);
        
        emriPike2 = new JLabel("Pike: ");
        emriPike2.setBounds(10, 130, 100, 15);
        
        pike2 = new JLabel(String.valueOf(l2.getPike()));
        pike2.setBounds(60, 130, 100, 15);
        
        paneliLojtarit2.add(emri2);
        paneliLojtarit2.add(emriLojarit2);
        paneliLojtarit2.add(emriAvatar2);
        paneliLojtarit2.add(avatar2);
        paneliLojtarit2.add(emriPips2);
        paneliLojtarit2.add(pips2);
        paneliLojtarit2.add(emriPike2);
        paneliLojtarit2.add(pike2);
        
        
        this.add(paneliLojtarit2); 
        this.add(paneliButonave);
        this.add(paneliLojtarit1);        
        
        //-------------FUND PANELI LOJTAREVE----------------------        
       
    }
    
    public void updatePaneliLojtareve() {
        this.setPips2(this.l.getLojtaret()[1].getPips());
        this.setPips1(this.l.getLojtaret()[0].getPips());
        this.setPike2(this.l.getLojtaret()[1].getPike());
        this.setPike1(this.l.getLojtaret()[0].getPike());    
        if (this.l.getRadha().getLojtar() == this.l.getLojtaret()[0]) {
            this.paneliLojtarit1.setBackground(Color.LIGHT_GRAY);            
            this.paneliLojtarit2.setBackground(null);
        }
        else if (this.l.getRadha().getLojtar() == this.l.getLojtaret()[1]) {
            this.paneliLojtarit2.setBackground(Color.LIGHT_GRAY);            
            this.paneliLojtarit1.setBackground(null);
        }
    }
    
    public void setPips1(int pips){
        this.pips1.setText(String.valueOf(pips));
    }
    
    public void setPips2(int pips){
        this.pips2.setText(String.valueOf(pips));       
    }
    
    public void setPike1(int pike){
        this.pike1.setText(String.valueOf(pike));        
    }
    
    public void setPike2 (int pike){
        this.pike2.setText(String.valueOf(pike));
    }
    
    public Loje getLoje(){
        return this.l;
    }

    public JButton getLojeRe() {
        return lojeRe;
    } 
}
