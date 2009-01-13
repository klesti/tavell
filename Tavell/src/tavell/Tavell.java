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
    public boolean leviz(int nga, int tek) {
        CiftZaresh zaret = radha.getZaret();
        if (aEshteEMundurLevizja(nga, tek)) {
            //Nqs ke gure te vrare dhe po tenton te levizesh nje gur tjeter nuk te lejon
            if (radha.getLojtar().kaJashteLoje() && nga!=0) {
                return false; 
            }
            Gur g = stivat[nga].peek();
            
            if (stivat[tek].size()==1 && stivat[tek].peek().getLojtari()!=g.getLojtari()) {
                g.vrit(stivat,tek);
            } else {
                g.leviz(stivat, tek);
            }
            //Regjistro levizje
            if (zaret.eshteDopio()) {                
                int vlera = zaret.getVleraDopio();
                int nrLevizjeve = getHapi(nga, tek)/vlera;
                for (int i=0; i< nrLevizjeve; i++) {
                    radha.rregjistroLevizje(vlera);                    
                }
            } else if (!zaret.eshteDopio() && zaret.getShuma()==getHapi(nga, tek)) {
                radha.rregjistroLevizje(zaret.getVlera1());
                radha.rregjistroLevizje(zaret.getVlera2());                
            } else {
                radha.rregjistroLevizje(getHapi(nga,tek));
            }
            levizjet.add(new Levizje(radha.getLojtar(),nga,tek));
            return true;
        }
        return false;
    }
    
}
