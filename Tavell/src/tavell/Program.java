/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import javax.swing.*;

/**
 *
 * @author Arbri
 */
public class Program extends JFrame{
    
    //Deklarimi i variableve
    private Lojtar lojtari1;
    private Lojtar lojtari2;
    private AvatarImage avatar1;
    private AvatarImage avatar2;
    private Loje loja;
    private JPanel panel;
    private PaneliLojtareve paneliLojtareve;
    private Fushe fusha; 
    
    public Program(){
        ZgjidhLojeGUI zgjidh = new ZgjidhLojeGUI(this);
        zgjidh.setVisible(true);
        while(zgjidh.isVisible()) {
            //Mos bej asgje
        }        
        //System.out.println("Loja e zgjedhur: "+loja.getClass().getName()+" \n Lojtari 1: "+lojtari1.getEmri()+" \n Lojtari 2: "+lojtari2.getEmri()+" \n Piket :"+String.valueOf(loja.getPiket())+"\n Avatar 1: "+avatar1.getFileName()+"\n Avatar2: "+avatar2.getFileName());
        setTitle("Tavell");
        
        panel = (JPanel)getContentPane();
        fusha = new Fushe(this.lojtari1, this.lojtari2, this.loja);
        fusha.setBounds(0,0,Fushe.WIDTH,Fushe.HEIGHT);
        panel.setPreferredSize(new java.awt.Dimension(Fushe.WIDTH,Fushe.HEIGHT));
        panel.setLayout(null);
        paneliLojtareve = new PaneliLojtareve(lojtari1,lojtari2,avatar1,avatar2);
        
        panel.add(fusha);
        panel.add(paneliLojtareve);       
        
        setBounds(0,0,1100,700);
        setResizable(false);        
        setVisible(true);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setLojtari1(Lojtar l){
        this.lojtari1 = l;
    }
    
    public Lojtar getLojtari1(){
        return this.lojtari1;
    }
    
    public void setLojtari2(Lojtar l){
        this.lojtari2 = l;
    }
    
    public Lojtar getLojtari2(){
        return this.lojtari2;
    }
    
    public void setAvatar1(AvatarImage a){
        this.avatar1 = a;
    }
    
    public AvatarImage getAvatar1(){
        return this.avatar1;
    }
    
    public void setAvatar2(AvatarImage a){
        this.avatar2 = a;
    }
    
    public AvatarImage getAvatar2(){
        return this.avatar2;
    }
    
    public void setLoja(Loje l){
        this.loja = l;
    }
    
    public Loje getLoja(){
        return this.loja;
    }
    
}
