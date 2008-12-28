package tavell;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

public class Gur {

    private Point koordinata;

    private int pozicioni;

    private boolean iKapur;
    
    private boolean iPerfunduar;
    
    private Lojtar lojtari;
    
    public static String img1 = "whiteChip.gif";
    public static String img2 = "blueChip.gif";    
    public static String imgThin1 = "whiteChipThin.gif";
    public static String imgThin2 = "blueChipThin.gif";        
    
    private SpriteCache sprites;
    
    public Gur () {
        iKapur = false;
        iPerfunduar = false;
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
    
    public boolean getIPerfunduar() {
        return iPerfunduar;
    }
    
    public void setIPerfunduar(boolean val) {
        iPerfunduar = val;
    }
    
    private String getImazhi() {
        if (lojtari.getNumri()==1) {
            if (iPerfunduar) return imgThin1;
            return img1;
        } else {
            if (iPerfunduar) return imgThin2;
            return img2;
        }
    }
    
    public void leviz(KoleksionGuresh[] stivat,int tek) {
        Gur g = stivat[pozicioni].pop();
        stivat[tek].push(g);
    }
    
    public void paraqit(Graphics g,ImageObserver obs) {
        if (koordinata.x>0 && koordinata.x<Fushe.WIDTH &&
            koordinata.y>0 && koordinata.y<Fushe.HEIGHT) {
            g.drawImage(sprites.getSprite(getImazhi()), koordinata.x, koordinata.y, obs);
        }
    }

}

