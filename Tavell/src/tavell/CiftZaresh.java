package tavell;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList; 

public class CiftZaresh 
{
    private ArrayList<Zar> zaret;

    public CiftZaresh ()
    {
        this.zaret = new ArrayList<Zar>(2);
        this.zaret.add(new Zar());
        this.zaret.add(new Zar());        
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
        if(this.zaret.size()==0){
            this.zaret.add(nje);
            this.zaret.add(dy);
        }
        else {
            this.zaret.set(0, nje);
            this.zaret.set(1, dy);
        }
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
    
    public boolean uLuajten ()
    {
        if (this.zaret.get(0).isULuajt() && this.zaret.get(1).isULuajt())
            return true;
        else
            return false;
    }
    
    public boolean eshteDopio()
    {
        if (this.zaret.get(0).getVlera() == this.zaret.get(1).getVlera())
            return true;
        else
            return false;
    }
    
    public boolean janeHedhur() {
        return (this.zaret.get(0).getVlera() == 0 && this.zaret.get(1).getVlera() == 0);
    }
    
    public void paraqit(Graphics g, ImageObserver obs,int x,int y) {
        this.zaret.get(0).setNgjyre("blue");
        this.zaret.get(0).paraqit(g, obs, x, y);
        this.zaret.get(1).setNgjyre("blue");
        this.zaret.get(1).paraqit(g, obs, x-58, y);
    }
}

