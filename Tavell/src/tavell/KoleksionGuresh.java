package tavell;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.Stack;
        
public class KoleksionGuresh extends Stack {
    protected int pozicioni;
    private Trekendesh trekendeshi;
    
    public KoleksionGuresh (int poz) {
        trekendeshi = new Trekendesh();
        setPozicioni(poz);        
    }
    
    public KoleksionGuresh() {
        trekendeshi = new Trekendesh();
        setPozicioni(0); 
    }

    public int getPozicioni() {
        return this.pozicioni;
    }
    
    public void setPozicioni(int val){
        this.pozicioni = val;
        Point cepi = cepiMajteTrekendeshit();
        if (cepi.x!=0 && cepi.y!=0) {
            trekendeshi.setPikaA(cepi);
            trekendeshi.setPikaB(new Point(cepi.x+48,cepi.y));
            trekendeshi.setPikaC(new Point(cepi.x+24,cepi.y+trekendeshi.getDrejtimi()*260));
        }
    }
    
    public Trekendesh getTrekendeshi() {
        return trekendeshi;
    }

    public void setTrekendeshi(Trekendesh trekendeshi) {
        this.trekendeshi = trekendeshi;        
    }
    
    public Point cepiMajteTrekendeshit() {
        int x=0,y=0;
        if (pozicioni>=13 && pozicioni<=18) {
            x = 96+48*(pozicioni-13);
            y = 23;
        } else if (pozicioni>=7 && pozicioni<=12) {
            x = 96+48*(12-pozicioni);
            y = Fushe.HEIGHT-23;         
        } else if (pozicioni>=19 && pozicioni <=24) {
            x = Fushe.WIDTH/2+48+48*(pozicioni-19);
            y = 23;
        } else if (pozicioni>=1 && pozicioni<=6) {
            x = Fushe.WIDTH/2+48+48*(6-pozicioni);
            y = Fushe.HEIGHT-23;
        }
        return new Point(x,y);
    }
    
    //Percakto koordinatat e gurit ne ekran
    public Point koordinatatERradhes() {
        int x,y,start,corrector;
        int i = size();
         //Y
        if (pozicioni>=1 && pozicioni <=12) {
            start = Fushe.HEIGHT-23;
            corrector = 0;
            if (i>4) {
                if (i<10) start -= 24;
                else  start -= 48;
                corrector = 5*(int)(i/5);
            }
            y = start-(i-corrector+1)*48; 
            
        } else {
            start = 23;
            corrector = 0;
            if (i>4) {
                if (i<10) start+= 24;
                else  start += 48;
                corrector = 5*(int)(i/5);
            }
            y = start+(i-corrector)*48;
        }
        //X
        if (pozicioni>=13 && pozicioni<=18) {
           x = 96+48*(pozicioni-13);
        } else if (pozicioni>=19 && pozicioni<=24) {
           x = (Fushe.WIDTH/2+48)+48*(pozicioni-19);
        } else if (pozicioni>=7&&pozicioni<=12) {
           x = (Fushe.WIDTH/2-96)-48*(pozicioni-7);
        } else {
           x = (Fushe.WIDTH-96-48)-48*(pozicioni-1);  
        }
        return new Point(x,y);
    }
    
    public void push(Gur g) {
        if (pozicioni!=0) {
            g.setPozicioni(this.pozicioni);
            g.setKoordinata(koordinatatERradhes());
        }       
        
        super.push(g);
    }
    
    @Override
    public Gur pop() {
        return (Gur)super.pop();
    }
    
    @Override
    public Gur get(int i) {
        return (Gur)super.get(i);
    }
    @Override
    public Gur peek() {
        return (Gur)super.peek();
    }
    
    public KoleksionGuresh pop(int nr){
        KoleksionGuresh tmp = new KoleksionGuresh();
        while(nr >0) {
            tmp.push(this.pop());
            nr--;
        }
        return tmp;
    }
    
    public void push(KoleksionGuresh k){
        for(int i=0;i<k.size();i++){
            this.push(k.get(i));
        }
    }
    
    public void paraqit(Graphics g, ImageObserver obs) {
        if (this instanceof KoleksionGuresh) {
            trekendeshi.ngjyros(g);
        }
        for (int i=0; i<size(); i++) {
            try {
                get(i).paraqit(g, obs);
            } catch(Exception e) {
                
            }
        }
    }


}