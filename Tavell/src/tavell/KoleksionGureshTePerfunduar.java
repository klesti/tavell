
package tavell;

import java.awt.Point;

/**
 *
 * @author Klesti H
 */
public class KoleksionGureshTePerfunduar extends KoleksionGuresh {
    private int startY;
    private int startX;
    private int direction;
    private Lojtar lojtari;
    
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

}
