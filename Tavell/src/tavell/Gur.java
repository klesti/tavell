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
    
    public void vrit(KoleksionGuresh[] stivat,int tek) {        
        stivat[0].push(stivat[tek].pop());
        if (pozicioni==0) 
            stivat[pozicioni].pop(lojtari);
        else
            stivat[pozicioni].pop();
        stivat[tek].push(this);
    }
    
    public void paraqit(Graphics g,ImageObserver obs) {
        if (koordinata.x>0 && koordinata.x<Fushe.WIDTH &&
            koordinata.y>0 && koordinata.y<Fushe.HEIGHT) {
            //g.drawImage(sprites.getSprite(getImazhi()), koordinata.x, koordinata.y, obs);
            vizato(g,obs);
        }
    }
    
    public void vizato(Graphics g,ImageObserver obs) {
        if (koordinata.x>0 && koordinata.x<Fushe.WIDTH &&
            koordinata.y>0 && koordinata.y<Fushe.HEIGHT) {
            if(lojtari.getNumri()==1){
               if(iPerfunduar) vizatoHolleBardhe(g, obs);
               else vizatoBardhe(g, obs);
            }
            else {
                if(iPerfunduar) vizatoHolleBlu(g, obs);
                else vizatoBlu(g, obs);
            }
        }        
    }
    
    public int getPips() {
        if(lojtari.getNumri()==1)
            return this.pozicioni;
        else
            return 25-pozicioni;
    }
    
    private void vizatoBlu(Graphics g, ImageObserver obs){        
        g.setColor(new Color(82,82,189));
        g.fillOval(koordinata.x, koordinata.y, 48, 48);
        g.setColor(Color.WHITE);
        g.fillOval(koordinata.x+11, koordinata.y+12, 25, 25);
        g.setColor(new Color(51,102,204));
        g.fillOval(koordinata.x+12, koordinata.y+12, 24, 24);
        
    }
    
    private void vizatoBardhe(Graphics g, ImageObserver obs){        
        g.setColor(new Color(245,245,245));
        g.fillOval(koordinata.x, koordinata.y, 48, 48);
        g.setColor(new Color(82,82,189));
        g.fillOval(koordinata.x+11, koordinata.y+12, 25, 25);
        g.setColor(Color.white);
        g.fillOval(koordinata.x+12, koordinata.y+12, 24, 24);        
    }
    
    private void vizatoHolleBlu(Graphics g, ImageObserver obs){        
        g.setColor(new Color(82,82,189));        
        g.fill3DRect(koordinata.x+2, koordinata.y+2, 44, 13, true);
        g.setColor(Color.white);
        g.drawLine(koordinata.x+4, koordinata.y+4, koordinata.x+44, koordinata.y+4);
    }
    
    private void vizatoHolleBardhe(Graphics g, ImageObserver obs){
        g.setColor(Color.white);        
        g.fill3DRect(koordinata.x, koordinata.y, 44, 13, true);
        g.setColor(new Color(82,82,189));
        g.drawLine(koordinata.x+4, koordinata.y+4, koordinata.x+44, koordinata.y+4);
    }
    
}

