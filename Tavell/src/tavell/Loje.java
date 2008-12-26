package tavell;

abstract public class Loje {

    protected CiftZaresh zaret;

    protected KoleksionGuresh[] stivat;

    protected KoleksionLevizjesh levizjet;
    
    protected Lojtar[] lojtaret;

    public Loje (Lojtar[] l) {
        /*
          Stivat[0] jane guret jashte loje, Stivat[1..24] jane guret ne loje, 
          Stivat[25..26] jane guret e perfunduar
         */
        stivat = new KoleksionGuresh[27]; 
        //Inicializo Stivat
        for (int i=0;i<27;i++) {
            stivat[i] = new KoleksionGuresh(i);
        }
        //Fund inicializimi
        lojtaret = l;
        zaret = new CiftZaresh();
        levizjet = new KoleksionLevizjesh();
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
    
    public void ruaj () {
    }

    public void ngarko () {
    }
    
    public void vendosGuret () {
    }
}

