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
}