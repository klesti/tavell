package tavell;

public class Lojtar {

    private String emri;
    private KoleksionGuresh neLoje;
    private KoleksionGuresh jashteLoje;
    private KoleksionGuresh tePerfunduar;

    public Lojtar () {
    }

    public String getEmri () {
        return emri;
    }

    public void setEmri (String val) {
        this.emri = val;
    }

    public KoleksionGuresh getJashteLoje () {
        return jashteLoje;
    }

    public void setJashteLoje (KoleksionGuresh val) {
        this.jashteLoje = val;
    }

    public KoleksionGuresh getNeLoje () {
        return neLoje;
    }

    public void setNeLoje (KoleksionGuresh val) {
        this.neLoje = val;
    }

    public KoleksionGuresh getTePerfunduar () {
        return tePerfunduar;
    }

    public void setTePerfunduar (KoleksionGuresh val) {
        this.tePerfunduar = val;
    }

    public boolean kaJashteLoje () {
        return !jashteLoje.isEmpty();
    }
    
    public void mbushNeLoje() {
        for(int i=0;i<15;i++){
            Gur g = new Gur();
            neLoje.push(g);
        }    
    }
    
    

}

