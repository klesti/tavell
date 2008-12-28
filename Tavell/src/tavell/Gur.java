package tavell;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

public class Gur {

    private Point koordinata;

    private int pozicioni;

    private boolean iKapur;
    
    private Lojtar lojtari;
    
    public static String img1 = "blueChip.gif";
    public static String img2 = "whiteChip.gif";
    
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
    
        public Lojtar getLojtari() {
        return lojtari;
    }

    public void setLojtari(Lojtar lojtari) {
        this.lojtari = lojtari;
    }
    
    private String getImazhi() {
        if (lojtari.getNumri()%2==0) {
            return img1;
        } else {
            return img2;
        }
    }
    public void paraqit(Graphics g,ImageObserver obs) {
        if (koordinata.x>0 && koordinata.x<Fushe.WIDTH &&
            koordinata.y>0 && koordinata.y<Fushe.HEIGHT) {
            g.drawImage(sprites.getSprite(getImazhi()), koordinata.x, koordinata.y, obs);
        }
    }

}

