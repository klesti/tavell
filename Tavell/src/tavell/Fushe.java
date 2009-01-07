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
    }
    
    public void paraqitGuret(Graphics g) {
        KoleksionGuresh stivat[] = l.getStivat();
        for (int i=0; i<=26; i++) {
            stivat[i].paraqit(g, this);
        }
    }
    
    public void paraqitZar(Graphics g){
        Zar z = new Zar();        
        z.hidh();
        z.paraqit(g, this, 3*WIDTH/4, HEIGHT/2-24);
    }
    
    public void paraqitZaret(Graphics g){
        CiftZaresh zaret = l.getZaret();        
        zaret.paraqit(g, this, 3*WIDTH/4, HEIGHT/2-24);
        l.setZaret(zaret);
    }
    
    @Override
    public void paint(Graphics g) {
        g = Program.strategy.getDrawGraphics();
        g.drawImage(sprites.getSprite(background),0,0,this);
        paraqitGuret(g);
        paraqitZaret(g);        
        Program.strategy.show();
    }
    
    @Override
    public void update(Graphics g)
    {
        g = Program.strategy.getDrawGraphics();
        super.update(g);
        Program.strategy.show();
    }
    
    public void rifresko() {
        update(getGraphics());
    }
    /*
     *   Mouse Listener
     **/
    public class Listener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
           cngjyrosTrekendeshat();
           int poz = pozicioniKuNdodhet(e.getPoint());
           if (poz>=1 && poz<=24) {
               tregoLevizjetELejuara(poz);
           } else if (poz==-2) { //Klikim mbi zaret
               hidhZaret();
           }
           update(getGraphics());
        }
        
        public void hidhZaret() {
           l.getZaret().setZaret(0,0);
           rifresko();
           try { 
             Thread.sleep(700);
           } catch (InterruptedException ex) {}

           l.getZaret().hidhZaret();    
        }
        
        public void cngjyrosTrekendeshat() {
            for(int i=0;i<l.getStivat().length;i++){
                l.getStivat()[i].getTrekendeshi().setNgjyra(null);
            }        
        }
        
        public void tregoLevizjetELejuara(int poz) {
           int tmp [] = l.getLevizjetELejuara(l.getStivat()[poz]);
           for (int j=0;j<tmp.length && tmp[j]>0;j++) {               
               l.getStivat()[tmp[j]].getTrekendeshi().setNgjyra(Color.yellow); 
           }
        }
        
        public int pozicioniKuNdodhet(Point p) {
            int pozicioni=-1; // Kthen -1 nqs pika nuk ndodhet ne asnje shtylle
            //-----------------Pjesa lart majtas----------------------------
            if ((p.x >=96 && p.x <= Fushe.WIDTH / 2 - 48) && (p.y <= Fushe.HEIGHT / 2 - 25)) {
                 pozicioni = 13 + (int)Math.ceil((p.x - 96) / 48);
            }  
            //-----------------Pjesa poshte majtas----------------------------
            else if ((p.x>=96 && p.x<=Fushe.WIDTH/2-48) && (p.y>Fushe.HEIGHT/2 + 25)) {
                pozicioni = 12 - (int)Math.ceil((p.x - 96) / 48);
            }
            //-----------------Pjesa lart djathtas----------------------------
            else if ((p.x>=Fushe.WIDTH/2+48 && p.x<=Fushe.WIDTH-96) && (p.y< Fushe.HEIGHT/2 - 25)) {
                pozicioni = 19 + (int)Math.ceil((p.x - Fushe.WIDTH/2-48) / 48);
            } 
            //-----------------Pjesa poshte djathtas----------------------------
            else if ((p.x>=Fushe.WIDTH/2+48 && p.x<=Fushe.WIDTH-96) && (p.y>Fushe.HEIGHT/2 + 25)) {
                pozicioni = 6 - (int)Math.ceil((p.x - Fushe.WIDTH/2-48) / 48);
            }
            //-----------------Pjesa lart ne mes (te vrare)----------------------------
            else if ((p.x>=Fushe.WIDTH/2-24 && p.x<=Fushe.WIDTH/2+24) && (p.y<Fushe.HEIGHT/2)) {
                pozicioni = 25;
            }
            //-----------------Pjesa poshte ne mes (te vrare)----------------------------
            else if ((p.x>=Fushe.WIDTH/2-24 && p.x<=Fushe.WIDTH/2+24) && (p.y>Fushe.HEIGHT/2)) {
                pozicioni = 26;
            } 
            else if (p.x>=(3*WIDTH/4)-58 && p.x<=(3*WIDTH/4)+49 && p.y>=HEIGHT/2-24 && p.y<=HEIGHT/2-24+49) {
                pozicioni = -2; //Klikim mbi zaret
            }
            
            System.out.println(pozicioni);
            
            return pozicioni;
        }     
        
        
    }
    /*
     *  End Mouse Listener
     **/
    


}
