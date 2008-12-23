package tavell;

import java.util.*;

public class Zar 
{
    private int vlera;

    public Zar () 
    {
        this.vlera = 0;
    }

    public int getVlera () 
    {
        return vlera;
    }

    public void setVlera (int val) 
    {
        this.vlera = val;
    }

    public void hidh () 
    {
        this.vlera = new Random().nextInt(5) + 1;
    }
}

