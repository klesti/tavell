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

    public int[] getLevzjetERradhes() {
        return levizjetERradhes;
    }

    public void setLevzjetERradhes(int[] levzjetERradhes) {
        this.levizjetERradhes = levzjetERradhes;
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
                while (vlera1 <= 6){
                    for (int i = 0; i <= 3; i++){
                        this.levizjetERradhes[i] = vlera1;
                    }
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
    
    public int rregjistroLevizje(int vlera) {
        int nrLevizjeTeMbetura = 0;
        for (int i = 0; i < this.levizjetERradhes.length; i++)
            if (this.levizjetERradhes[i] == 0){
                nrLevizjeTeMbetura = i+1;
                break;
            }
        if (this.zaret.eshteDopio()) {
            int shuma = 0;
            for (int i = 0; i < nrLevizjeTeMbetura; i++) {
                shuma += this.levizjetERradhes[i];
                if (vlera == shuma){
                    for (int j = i; j < nrLevizjeTeMbetura; j++){
                        if (this.levizjetERradhes[i] == 0)
                            break;
                        this.levizjetERradhes[j-i] = this.levizjetERradhes[j+1];
                    }                        
                    for (int j = nrLevizjeTeMbetura - i; j < nrLevizjeTeMbetura; j++)
                        this.levizjetERradhes[j-1] = 0;
                    nrLevizjeTeMbetura = nrLevizjeTeMbetura - i - 1;
                    break;
                }
            }
        }
        else {
            if (vlera == this.levizjetERradhes[0]) {
                this.levizjetERradhes[0] = this.levizjetERradhes[1];
                this.levizjetERradhes[1] = 0;
                nrLevizjeTeMbetura = 1;
            }
            else if (vlera == this.levizjetERradhes[1]) {
                this.levizjetERradhes[1] = 0;
                nrLevizjeTeMbetura = 1;
            }
            else {
                this.levizjetERradhes[0] = 0;
                this.levizjetERradhes[1] = 0;
                nrLevizjeTeMbetura = 0;
            }
        }
        return nrLevizjeTeMbetura;            
    }

}
