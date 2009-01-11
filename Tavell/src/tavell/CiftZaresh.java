package tavell;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList; 

public class CiftZaresh 
{
    private ArrayList<Zar> zaret;
    private boolean ishteDopio;
    private int vleraDopio;    

    public CiftZaresh ()
    {
        this.zaret = new ArrayList<Zar>(2);
        this.zaret.add(new Zar());
        this.zaret.add(new Zar());  
        ishteDopio = false;
        vleraDopio = 0;        
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
        vleraDopio = 0;
        ishteDopio = false;        
        if(this.zaret.size()==0){
            this.zaret.add(nje);
            this.zaret.add(dy);
        }
        else {
            this.zaret.set(0, nje);
            this.zaret.set(1, dy);
        }
         if (eshteDopio()) {
            ishteDopio = true;
            vleraDopio = getVlera1();
        }
    }
    
    public void setZaret (int nje, int dy)
    {
        ishteDopio = false;
        vleraDopio = 0;
        this.zaret.get(0).setVlera(nje);
        this.zaret.get(1).setVlera(dy);
        if (eshteDopio()) {
            ishteDopio = true;
            vleraDopio = getVlera1();
        }
    }

    public void hidhZaret () 
    {   
        ishteDopio = false;
        vleraDopio = 0;
        this.zaret.get(0).hidh();       
        this.zaret.get(1).hidh();
        if (eshteDopio()) {
            ishteDopio = true;
            vleraDopio = getVlera1();
        }        
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
        if (getVlera1() == getVlera2() ||
            (getVlera1()==0 && getVlera2()!=0 && ishteDopio) || 
            (getVlera2()==0 && getVlera1()!=0 && ishteDopio) )
            return true;
        else
            return false;
    }
    
    public int getShuma() {
        if (eshteDopio())
            return 4*vleraDopio;
        else 
            return getVlera1()+getVlera2();
    }
    
    public int getVlera1() {
        return zaret.get(0).getVlera();
    }
    
    public int getVlera2() {
        return zaret.get(1).getVlera();
    }
    
    public int getVleraDopio() {
        return vleraDopio;
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
    
    public boolean eshteLuajturNdonje(){
        return(zaret.get(0).isULuajt() || zaret.get(1).isULuajt());
    }
}

