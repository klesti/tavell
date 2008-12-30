package tavell;

public class Lojtar {

    private String emri;
    private int numri;
    private int pike;
    private KoleksionGuresh neLoje;
    private KoleksionGuresh jashteLoje;
    private KoleksionGuresh tePerfunduar;

    public Lojtar (String emri,int numri) {
        neLoje = new KoleksionGuresh();
        jashteLoje = new KoleksionGuresh();
        tePerfunduar = new KoleksionGuresh();
        this.emri = emri;
        this.numri = numri;
        pike = 0;
        mbushNeLoje();
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
    
    public int getNumri() {
        return numri;
    }

    public void setNumri(int numri) {
        this.numri = numri;
    }
    
    
    public int getPike() {
        return pike;
    }

    public void setPike(int pike) {
        this.pike = pike;
    }

    public boolean kaJashteLoje () {
        return !jashteLoje.isEmpty();
    }
    
    public void mbushNeLoje() {
        for(int i=0;i<15;i++){
            Gur g = new Gur();
            g.setLojtari(this);
            neLoje.push(g);
        }    
    }
    
    public int getPips() {
        int pips=0;
        for(int i=0;i<neLoje.size();i++){
            if(this.numri==1)
                pips+=neLoje.get(i).getPozicioni();
            else if(this.numri==2)
                pips+=25-neLoje.get(i).getPozicioni();
        }
        for (int i=0;i<jashteLoje.size();i++){
            pips+=25;
        }
        return pips;
    }
    
    public int getDrejtimi(){
        if(this.numri==1) return -1;
        else return +1;
    }

}

