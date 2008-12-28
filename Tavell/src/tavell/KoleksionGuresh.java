package tavell;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.Stack;
        
public class KoleksionGuresh extends Stack {
    private int pozicioni;
    
    public KoleksionGuresh (int poz) {
        pozicioni = poz;
    }
    
    public KoleksionGuresh() {
        pozicioni = 0;        
    }

    public int getPozicioni() {
        return this.pozicioni;
    }
    
    public void setPozicioni(int val){
        this.pozicioni = val;
    }
    
    //Percakto koordinatat e gurit ne ekran
    public Point koordinatatERradhes() {
        int x,y,start,corrector;
        int i = size();
         //Y
        if (pozicioni>=1 && pozicioni <=12) {
            start = Fushe.HEIGHT-23;
            corrector = 0;
            if (i>5) {
                if (i<=10) start -= 24;
                else if (i>10) start -= 48;
                corrector = 5*(int)(i/5)+1;
            }
            y = start-(i-corrector+1)*48; 
            System.out.println(String.valueOf(Fushe.HEIGHT-23-y));
           
        } else {
            start = 23;
            corrector = 0;
            if (i>5) {
                if (i<=10) start+= 24;
                else if (i>10) start += 48;
                corrector = 5*(int)(i/5)+1;
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
        
    }
}