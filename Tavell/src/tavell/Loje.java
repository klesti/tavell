package tavell;

abstract public class Loje {
    
    protected RadheLevizje radha;

    protected KoleksionGuresh[] stivat;

    protected KoleksionLevizjesh levizjet;
    
    protected Lojtar[] lojtaret;    
    
    
    protected int piket;

    public Loje (Lojtar[] l, int p) {
        lojtaret = l;
        piket = p;        
        levizjet = new KoleksionLevizjesh(); 
        radha = new RadheLevizje(lojtaret[0]); //---Do ndryshoje me vone
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
    
    public RadheLevizje getRadha() {
        return radha;
    }

    public void setRadha(RadheLevizje radha) {
        this.radha = radha;
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
    
    public abstract boolean leviz(int nga, int tek);
    
    public void percaktoRadhen()
    {
        //ketu do jene disa rreshta qe bejne hedhjen e nga nje zari per secilin lojtar
        //dhe keshtu percaktojne se kush e ka radhen
        //dhe krijohet radha
        radha = new RadheLevizje(/*ketu do jete lojtari qe ka radhen*/);
        //radha.populloLevizjetERradhes(this);
    }
    
    public void ruaj () {
    }

    public void ngarko () {
    }
    
    public void vendosGuret () {
    }
    
    public int[] getLevizjetELejuara(KoleksionGuresh s){        
        int sa = radha.getZaret().getShuma();
        int levizjetTmp[] = new int[5];
        int i=0;
        //Kontrollo a ka gure stiva
        if(s.size() >0) {
            Gur g = s.peek();        
            //--Kontrollo a e ka rradhen lojtari me gurin qe eshte klikuar
            if(radha.getLojtar()==g.getLojtari()) {                                
                //--Rasti kur bie dopio. Levizjet kryhen njera pas tjetres.                    
                if(radha.getZaret().eshteDopio()){
                    for(int j=1;j<=radha.nrLevizjeTeMbetura();j++){
                        //Nese pozicioni perfundimtar e kalon kufirin e lejueshem nderpritet cikli
                        /*if((s.getPozicioni()+j*radha.getLojtar().getDrejtimi()*radha.getZaret().getVleraDopio() > 24 ||
                           s.getPozicioni()+j*radha.getLojtar().getDrejtimi()*radha.getZaret().getVleraDopio() < 0) && aKaGureJashteKuadratitTeFundit(radha.getLojtar())) break;*/
                        if(aEshteEMundurLevizja(s.getPozicioni(),s.getPozicioni()+j*radha.getLojtar().getDrejtimi()*radha.getZaret().getVleraDopio())){
                            levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+j*radha.getLojtar().getDrejtimi()*radha.getZaret().getVleraDopio());
                            i++;
                        }
                        else break;
                    }
                }
                //--Rasti kur nuk bie dopio
                else {
                    for(int j=0;j<radha.nrLevizjeTeMbetura();j++){
                        //Nese pozicioni perfundimtar e kalon kufirin e lejueshem nderpritet cikli
                        /*if((s.getPozicioni()+radha.getLojtar().getDrejtimi()*radha.getLevizjetERradhes()[j] > 24 ||
                           s.getPozicioni()+radha.getLojtar().getDrejtimi()*radha.getLevizjetERradhes()[j] < 0) && aKaGureJashteKuadratitTeFundit(radha.getLojtar())) break;*/
                        if(aEshteEMundurLevizja(s.getPozicioni(), s.getPozicioni()+radha.getLojtar().getDrejtimi()*radha.getLevizjetERradhes()[j])) {
                            levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+radha.getLojtar().getDrejtimi()*radha.getLevizjetERradhes()[j]);
                            i++;
                        }
                    }
                    //Kontrollo per levizjen shume e dy zareve
                    /*if(((s.getPozicioni()+radha.getLojtar().getDrejtimi()*sa > 24 ||
                           s.getPozicioni()+radha.getLojtar().getDrejtimi()*sa < 0) && aKaGureJashteKuadratitTeFundit(radha.getLojtar()))) {  
                           System.out.println("u fut");
                    }*/
                    if(aEshteEMundurLevizja(s.getPozicioni(), s.getPozicioni()+radha.getLojtar().getDrejtimi()*sa)){
                            levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+radha.getLojtar().getDrejtimi()*sa);
                            i++;
                    }
                }
            }
        }
        return levizjetTmp;
    }
    
    
    public boolean aEshteEMundurLevizja(int nga, int tek){
        if((tek>24 || tek<1) && (aKaGureJashteKuadratitTeFundit(radha.getLojtar()) || kaGureMajtas(getStivat()[nga].peek()))) return false;
        else if(radha.getLojtar().getNumri()==1 && nga < tek) return false;
        else if(radha.getLojtar().getNumri()==2 && nga > tek) return false;
        else {            
            int hapi = Math.abs(tek-nga);
            int vlera1,vlera2;            
            if (radha.getZaret().eshteDopio()) {
                vlera1 = radha.getZaret().getVleraDopio();
                vlera2 = vlera1;
            } else {
                vlera1= radha.getZaret().getVlera1();
                vlera2= radha.getZaret().getVlera2();
            }

            if(aTeLejojneZaret(hapi, vlera1, vlera2) && (aEshteBoshStiva(tek) || aKaNjeGurKundershtar(tek) || aJaneGureTeLojtarit(tek)) && !aKaPengesa(nga,tek)) return true;
            else return false;
        }
    }
    
    protected  boolean aKaGureJashteKuadratitTeFundit(Lojtar l){        
        if(l.getNumri()==1){
            for(int i=7;i<=24;i++){
                if(this.getStivat()[i].size()>0) 
                    if(this.getStivat()[i].peek().getLojtari()==l) {                        
                        return true;
                    }
            }
            return false;
        }
        else {
            for(int i=1;i<=18;i++){
                if(this.getStivat()[i].size()>0)
                    if(this.getStivat()[i].peek().getLojtari()==l) {                        
                        return true;
                    }
            }
            return false;
        }
    }
    
    protected  int getFundiLevizjes(Lojtar l, int sa) {
        if(l.getNumri()==1 && sa<1){
            return 25;            
        }
        else if(l.getNumri()==2 && sa >24) {
            return 26;            
        }
        else return sa;
    }
    
    protected  boolean aTeLejojneZaret(int hapi, int vlera1, int vlera2){
        if(vlera1==0&&vlera2==0) return false;
        if(radha.getZaret().eshteDopio() && hapi%radha.getZaret().getVleraDopio()==0 && hapi<=4*vlera1) return true;
        else if(!radha.getZaret().eshteDopio() && (hapi==vlera1 || hapi==vlera2 || hapi==vlera1+vlera2)) return true;
        else return false;
    }
    
    protected  boolean aEshteBoshStiva(int pozicioni){
        if(pozicioni>24 || pozicioni<1) return false;
        else return this.getStivat()[pozicioni].isEmpty();
    }
    
    protected  boolean aKaNjeGurKundershtar(int pozicioni){
        if(pozicioni>24 || pozicioni<1) return false;
        else return (this.getStivat()[pozicioni].size()==1 && this.getStivat()[pozicioni].peek().getLojtari().getNumri() != radha.getLojtar().getNumri());
    }
    
    protected  boolean aJaneGureTeLojtarit(int pozicioni){
        if(pozicioni>24 || pozicioni<1) return false;
        else return (this.getStivat()[pozicioni].peek().getLojtari().getNumri() == radha.getLojtar().getNumri());
    }
    
    protected boolean aKaPengesa (int nga, int tek){
        int drejtimi=radha.getLojtar().getDrejtimi();
        int hapi=Math.abs(tek-nga);        
        //--Mos bej kontroll nese nuk po luhet shuma e zareve
        if(hapi != radha.getZaret().getShuma() || radha.getZaret().eshteLuajturNdonje()) return false;
        if(!(aEshteBoshStiva(nga+drejtimi*radha.getZaret().getVlera1()) ||
           aKaNjeGurKundershtar(nga+drejtimi*radha.getZaret().getVlera1()) ||
           aJaneGureTeLojtarit(nga+drejtimi*radha.getZaret().getVlera1())) && 
           !(aEshteBoshStiva(nga+drejtimi*radha.getZaret().getVlera2()) ||
           aKaNjeGurKundershtar(nga+drejtimi*radha.getZaret().getVlera2()) ||
           aJaneGureTeLojtarit(nga+drejtimi*radha.getZaret().getVlera2()))) {           
           return true;
        }
        else
            return false;
    }
    
    protected boolean kaGureMajtas(Gur g){        
        if(radha.getLojtar().getNumri()==1) {
            for(int i=g.getPozicioni()+1;i<=24;i++) {
                if(getStivat()[i].size()>0)
                    if (getStivat()[i].peek().getLojtari().getNumri() == g.getLojtari().getNumri()) return true;
            }
            return false;
        }
        else {
            for(int i=1;i<g.getPozicioni();i++){
                if(getStivat()[i].size()>0)
                    if (getStivat()[i].peek().getLojtari().getNumri() == g.getLojtari().getNumri()) return true;
            }
            return false;
        }
    }
}

