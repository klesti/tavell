/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
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
    
    public void paraqitZar(Graphics g){
        Zar z = new Zar();
        z.setNgjyre("blue");
        z.hidh();
        z.paraqit(g, this, 3*WIDTH/4, HEIGHT/2-24);
    }
    
    public void paraqitZaret(Graphics g){
        CiftZaresh zaret = new CiftZaresh();        
        zaret.hidhZaret();
        zaret.paraqit(g, this, 3*WIDTH/4, HEIGHT/2-24);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(sprites.getSprite(background),0,0,this);
        paraqitGuret(g);   
        //paraqitZar(g);
        paraqitZaret(g);
    }
    
    public class Listener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
             
        }
    }   
    
    public boolean neTrekendesh(Point P, Point P1, Point P2, Point P3)
    {
        int b0 = ((P2.x - P1.x) * (P3.y - P1.y) - (P3.x - P1.x) * (P2.y - P1.y));
        double b1 = (((P2.x - P.x) * (P3.y - P.y) - (P3.x - P.x) * (P2.y - P.y)) / b0);
        double b2 = (((P3.x - P.x) * (P1.y - P.y) - (P1.x - P.x) * (P3.y - P.y)) / b0);
        double b3 = 1 - b1 - b2;

        if ((b1 > 0) && (b2 > 0) && (b3 > 0))
            return true;
        else
            return false;        
    }

}
