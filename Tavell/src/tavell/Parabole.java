/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import java.awt.Point;

/**
 *
 * @author Klesti
 */
public class Parabole {
    private Point p0;
    private Point p1;
    private Point p2;
    private Gur g1,g2;
    private int a,b,c;
    
    public Parabole(Point p0,Point p1,Point p2)  {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;        
    }
    
    public Parabole(Gur g1,Gur g2) {
        this.g1 = g1;
        this.g2 = g2;
        llogaritPika();
    }
    
    public void llogaritPika() {
        
    }
    
    public int interpolo(int x) {
        double p0x = (double) ((x-p1.x)*(x-p2.x)) / (double) ((p0.x-p1.x)*(p0.x-p2.x));
        double p1x = (double) ((x-p0.x)*(x-p2.x)) / (double) ((p1.x-p0.x)*(p1.x-p2.x));
        double p2x = (double) ((x-p0.x)*(x-p1.x)) / (double) ((p2.x-p0.x)*(p2.x-p1.x));
        
        return (int)(p0.y*p0x + p1.y*p1x + p2.y*p2x);        
    }
}
