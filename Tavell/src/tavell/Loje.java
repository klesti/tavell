package tavell;

abstract public class Loje {

    protected CiftZaresh zaret;

    protected KoleksionGuresh[] stivat;

    protected KoleksionLevizjesh levizjet;
    
    protected Lojtar[] lojtaret;
    
    protected int piket;

    public Loje (Lojtar[] l, int p) {
        lojtaret = l;
        piket = p;
        zaret = new CiftZaresh();
        levizjet = new KoleksionLevizjesh();        
        /*
          Stivat[0] jane guret jashte loje, Stivat[1..24] jane guret ne loje, 
          Stivat[25..26] jane guret e perfunduar
         */
        stivat = new KoleksionGuresh[27]; 
        //Inicializo Stivat
        stivat[0] = new KoleksionGureshJashteLoje(0);
        for (int i=1;i<=24;i++) {
            stivat[i] = new KoleksionGuresh(i);
        }
        stivat[25] = new KoleksionGureshTePerfunduar(25,this, lojtaret[0]);
        stivat[26] = new KoleksionGureshTePerfunduar(26,this, lojtaret[1]);
        //Fund inicializimi
        
    }
    
    public KoleksionLevizjesh getLevizjet () {
        return levizjet;
    }

    public void setLevizjet (KoleksionLevizjesh val) {
        this.levizjet = val;
    }

    public KoleksionGuresh[] getStivat () {
        return stivat;
    }

    public void setStivat (KoleksionGuresh[] val) {
        this.stivat = val;
    }

    public CiftZaresh getZaret () {
        return zaret;
    }

    public void setZaret (CiftZaresh val) {
        this.zaret = val;
    }
    
    public Lojtar[] getLojtaret() {
        return lojtaret;
    }

    public void setLojtaret(Lojtar[] lojtaret) {
        this.lojtaret = lojtaret;
    }
    
    public int getPiket() {
        return this.piket;
    }
    
    public void setPiket(int p){
        this.piket = p;
    }
    
    public void ruaj () {
    }

    public void ngarko () {
    }
    
    public void vendosGuret () {
    }
}

