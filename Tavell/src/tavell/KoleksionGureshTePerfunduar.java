
package tavell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

/**
 *
 * @author Klesti H
 */
public class KoleksionGureshTePerfunduar extends KoleksionGuresh {
    private int startY;
    private int startX;
    private int direction;
    private Lojtar lojtari;
    private Color ngjyre;
    
    public Color getNgjyre() {
        return ngjyre;
    }

    public void setNgjyre(Color ngjyre) {
        this.ngjyre = ngjyre;
    }    
    
    public KoleksionGureshTePerfunduar(int poz,Loje l,Lojtar lojtar) {
        super(poz);
        lojtari = lojtar;
        if (l instanceof Qyl && lojtar.getNumri()==2) {
            startX = 24;
        } else {
            startX = 792;
        }
        if (lojtar.getNumri()==2) {
            startY = 23;
            direction = 1;
        }  else {        
            startY = Fushe.HEIGHT-23-15;
            direction = -1;
        }        
    }
    
    @Override
    public Point koordinatatERradhes() {
        int y = 0;
        int i = size();
        y = startY+direction*i*14;
        return new Point(startX,y);
    }
    
    public void ngjyros(Graphics g,Color c) {
        if (ngjyre==null) {
            return;
        }
        Color old = g.getColor();
        g.setColor(c);
        if (startY==23) {
            g.fillRect(startX, startY, 50, 281);            
        } else {
             g.fillRect(startX, startY-281+14, 50, 281);
        }
        g.setColor(old);
    }
    
    @Override
    public void push(Gur g) {
        g.setIPerfunduar(true);
        g.setKoordinata(koordinatatERradhes());
        g.setPozicioni(pozicioni);
    //Zhvendos gurin ne stivat e lojtarit
        lojtari.getNeLoje().remove(g);
        lojtari.getTePerfunduar().push(g);
        super.push(g);
    }
    
    @Override
    public void paraqit(Graphics g,ImageObserver obs) {
        super.paraqit(g, obs);
        ngjyros(g,ngjyre);
    }
  

}
