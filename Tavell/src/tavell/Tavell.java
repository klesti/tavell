package tavell;


public class Tavell extends Loje {

    public Tavell (Lojtar[] l, int p) {
        super(l,p);
        this.vendosGuret();        
    }
    
    @Override
    public void vendosGuret () {
        KoleksionGuresh l1 = lojtaret[0].getNeLoje();
        KoleksionGuresh l2 = lojtaret[1].getNeLoje();
        Gur g;
        
               
        //Krijojme konfiguracionin fillestar per lojen tavell
        //---Dyshet --
        for (int i=0;i<2;i++) {
            g = l1.get(i);
            stivat[24].push(g);
            g = l2.get(i);
            stivat[1].push(g);
        }
     
        
        //--Treshet--
       for (int i=2;i<5;i++) {
            g = l1.get(i);
            stivat[8].push(g);
            g = l2.get(i);
            stivat[17].push(g);            
        }
        //--Peseshet -- 
       for (int i=5;i<10;i++) {
            g = l1.get(i);
            stivat[6].push(g);
            g = l2.get(i);
            stivat[19].push(g);      
       }
       for (int i=10;i<15;i++) {
            g = l1.get(i);
            stivat[13].push(g);
            g = l2.get(i);
            stivat[12].push(g);      
       }
       //--Fund Peseshet
    }
    
