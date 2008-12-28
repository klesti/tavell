/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Klesti H
 */
public class Fushe extends Canvas {
    public static final int WIDTH = 864;
    public static final int HEIGHT = 656;
    private SpriteCache sprites;
    public static final String background = "background.png";
    private Loje l;
    
    public Fushe() {
        Lojtar l1 = new Lojtar("Klesti Hoxha",1);
        Lojtar l2 = new Lojtar("Arber Ceni",2);
        
        l2.setEmri("Arber Ceni");
        Lojtar lojtaret[] = {l1,l2};
        l = new Tavell(lojtaret);
        //Simulo Levizje Guri              
        
        KoleksionGuresh[] stivat = l.getStivat();
        
        stivat[24].peek().leviz(stivat,25);
        stivat[24].peek().leviz(stivat,25);
        stivat[13].peek().leviz(stivat, 25);
        stivat[1].peek().leviz(stivat,26);
        stivat[12].peek().leviz(stivat,26);
        stivat[12].peek().leviz(stivat,26);
        
        stivat[12].peek().leviz(stivat, 0); //Guri u vra
        stivat[13].peek().leviz(stivat, 0); //Guri u vra
        stivat[13].peek().leviz(stivat, 0); //Guri u vra
        
        /*
        stivat[24].peek().leviz(stivat, 25);
        stivat[24].peek().leviz(stivat, 25);
        stivat[12].peek().leviz(stivat, 26);
        stivat[12].peek().leviz(stivat, 26);
            */
         // Fund Simulim
        sprites = new SpriteCache();      
        setBounds(0,0,WIDTH,HEIGHT);
        addMouseListener(new Listener());
    }
    
    public void paraqitGuret(Graphics g) {
        KoleksionGuresh stivat[] = l.getStivat();
        for (int i=0; i<=26; i++) {
            stivat[i].paraqit(g, this);
        }
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(sprites.getSprite(background),0,0,this);
        paraqitGuret(g);    
    }
    
    public class Listener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
             
        }
    }   
    

}
