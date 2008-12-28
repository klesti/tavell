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
        sprites = new SpriteCache();
        setBounds(0,0,WIDTH,HEIGHT);
        addMouseListener(new Listener());
    }
    
    public void paraqitGuret(Graphics g) {
        KoleksionGuresh stivat[] = l.getStivat();
        for (int i=1; i<=24; i++) {
            for (int j=0;j<stivat[i].size();j++) {
                try {
                    stivat[i].get(j).paraqit(g, this);
                }
                catch (Exception e) {
                    
                }
            }     
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