    @Override
    public int[] getLevizjetELejuara(KoleksionGuresh s){
        int sa = this.zaret.getZaret().get(0).getVlera() + this.zaret.getZaret().get(1).getVlera();
        int levizjetTmp[] = new int[5];
        int i=0;
        Gur g = s.peek();
        //--Lojtari i pare
        if(g.getLojtari().getNumri()==2){
            //--Rasti kur bie dopio. Levizjet kryhen njera pas tjetres.
            if(this.zaret.eshteDopio()){
                if(this.aMundTeShkojeTek(g,s.getPozicioni()+this.zaret.getZaret().get(0).getVlera())){
                    levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+this.zaret.getZaret().get(0).getVlera());
                    i++;
                    if(this.aMundTeShkojeTek(g,s.getPozicioni()+2*this.zaret.getZaret().get(1).getVlera())){
                        levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+2*this.zaret.getZaret().get(1).getVlera());
                        i++;
                        if(this.aMundTeShkojeTek(g,s.getPozicioni()+3*this.zaret.getZaret().get(1).getVlera())){
                            levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+3*this.zaret.getZaret().get(1).getVlera());
                            i++;
                            if(this.aMundTeShkojeTek(g,s.getPozicioni()+4*this.zaret.getZaret().get(1).getVlera())){
                                levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+4*this.zaret.getZaret().get(1).getVlera());
                                i++;
                            }
                        }
                    }
                }                
            }
            //--Rasti kur nuk bie dopio
            else {
                if(this.aMundTeShkojeTek(g,s.getPozicioni()+sa)){
                    levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+sa);
                    i++;
                }
                if(this.aMundTeShkojeTek(g,s.getPozicioni()+this.zaret.getZaret().get(0).getVlera())){
                    levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+this.zaret.getZaret().get(0).getVlera());
                    i++;
                }
                if(this.aMundTeShkojeTek(g,s.getPozicioni()+this.zaret.getZaret().get(1).getVlera())){
                    levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()+this.zaret.getZaret().get(1).getVlera());
                    i++;
                }
            }
        }
        //--Lojtari dyte
        else {
            //Rasti kur bie dopio. Levizjet kryhen njera pas tjetres
            if(this.zaret.eshteDopio()){
                if(this.aMundTeShkojeTek(g,s.getPozicioni()-this.zaret.getZaret().get(0).getVlera())){
                    levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()-this.zaret.getZaret().get(0).getVlera());
                    i++;
                    if(this.aMundTeShkojeTek(g,s.getPozicioni()-2*this.zaret.getZaret().get(1).getVlera())){
                        levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()-2*this.zaret.getZaret().get(1).getVlera());
                        i++;
                        if(this.aMundTeShkojeTek(g,s.getPozicioni()-3*this.zaret.getZaret().get(1).getVlera())){
                            levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()-3*this.zaret.getZaret().get(1).getVlera());
                            i++;
                            if(this.aMundTeShkojeTek(g,s.getPozicioni()-4*this.zaret.getZaret().get(1).getVlera())){
                                levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()-4*this.zaret.getZaret().get(1).getVlera());
                                i++;
                            }
                        }
                    }
                }                
            }
            //--Rasti kur nuk bie dopio
            else {
                if(this.aMundTeShkojeTek(g,s.getPozicioni()-sa)){
                    levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()-sa);
                    i++;
                }
                if(this.aMundTeShkojeTek(g,s.getPozicioni()-this.zaret.getZaret().get(0).getVlera())){
                    levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()-this.zaret.getZaret().get(0).getVlera());
                    i++;
                }
                if(this.aMundTeShkojeTek(g,s.getPozicioni()-this.zaret.getZaret().get(1).getVlera())){
                    levizjetTmp[i]=getFundiLevizjes(g.getLojtari(),s.getPozicioni()-this.zaret.getZaret().get(1).getVlera());
                    i++;
                }
            }
        }
        return levizjetTmp;
    }
    
    
    private boolean aMundTeShkojeTek(Gur g, int tek){
        tek = getFundiLevizjes(g.getLojtari(), tek);
        if(g.getLojtari().getNumri()==1 && tek==25 && this.getStivat()[g.getPozicioni()+1].size()==0 && !aKaGureJashteKuadratitTeFundit(g.getLojtari())) return true;
        else if(g.getLojtari().getNumri()==2 && tek==26 && this.getStivat()[g.getPozicioni()-1].size()==0 && !aKaGureJashteKuadratitTeFundit(g.getLojtari())) return true;
        else if(this.getStivat()[tek].size()<2){
            return true;
        }
        else if(this.getStivat()[tek].peek().getLojtari().getNumri() == g.getLojtari().getNumri())
            return true;
        else return false;
    }
    
    public boolean aEshteEMundurLevizja(int nga, int tek){
        int hapi = Math.abs(tek-nga);
        int vlera1= zaret.getZaret().get(0).getVlera();
        int vlera2= zaret.getZaret().get(1).getVlera();
        
        if(aTeLejojneZaret(hapi, vlera1, vlera2) && (aEshteBoshStiva(tek) || aKaNjeGurKundershtar(tek) || aJaneGureTeLojtarit(tek))) return true;
        else return false;
    }
    
    private boolean aKaGureJashteKuadratitTeFundit(Lojtar l){        
        if(l.getNumri()==1){
            for(int i=7;i<=24 && this.getStivat()[i].size()>0;i++){
                if(this.getStivat()[i].peek().getLojtari().getNumri()==l.getNumri()) return true;
            }
            return false;
        }
        else {
            for(int i=1;i<=18 && this.getStivat()[i].size()>0;i++){
                if(this.getStivat()[i].peek().getLojtari().getNumri()==l.getNumri()) return true;
            }
            return false;
        }
    }   
    
    private int getFundiLevizjes(Lojtar l, int sa) {
        if(l.getNumri()==1 && sa<1){
            return 25;            
        }
        else if(l.getNumri()==2 && sa >24) {
            return 26;            
        }
        else return sa;
    }
    
    private boolean aTeLejojneZaret(int hapi, int vlera1, int vlera2){
        if(zaret.eshteDopio() && hapi%vlera1==0 && hapi<=4*vlera1) return true;
        else if(!zaret.eshteDopio() && (hapi==vlera1 || hapi==vlera2 || hapi==vlera1+vlera2)) return true;
        else return false;
    }
    
    private boolean aEshteBoshStiva(int pozicioni){
        return this.getStivat()[pozicioni].isEmpty();
    }
    
    private boolean aKaNjeGurKundershtar(int pozicioni){
        return (this.getStivat()[pozicioni].size()==1 && this.getStivat()[pozicioni].peek().getLojtari().getNumri() != lojtariQePoLeviz.getNumri());
    }
    
    private boolean aJaneGureTeLojtarit(int pozicioni){
        return (this.getStivat()[pozicioni].peek().getLojtari().getNumri() == lojtariQePoLeviz.getNumri());
    }
}
