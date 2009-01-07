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
    private int[] levzjetERradhes;

    public RadheLevizje() {
        //konstruktor i perkoheshem
        this.levzjetERradhes = new int[24];
    }

    public RadheLevizje(Lojtar lojtar, CiftZaresh zaret, int[] levzjetERradhes) {
        this.lojtar = lojtar;
        this.zaret = zaret;
        this.levzjetERradhes = levzjetERradhes;
    }

    public RadheLevizje(Lojtar lojtar) {
        this.lojtar = lojtar;
        this.levzjetERradhes = new int[24];
    }

    public int[] getLevzjetERradhes() {
        return levzjetERradhes;
    }

    public void setLevzjetERradhes(int[] levzjetERradhes) {
        this.levzjetERradhes = levzjetERradhes;
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
                        this.levzjetERradhes[i] = vlera1;
                    }
                    vlera1++;
                }
            }
            else {
                for (int i = 0; i <= 3; i++) {
                    this.levzjetERradhes[i] = vlera1;
                }
            }
        }
        else {
            this.levzjetERradhes[0] = vlera1;
            this.levzjetERradhes[1] = vlera2;
        }
    }
    
    /*public void rregjistroLevizje(int vlera) {
    if (vlera == this.levzjetERradhes[0]) {
    for (int j = 1; j < this.levzjetERradhes.length; j++)
    this.levzjetERradhes[j-1] = this.levzjetERradhes[j];
    this.levzjetERradhes[23] = 0;
    }
    for (int i = 0; i < this.levzjetERradhes.length; i++) {
    if (this.levzjetERradhes[i] == 0)
    break;
    
    }
    }*/

}
