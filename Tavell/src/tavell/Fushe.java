/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;
import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author Klesti H
 */
public class Fushe extends Canvas {
    public static final int WIDTH = 864;
    public static final int HEIGHT = 656;
    private SpriteCache sprites;
    public static final String background = "background.png";
    private Tavell t;
    
    public Fushe() {
        Lojtar l1 = new Lojtar();
        l1.setEmri("Klesti Hoxha");
        Lojtar l2 = new Lojtar();
        l2.setEmri("Arber Ceni");
        Lojtar lojtaret[] = {l1,l2};
        t = new Tavell(lojtaret);
        sprites = new SpriteCache();
        setBounds(0,0,WIDTH,HEIGHT);
    }
    
    public void paraqitGuret(Graphics g) {
        KoleksionGuresh stivat[] = t.getStivat();
        int k = 0;
        for (int i=1; i<=24; i++) {
            for (int j=0;j<stivat[i].size();j++) {
                //System.out.println(stivat[i].get(j).getKoordinata().toString());
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

}
