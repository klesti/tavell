package tavell;


public class Qyl extends Loje {

    public Qyl (Lojtar[] l, int p) {
        super(l,p);
        this.vendosGuret();
    }

    @Override
    public void vendosGuret () {
        super.vendosGuret();
        Gur g;
        Lojtar l1 = lojtaret[0];
        Lojtar l2 = lojtaret[1];
        
        //Krijo konfiguracionin per lojen qyl
        for (int i=0;i<15;i++) {
            g = l1.getNeLoje().get(i);
            stivat[24].push(g);
            g = l2.getNeLoje().get(i);
            stivat[12].push(g);
        }
    }
    
    public boolean leviz(int nga, int tek) {
        return false;
    }
}

