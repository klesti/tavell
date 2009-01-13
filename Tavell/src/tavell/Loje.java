package tavell;

abstract public class Loje {
    
    protected RadheLevizje radha;

    protected KoleksionGuresh[] stivat;

    protected KoleksionLevizjesh levizjet;
    
    protected Lojtar[] lojtaret;    
    
    private boolean kaFilluar;
    
    protected int piket;

    public Loje (Lojtar[] l, int p) {
        lojtaret = l;
        piket = p;
        kaFilluar = false;
        levizjet = new KoleksionLevizjesh(); 
        radha = new RadheLevizje(this); //---Do ndryshoje me vone
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
    
    public boolean kaFilluar() {
        return kaFilluar;
    }
    
    public void setKaFilluar(boolean kaFilluar) {
        this.kaFilluar = kaFilluar;
    }
    
    public abstract boolean leviz(int nga, int tek);
    
    
    public void ruaj () {
    }

    public void ngarko () {
    }
    
    public void vendosGuret () {
    }
    
    public void percaktoRradhenFillestare() {
        radha.hidhZaret();
        if (radha.getZaret().getVlera1() > radha.getZaret().getVlera2()) {
            radha.setLojtar(lojtaret[0]);
         } else if (radha.getZaret().getVlera2() > radha.getZaret().getVlera1()) {
            
            radha.setLojtar(lojtaret[1]);            
        }
    //radha hardcode
        //radha.setLojtar(lojtaret[0]);
    }

    
    public int ndryshoRradhe() {
        if (radha.getLojtar()==lojtaret[0]) {
            radha.setLojtar(lojtaret[1]);
            return 1;
        } else {
            radha.setLojtar(lojtaret[0]);
            return 0;
        }
    }
    
    public void fillo() {
        setKaFilluar(true);
        radha.setLojtar(null);
        radha.getZaret().reset();
        lojtaret[0].setPike(0);
        lojtaret[1].setPike(0);
        percaktoRradhenFillestare();
    }
    
    public int[] getLevizjetELejuara(KoleksionGuresh s){        
        int sa = radha.shumaELevizjeTeMbetura();
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
        //tek=getTek(tek);        
        if(!aPoLevizMbrapsht(nga, tek))
        {            
            int hapi = getHapi(nga, tek);
            int vlera1,vlera2;            
            if (radha.getZaret().eshteDopio()) {
                vlera1 = radha.getZaret().getVleraDopio();
                vlera2 = vlera1;
            } else {
                vlera1= radha.getZaret().getVlera1();
                vlera2= radha.getZaret().getVlera2();
            }

            if(aKaGureJashteKuadratitTeFundit(radha.getLojtar()) || !(tek>24 || tek<1)) {
                if(aTeLejojneZaret(hapi, vlera1, vlera2) &&
                    (aEshteBoshStiva(tek) || aKaNjeGurKundershtar(tek) || aJaneGureTeLojtarit(tek)) &&
                    !aKaPengesa(nga,tek)) 
                        return true;
                else return false;
            }
            else {        
                    //if(getStivat()[nga].size()>0 && !kaGureMajtas(getStivat()[nga].peek(),hapi)) tek=getFundiLevizjes(radha.getLojtar(), tek);
                //return (aTeLejojneZaret(hapi, vlera1, vlera2) && kaGureMajtas(getStivat()[nga].peek(), hapi));
                
                /*
                 * --RASTI KUR HA GURE
                 */
                  if(getStivat()[nga].size()<0) return false;
                    Gur g = getStivat()[nga].peek();
                //--Rasti kur nuk ka gure majtas
                if (getStivat()[nga].size()>0 && !kaGureMajtas(getStivat()[nga].peek(), hapi))  {                   
                   /* if (hapi!=vlera1 && hapi!=vlera2 && hapi!=vlera1+vlera2) {
                        if (vlera1>vlera2)
                            hapi = vlera1;
                        else 
                            hapi = vlera2;
                    }*/    
                    return(g.getPips()<=hapi);
                }
                //--Rasti kur ka gure majtas
                else {
                   
                    return (g.getPips()==hapi);
                }
           }
        }
        return false;
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
        if (pozicioni > 24 || pozicioni < 1) return true;
        return this.getStivat()[pozicioni].isEmpty();
    }
    
    protected  boolean aKaNjeGurKundershtar(int pozicioni){
        if(pozicioni>24 || pozicioni<1) return true;
        return (this.getStivat()[pozicioni].size()==1 && this.getStivat()[pozicioni].peek().getLojtari().getNumri() != radha.getLojtar().getNumri());
    }
    
    protected  boolean aJaneGureTeLojtarit(int pozicioni){
        if(pozicioni>24 || pozicioni<1) return true;
        return (this.getStivat()[pozicioni].peek().getLojtari().getNumri() == radha.getLojtar().getNumri());
    }
    
    protected boolean aKaPengesa (int nga, int tek){
        int drejtimi=radha.getLojtar().getDrejtimi();
        int hapi=Math.abs(tek-nga);        
        //--Mos bej kontroll nese nuk po luhet shuma e zareve
        if(hapi != radha.shumaELevizjeTeMbetura() || radha.getZaret().eshteLuajturNdonje()) return false;
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
    
    protected boolean kaGureMajtas(Gur g,int hapi){        
        if(radha.getLojtar().getNumri()==1) {
            //Kontroll nese hapi eshte fiks sa koordinata e stives tePefunduara
            //if(g.getPozicioni()==hapi) return false;
            for(int i=g.getPozicioni()+1;i<=24;i++) {
                if(getStivat()[i].size()>0)
                    if (getStivat()[i].peek().getLojtari().getNumri() == g.getLojtari().getNumri()) 
                        return true;
            }
            return false;
        }
        else {
            //Kontroll nese hapi eshte fiks sa koordinata e stives tePefunduara
            //if(hapi==25-g.getPozicioni()) return false;
            for(int i=1;i<g.getPozicioni();i++){
                if(getStivat()[i].size()>0)
                    if (getStivat()[i].peek().getLojtari().getNumri() == g.getLojtari().getNumri()) 
                        return true;
            }
            return false;
        }
    }
    
    protected int getHapi(int nga, int tek){        
        return Math.abs(getTek(tek)-nga);
    }
    
    //If i Cenit
    
    protected int getTek(int tek){
        int t;
        if(tek==25) t=0;
        else if(tek==26) t=25;
        else t = tek;
        return t;
    }
    
    protected boolean aPoLevizMbrapsht(int nga, int tek){
        tek = getTek(tek);
        if(radha.getLojtar().getNumri()==1 && nga < tek) return true;
        else if(radha.getLojtar().getNumri()==2 && nga > tek) return true;
        else return false;
    }
}

