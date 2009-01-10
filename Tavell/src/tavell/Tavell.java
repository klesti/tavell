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
        if (!radha.getLojtar().kaJashteLoje() && aEshteEMundurLevizja(nga, tek)) {
            Gur g = stivat[nga].peek();
            g.leviz(stivat, tek);
            //Regjistro levizje
            if (zaret.eshteDopio()) {
                int vlera = zaret.getVleraDopio();
                int nrLevizjeve = Math.abs(tek-nga)/vlera;
                for (int i=0; i< nrLevizjeve; i++) {
                    radha.rregjistroLevizje(vlera);
                }
            } else if (!zaret.eshteDopio() && zaret.getShuma()==Math.abs(tek-nga)) {
                radha.rregjistroLevizje(zaret.getVlera1());
                radha.rregjistroLevizje(zaret.getVlera2());                
            } else {
                radha.rregjistroLevizje(Math.abs(nga-tek));
            }
            levizjet.add(new Levizje(radha.getLojtar(),nga,tek));
             return true;
        }
        return false;
    }
    
}
