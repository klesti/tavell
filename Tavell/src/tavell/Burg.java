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

}

