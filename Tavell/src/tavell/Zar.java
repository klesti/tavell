package tavell;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.*;

public class Zar 
{
    private int vlera;
    private SpriteCache sprites;    
    public static String [] blueImg = {"blue0.gif","blue1.gif","blue2.gif","blue3.gif","blue4.gif","blue5.gif","blue6.gif"};
    public static String [] whiteImg = {"white0.gif","white1.gif","white2.gif","white3.gif","white4.gif","white5.gif","white6.gif"};
    private String ngjyre;
    private boolean uLuajt;
    
    public Zar () 
    {
        this.vlera = 0;
        this.sprites = new SpriteCache();
        this.uLuajt = false;
    }

    public int getVlera () 
    {
        return vlera;
    }

    public void setVlera (int val) 
    {
        this.vlera = val;
    }  
    
    public String getNgjyre(){
        return this.ngjyre;
    }
    
    public void setNgjyre(String ngjyra){
        this.ngjyre = ngjyra;
    }
    
    public boolean isULuajt() 
    {
        return uLuajt;
    }

    public void setULuajt(boolean uLuajt) 
    {
        this.uLuajt = uLuajt;
        if (uLuajt==true) 
          vlera = 0;
    }
    
    public String getImazhi(){ 
        if(this.ngjyre.equalsIgnoreCase("blue"))
            return blueImg[this.vlera];        
        else if(this.ngjyre.equalsIgnoreCase("white"))
            return whiteImg[this.vlera];
        else return "";
    }
    
    public void hidh () 
    {
        this.vlera = new Random().nextInt(5) + 1;
        uLuajt = false;
    }
    
    public void paraqit(Graphics g, ImageObserver obs, int x, int y){        
        g.drawImage(sprites.getSprite(getImazhi()), x,y, obs);       
    }
}

