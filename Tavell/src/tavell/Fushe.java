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
    
    public Fushe() {
        Lojtar l1 = new Lojtar("Klesti Hoxha",1);
        Lojtar l2 = new Lojtar("Arber Ceni",2);
        
        l2.setEmri("Arber Ceni");
        Lojtar lojtaret[] = {l1,l2};
        l = new Tavell(lojtaret);
        //Simulo Levizje Guri              
        
        KoleksionGuresh[] stivat = l.getStivat();
        
        stivat[24].peek().leviz(stivat,25);
        stivat[24].peek().leviz(stivat,25);
        stivat[13].peek().leviz(stivat, 25);
        stivat[1].peek().leviz(stivat,26);
        stivat[12].peek().leviz(stivat,26);
        stivat[12].peek().leviz(stivat,26);
        
        stivat[12].peek().leviz(stivat, 0); //Guri u vra
        stivat[13].peek().leviz(stivat, 0); //Guri u vra
        stivat[13].peek().leviz(stivat, 0); //Guri u vra
        
        /*
        stivat[24].peek().leviz(stivat, 25);
        stivat[24].peek().leviz(stivat, 25);
        stivat[12].peek().leviz(stivat, 26);
        stivat[12].peek().leviz(stivat, 26);
            */
         // Fund Simulim
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
        g.drawImage(sprites.getSprite(background),0,0,this);
        ngjyrosTrekendesh(g);
        paraqitGuret(g);   
        //paraqitZar(g);
        paraqitZaret(g);        
    }
    
    public void ngjyrosTrekendesh(Graphics g) {
        Trekendesh treKend;
        Point p1 = new Point(96,24);
        Point p2 = new Point(96+48,24);
        Point p3 = new Point(96+24,24+260);
        treKend = new Trekendesh(p1, p2, p3);
        g.setColor(Color.yellow);
        for (int i=96;i<96+48;i++) {
            for (int j=24;j<24+360;j++) {
                Point pika = new Point(i,j);
                if (treKend.neTrekendesh(pika)) {
                    g.drawLine(i, j, i, j);
                }
                
            }
        }
    }
    
    public class Listener extends MouseAdapter {
        Trekendesh treKend;
        @Override
        public void mouseClicked(MouseEvent e) {
            Point pika = new Point(e.getX(),e.getY());
            String s = String.valueOf(shtyllaKuNdodhet(pika));
            System.out.println(s);
            Point p1 = new Point(96,24);
            Point p2 = new Point(96+48,24);
            Point p3 = new Point(96+24,24+260);
            treKend = new Trekendesh(p1, p2, p3);
            if (treKend.neTrekendesh(pika)) {
                System.out.println("Ne trekendeshin e pare");
            } else {
                System.out.println("Jashte trekendeshit te pare");
            }            
        }
    }
    
    public int shtyllaKuNdodhet(Point p) {
        int shtylla=-1; // Kthen -1 nqs pika nuk ndodhet ne asnje shtylle
        //-----------------Pjesa lart majtas----------------------------
        if ((p.x>=96 && p.x<=Fushe.WIDTH/2-48) && (p.y<=Fushe.HEIGHT/2)) {
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
