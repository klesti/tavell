package tavell;

import java.util.ArrayList; 

public class CiftZaresh 
{
    private ArrayList<Zar> zaret;

    public CiftZaresh ()
    {
        this.zaret = new ArrayList(2);
        this.zaret.set(0, new Zar());
        this.zaret.set(1, new Zar());
    }

    public ArrayList<Zar> getZaret () 
    {
        return zaret;
    }

    public void setZaret (ArrayList<Zar> val) 
    {
        this.zaret = val;
    }
    
    public void setZaret (Zar nje, Zar dy)
    {
        this.zaret.set(0, nje);
        this.zaret.set(1, dy);
    }
    
    public void setZaret (int nje, int dy)
    {
        this.zaret.get(0).setVlera(nje);
        this.zaret.get(1).setVlera(dy);
    }

    public void hidhZaret () 
    {
        this.zaret.get(0).hidh();
        this.zaret.get(1).hidh();
    }
}

