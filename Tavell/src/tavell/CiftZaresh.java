package tavell;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList; 

public class CiftZaresh 
{
    private ArrayList<Zar> zaret;  
    private RadheLevizje radha;

    public CiftZaresh (RadheLevizje r)
    {
        this.radha = r;
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
        return (getVlera1()==getVlera2());
    }
    
    public void reset() {
        zaret.get(0).reset();
        zaret.get(1).reset();
    }
    
    public int getShuma() {
        if (eshteDopio())
            return 4*getVlera1();
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
        return getVlera1();
    }
    
    public boolean janeHedhur() {
        return (getVlera1()!=0 && getVlera2()!=0);
    }
    
    public void paraqit(Graphics g, ImageObserver obs,int x,int y) {
        String ngjyra;
        if (radha.getLojtar()==null || radha.getLojtar().getNumri()==1)
            ngjyra = "white";
        else 
            ngjyra = "blue";
        
        zaret.get(0).setNgjyre(ngjyra);
        zaret.get(0).paraqit(g, obs, x, y);
        zaret.get(1).setNgjyre(ngjyra);
        zaret.get(1).paraqit(g, obs, x-58, y);
    }
    
    public boolean eshteLuajturNdonje(){
        return(zaret.get(0).isULuajt() || zaret.get(1).isULuajt());
    }
}

