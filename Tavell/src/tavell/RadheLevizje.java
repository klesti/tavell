/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import javax.swing.JOptionPane;

/**
 *
 * @author Enkel
 */
public class RadheLevizje {
    
    private Lojtar lojtar;
    private CiftZaresh zaret;
    private int[] levizjetERradhes;
    private int zgjedhurPerTuLevizur;        
    private Loje loja;

    public RadheLevizje(Loje loja) {
        //konstruktor i perkoheshem
        this.levizjetERradhes = new int[4];
        this.zaret = new CiftZaresh(this);
        this.zgjedhurPerTuLevizur = -1;
        this.loja = loja;
    }

    public RadheLevizje(Lojtar lojtar, CiftZaresh zaret, int[] levzjetERradhes) {
        this.lojtar = lojtar;
        this.zaret = zaret;
        this.levizjetERradhes = levzjetERradhes;
    }

    public RadheLevizje(Lojtar lojtar) {
        this.lojtar = lojtar;
        this.levizjetERradhes = new int[4];
        this.zaret = new CiftZaresh(this);
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
    
    public int getZgjedhurPerTuLevizur() {
        return zgjedhurPerTuLevizur;
    }

    public void setZgjedhurPerTuLevizur(int z) {
        if (z!=-1 && (loja.getStivat()[z].size()<1 || 
            loja.getStivat()[z].peek().getLojtari()!=getLojtar())) {
            return;
        }
        this.zgjedhurPerTuLevizur = z;
    }
    
    public boolean kaPerTuLevizur() {
        return zgjedhurPerTuLevizur!=-1;
    }
        
    public void hidhZaret() {
        this.zaret.hidhZaret();
        int vlera1 = this.zaret.getZaret().get(0).getVlera();
        int vlera2 = this.zaret.getZaret().get(1).getVlera();
        if (zaret.eshteDopio()) {
                for (int i = 0; i <= 3; i++) {
                    this.levizjetERradhes[i] = vlera1;
                }
        }
        else {
            this.levizjetERradhes[0] = vlera1;
            this.levizjetERradhes[1] = vlera2;            
        }
    }
    
    public int shumaELevizjeTeMbetura() {
        int shuma = 0;
        for (int i = 0; i < this.levizjetERradhes.length; i++)
            shuma += this.levizjetERradhes[i];
        return shuma;
    }
    
    public int nrLevizjeTeMbetura() {
        for (int i = 0; i < this.levizjetERradhes.length; i++)
            if (this.levizjetERradhes[i] == 0)
                return i;
        return 4;
    }
    
    @SuppressWarnings("static-access")
    public boolean rregjistroLevizje(int vlera) {
        int nrLevMbet = this.nrLevizjeTeMbetura();
        if (this.zaret.eshteDopio()) {
            for (int i = 0; i < nrLevMbet-1; i++){
                this.levizjetERradhes[i] = this.levizjetERradhes[i+1];
            }
            this.levizjetERradhes[nrLevMbet-1] = 0;
            int mbetja = nrLevMbet % 4;
            if (mbetja == 3)
                this.zaret.getZaret().get(0).setULuajt(true);
            else if (mbetja == 1) {
                this.zaret.getZaret().get(1).setULuajt(true);
                if (this.loja instanceof Qyl)//nrLevMbet > 4)//rasti i qylit kur jane disa dopio
                    this.zaret.setZaret(vlera+1, vlera+1);//this.levizjetERradhes[0], this.levizjetERradhes[0]);                
            }
        }
        else {
            if (vlera == this.zaret.getZaret().get(0).getVlera())
                this.zaret.getZaret().get(0).setULuajt(true);
            else if (vlera == this.zaret.getZaret().get(1).getVlera())
                this.zaret.getZaret().get(1).setULuajt(true);
            if (vlera == this.levizjetERradhes[0]) {
                this.levizjetERradhes[0] = this.levizjetERradhes[1];
                this.levizjetERradhes[1] = 0;
            }
            else if (vlera == this.levizjetERradhes[1]) {
                this.levizjetERradhes[1] = 0;
            } else {
                return false;
            }
        }
        if (!loja.kaLevizjeTeLejuara()) {
            loja.ndryshoRradhe();
        }
        if (zaret.uLuajten()) {
            zaret.reset();
            loja.ndryshoRradhe();
        }   
        
        //Perfundimi i lojes
        if (lojtar.getNeLoje().size() < 1) {
            int pike = 1;
            if (lojtar.getNumri()==1) {
               if (loja.aKaGureJashteKuadratitTeFundit(loja.getLojtaret()[1])) 
                   pike++;
            } else {
                if (loja.aKaGureJashteKuadratitTeFundit(loja.getLojtaret()[1])) 
                   pike++;
            }
            lojtar.shtoPike(pike);
             if(lojtar.getPike()>=Program.loja.getPiket()) {
                JOptionPane.showMessageDialog(Program.fusha, "Loja u fitua nga "
                        +lojtar.getEmri()+"!","Loja Mbaroi!",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else {                        
                Program.fusha.listener.filloLojen();
                Program.loja.vendosGuret();
            }
        }
        return true;        
    }
    
    public boolean aEshteKryerLevizja(int levizja){
        if(zaret.eshteDopio()){
            return !(levizja==levizjetERradhes[0] || levizja==2*levizjetERradhes[0] ||
                    levizja==3*levizjetERradhes[0] || levizja==4*levizjetERradhes[0]);
        }
        else{
            return !(levizja==levizjetERradhes[0] || levizja==levizjetERradhes[1] ||
                    levizja==levizjetERradhes[0]+levizjetERradhes[1]);
        }
    }
    
}
