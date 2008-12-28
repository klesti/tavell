package tavell;

import java.awt.Point;
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
        int x,y;
        int i = size();
         //Y
        if (pozicioni>=1 && pozicioni <=12) {
            y = (Fushe.HEIGHT-23)-(i+1)*48;         
        } else {
            y = 23+i*48;
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
}