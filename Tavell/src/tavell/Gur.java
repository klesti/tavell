package tavell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

public class Gur 
{
    private Point koordinata;
    private int pozicioni;
    private boolean iKapur;    
    private boolean iPerfunduar;    
    private Lojtar lojtari;
    private Point qendra;
    private static final int rrezja = 24;

    public static String img1 = "whiteChip.gif";
    public static String img2 = "blueChip.gif";    
    public static String imgThin1 = "whiteChipThin.gif";
    public static String imgThin2 = "blueChipThin.gif";        
    
    private SpriteCache sprites;
    
    public Gur () 
    {
        iKapur = false;
        iPerfunduar = false;
        sprites = new SpriteCache();
        koordinata = new Point();
        qendra = new Point();
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
        this.setQendra(val.x + rrezja, val.y + rrezja);
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
    
    public Point getQendra() {
        return qendra;
    }

    public void setQendra(Point qendra) {
        this.qendra = qendra;
    }
    
    public void setQendra(int x, int y)
    {
        this.qendra.x = x;
        this.qendra.y = y;
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
    
    public boolean neRreth(Point P)
    {
        if (P.distance(this.qendra) > rrezja)
            return false;
        else 
            return true;
    }
    
    public void leviz(KoleksionGuresh[] stivat,int tek) {
        stivat[pozicioni].pop();
        stivat[tek].push(this);
    }
    
    public void paraqit(Graphics g,ImageObserver obs) {
        if (koordinata.x>0 && koordinata.x<Fushe.WIDTH &&
            koordinata.y>0 && koordinata.y<Fushe.HEIGHT) {
            g.drawImage(sprites.getSprite(getImazhi()), koordinata.x, koordinata.y, obs);            
            //vizato(g,obs);
        }
    }
    
    public void vizato(Graphics g,ImageObserver obs) {
        if (koordinata.x>0 && koordinata.x<Fushe.WIDTH &&
            koordinata.y>0 && koordinata.y<Fushe.HEIGHT) {
            //g.drawImage(sprites.getSprite(getImazhi()), koordinata.x, koordinata.y, obs);            
            g.setColor(Color.black);
            g.fillOval(koordinata.x, koordinata.y, 48, 48);
            g.setColor(Color.RED);
            g.fillOval(koordinata.x+10, koordinata.y+10, 28, 28);            
        }
    }
    
    public int getPips() {
        if(lojtari.getNumri()==1)
            return this.pozicioni;
        else
            return 25-pozicioni;
    }
}

