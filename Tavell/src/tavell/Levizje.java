package tavell;

public class Levizje 
{
    private Lojtar lojtari;
    private int nga;
    private int tek;

    public Levizje () 
    {
        
    }
    
    public Levizje (Lojtar l, int nga, int tek)
    {
        this.lojtari = l;
        this.nga = nga;
        this.tek = tek;
    }

    public Lojtar getLojtari () 
    {
        return lojtari;
    }

    public void setLojtari (Lojtar val) 
    {
        this.lojtari = val;
    }

    public int getNga () 
    {
        return nga;
    }

    public void setNga (int val) 
    {
        this.nga = val;
    }

    public int getTek () 
    {
        return tek;
    }

    public void setTek (int val) 
    {
        this.tek = val;
    }

    @Override public String toString()
    {//???duhet shtuar nje logjike qe sheh nese guri eshte ne "pozicionin" i ngrene(jashte loje) ose
     //ne "pozicionin" i perfunduar dhe per secilin rast te kthehet nje String tjeter???
        return this.lojtari.getEmri() +"levizi gurin nga "+ this.nga +"tek "+this.tek+"\n";
    }
}

