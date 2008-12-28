package tavell;


public class Tavell extends Loje {

    public Tavell (Lojtar[] l) {
        super(l);
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

}

