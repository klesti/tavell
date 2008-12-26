package tavell;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

public class Gur {

    private Point koordinata;

    private int pozicioni;

    private boolean iKapur;
    
    public static String img = "blueChip.gif";
    
    private SpriteCache sprites;
    
    public Gur () {
        sprites = new SpriteCache();
        koordinata = new Point();
    }

    public boolean getIKapur () {
        return iKapur;
    }

    public void setIKapur (boolean val) {
        this.iKapur = val;
    }

    public Point getKoordinata () {
        return koordinata;
    }

    public void setKoordinata (Point val) {
        this.koordinata = val;
    }

    public int getPozicioni () {
        return pozicioni;
    }

    public void setPozicioni (int val) {
        this.pozicioni = val;
    }
    
    public void paraqit(Graphics g,ImageObserver obs) {
        if (koordinata.x>0 && koordinata.x<Fushe.WIDTH &&
            koordinata.y>0 && koordinata.y<Fushe.HEIGHT) {
            g.drawImage(sprites.getSprite(img), koordinata.x, koordinata.y, obs);
        }
    }

}

