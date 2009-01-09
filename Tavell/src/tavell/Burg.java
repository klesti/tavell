package tavell;


public class Burg extends Loje {

    public Burg (Lojtar[] l, int p) {
        super(l,p);
        this.vendosGuret();
    }

    @Override
    public void vendosGuret () {
        Gur g;
        Lojtar l1 = lojtaret[0];
        Lojtar l2 = lojtaret[1];
        
        //Krijo konfiguracionin per lojen burg
        for (int i=0;i<15;i++) {
            g = l1.getNeLoje().get(i);
            stivat[24].push(g);
            g = l2.getNeLoje().get(i);
            stivat[1].push(g);
        }
    }
    
   @Override
    public boolean leviz(int nga, int tek) {
        CiftZaresh zaret = radha.getZaret();        
        
        if (aEshteEMundurLevizja(nga, tek)) {
            Gur g = stivat[nga].peek();
            g.leviz(stivat, tek);
            //Regjistro levizje
            if (zaret.eshteDopio()) {
                int nrLevizjeve = Math.abs(tek-nga)/zaret.getVlera1();
                for (int i=0; i < nrLevizjeve; i++) {
                    radha.rregjistroLevizje(zaret.getVlera1());
                }
            } else if (!zaret.eshteDopio() && zaret.getShuma()==Math.abs(tek-nga)) {
                radha.rregjistroLevizje(zaret.getVlera1());
                radha.rregjistroLevizje(zaret.getVlera2());                
            } else {
                radha.rregjistroLevizje(Math.abs(tek-nga));
            }
            levizjet.add(new Levizje(radha.getLojtar(),nga,tek));
            return true;
        }
        return false;
    }

}

