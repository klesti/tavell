/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
    
    public Fushe(Lojtar l1, Lojtar l2, Loje l) {        
        this.l = l;
        Lojtar[] lojtaret = {l1,l2};
        l.setLojtaret(lojtaret);
        sprites = new SpriteCache();      
        setBounds(0,0,WIDTH,HEIGHT);
        addMouseListener(new Listener());
    }
    
    public Fushe() {
        Lojtar l1 = new Lojtar("Klesti Hoxha",1);
        Lojtar l2 = new Lojtar("Arber Ceni",2);        
        l2.setEmri("Arber Ceni");
        Lojtar lojtaret[] = {l1,l2};
        l = new Tavell(lojtaret,24);      
        sprites = new SpriteCache();      
        setBounds(0,0,WIDTH,HEIGHT);
        addMouseListener(new Listener());        
    }
    
    public void paraqitGuret(Graphics g) {
        KoleksionGuresh stivat[] = l.getStivat();
        for (int i=0; i<=26; i++) {
            stivat[i].paraqit(g, this);
        }
    }
    
    public void paraqitZar(Graphics g){
        Zar z = new Zar();
        z.setNgjyre("blue");
        z.hidh();
        z.paraqit(g, this, 3*WIDTH/4, HEIGHT/2-24);
    }
    
    public void paraqitZaret(Graphics g){
        CiftZaresh zaret = new CiftZaresh();        
        zaret.hidhZaret();
        zaret.paraqit(g, this, 3*WIDTH/4, HEIGHT/2-24);
    }
    
    @Override
    public void paint(Graphics g) {
        g = Program.strategy.getDrawGraphics();
        g.drawImage(sprites.getSprite(background),0,0,this);
        paraqitGuret(g);   
        //paraqitZar(g);
        paraqitZaret(g);        
        Program.strategy.show();
    }
    
     public class Listener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
           l.getStivat()[shtyllaKuNdodhet(new Point(e.getX(),e.getY()))].getTrekendeshi().setNgjyra(Color.yellow);
           Graphics g = Program.strategy.getDrawGraphics();
           update(g);
           Program.strategy.show();
        }
    }
    
    public int shtyllaKuNdodhet(Point p) {
        int shtylla=-1; // Kthen -1 nqs pika nuk ndodhet ne asnje shtylle
        //-----------------Pjesa lart majtas----------------------------
        if ((p.x >=96 && p.x <= Fushe.WIDTH / 2 - 48) && (p.y <= Fushe.HEIGHT / 2)) {
             shtylla = 13 + (int)Math.ceil((p.x - 96) / 48);
        }  
        //-----------------Pjesa poshte majtas----------------------------
        else if ((p.x>=96 && p.x<=Fushe.WIDTH/2-48) && (p.y>Fushe.HEIGHT/2)) {
            shtylla = 12 - (int)Math.ceil((p.x - 96) / 48);
        }
        //-----------------Pjesa lart djathtas----------------------------
        else if ((p.x>=Fushe.WIDTH/2+48 && p.x<=Fushe.WIDTH-96) && (p.y<Fushe.HEIGHT/2)) {
            shtylla = 19 + (int)Math.ceil((p.x - Fushe.WIDTH/2-48) / 48);
        } 
        //-----------------Pjesa poshte djathtas----------------------------
        else if ((p.x>=Fushe.WIDTH/2+48 && p.x<=Fushe.WIDTH-96) && (p.y>Fushe.HEIGHT/2)) {
            shtylla = 6 - (int)Math.ceil((p.x - Fushe.WIDTH/2-48) / 48);
        }
        //-----------------Pjesa lart ne mes (te vrare)----------------------------
        else if ((p.x>=Fushe.WIDTH/2-24 && p.x<=Fushe.WIDTH+24) && (p.y<Fushe.HEIGHT/2)) {
            shtylla = 25;
        }
        //-----------------Pjesa poshte ne mes (te vrare)----------------------------
        else if ((p.x>=Fushe.WIDTH/2-24 && p.x<=Fushe.WIDTH+24) && (p.y>Fushe.HEIGHT/2)) {
            shtylla = 26;
        }
        
        return shtylla;
    }

}
