package tavell;

import java.util.Stack;
        
public class KoleksionGuresh extends Stack {
    private int pozicioni;
    
    public KoleksionGuresh () {
        
    }

    public void push(Gur g) {
        g.setPozicioni(this.pozicioni);
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