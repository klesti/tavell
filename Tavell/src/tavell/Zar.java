package tavell;

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
        this.vlera = (int)(Math.random() * 5 + 1);
    }
}

