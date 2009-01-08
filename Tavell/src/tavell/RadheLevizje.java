/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

/**
 *
 * @author Enkel
 */
public class RadheLevizje {
    
    private Lojtar lojtar;
    private CiftZaresh zaret;
    private int[] levizjetERradhes;

    public RadheLevizje() {
        //konstruktor i perkoheshem
        this.levizjetERradhes = new int[24];
    }

    public RadheLevizje(Lojtar lojtar, CiftZaresh zaret, int[] levzjetERradhes) {
        this.lojtar = lojtar;
        this.zaret = zaret;
        this.levizjetERradhes = levzjetERradhes;
    }

    public RadheLevizje(Lojtar lojtar) {
        this.lojtar = lojtar;
        this.levizjetERradhes = new int[24];
    }

    public int[] getLevizjetERradhes() {
        return levizjetERradhes;
    }

    public void setLevizjetERradhes(int[] levizjetERradhes) {
        this.levizjetERradhes = levizjetERradhes;
    }

    public Lojtar getLojtar() {
        return lojtar;
    }

    public void setLojtar(Lojtar lojtar) {
        this.lojtar = lojtar;
    }

    public CiftZaresh getZaret() {
        return zaret;
    }

    public void setZaret(CiftZaresh zaret) {
        this.zaret = zaret;
    }
    
    public void populloLevizjetERradhes(Loje l) {
        this.zaret.hidhZaret();
        int vlera1 = this.zaret.getZaret().get(0).getVlera();
        int vlera2 = this.zaret.getZaret().get(1).getVlera();
        if (zaret.eshteDopio()) {
            if (l instanceof Qyl) {
                int nrDopiosh = 0;
                while (vlera1 <= 6){
                    for (int i = nrDopiosh; i <= nrDopiosh+3; i++){
                        this.levizjetERradhes[i] = vlera1;
                    }
                    nrDopiosh += 4;
                    vlera1++;
                }
            }
            else {
                for (int i = 0; i <= 3; i++) {
                    this.levizjetERradhes[i] = vlera1;
                }
            }
        }
        else {
            this.levizjetERradhes[0] = vlera1;
            this.levizjetERradhes[1] = vlera2;
        }
    }
    
    public int nrLevizjeTeMbetura() {
        for (int i = 0; i < this.levizjetERradhes.length; i++)
            if (this.levizjetERradhes[i] == 0)
                return i+1;
        return 0;
    }
    
    public void rregjistroLevizje(int vlera) {
        int nrLevMbet = this.nrLevizjeTeMbetura();
        if (this.zaret.eshteDopio()) {
            for (int i = 0; i < nrLevMbet-1; i++){
                this.levizjetERradhes[i] = this.levizjetERradhes[i+1];
            }
            int mbetja = nrLevMbet % 4;
            if (mbetja == 3)
                this.zaret.getZaret().get(0).setULuajt(true);
            else if (mbetja == 1) {
                this.zaret.getZaret().get(1).setULuajt(true);
                if (nrLevMbet > 4)//rasti i qylit kur jane disa dopio
                    this.zaret.setZaret(this.levizjetERradhes[0], this.levizjetERradhes[0]);                
            }
        }
        else {
            
//        
//            if (vlera == this.zaret.getZaret().get(0).getVlera())
//                this.zaret.getZaret().get(0).setULuajt(true);
//            else if (vlera == this.zaret.getZaret().get(1).getVlera())
//                this.zaret.getZaret().get(1).setULuajt(true);
//            if (vlera == this.levizjetERradhes[0]) {
//                this.levizjetERradhes[0] = this.levizjetERradhes[1];
//                this.levizjetERradhes[1] = 0;                
//            }
//            else if (vlera == this.levizjetERradhes[1]) {
//                this.levizjetERradhes[1] = 0;
//            }
//            else {
//                this.levizjetERradhes[0] = 0;
//                this.levizjetERradhes[1] = 0;
//                this.zaret.getZaret().get(0).setULuajt(true);
//                this.zaret.getZaret().get(1).setULuajt(true);
//            }
        }           
    }

}
