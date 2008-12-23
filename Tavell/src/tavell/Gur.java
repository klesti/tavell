package tavell;

import java.awt.Point;

public class Gur {

    private Point koordinata;

    private int pozicioni;

    private boolean iKapur;

    public Gur () {
    }

    public boolean getIKapur () {
        return iKapur;
    }

    public void setIKapur (boolean val) {
        this.iKapur = val;
    }

    public Point getKoordinata () {
        return koordinata;
    }

    public void setKoordinata (Point val) {
        this.koordinata = val;
    }

    public int getPozicioni () {
        return pozicioni;
    }

    public void setPozicioni (int val) {
        this.pozicioni = val;
    }

}

