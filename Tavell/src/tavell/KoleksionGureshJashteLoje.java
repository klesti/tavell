package tavell;

import java.awt.Point;

/**
 *
 * @author Klesti H
 */
public class KoleksionGureshJashteLoje extends KoleksionGuresh {
    private int startX;
    
    public KoleksionGureshJashteLoje(int poz) {
        super(poz);
        startX = Fushe.WIDTH/2-24;
    }
    
    public Point koordinatatERradhes(Lojtar lojtari) {
        int startY, direction,y;
        int i = size(lojtari);
        if (lojtari.getNumri()==1) {
            startY = 50;
            direction = 1;
        } else {
            startY = Fushe.HEIGHT-98;
            direction = -1;
        }
        
        y = startY+direction*i*48;
        
        return new Point(startX,y);
    }
    
    @Override
    public void push(Gur g) {
        g.setPozicioni(pozicioni);
        g.setKoordinata(koordinatatERradhes(g.getLojtari()));
    //Zhvendos gurin ne stivat e lojtarit                    
        g.getLojtari().getNeLoje().remove(g);
        super.push(g);        
    }
    
    @Override 
    public Gur pop() {   
        Gur g = super.pop();
     //Zhvendos gurin ne stivat e lojtarit           
        g.getLojtari().getNeLoje().push(g);
        return g;
    }
    
    @Override
    public Gur pop(Lojtar l) {
        int i = 0;
        while (size()>0) {
            if (get(i).getLojtari()==l) {
                Gur g = get(i);
                remove(g);
                return g;
            }
        }
        return null;
    }
    
    public int size(Lojtar lojtari) {
        int s = 0;
        for (int i=0;i<size();i++) {
            if (lojtari.equals(get(i).getLojtari())) {
                s++;
            }
        }
        return s;
    }
}
