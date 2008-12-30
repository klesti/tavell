package tavell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Enkel
 */
public class Trekendesh 
{
    private Point pikaA;
    private Point pikaB;
    private Point pikaC;
    private static final int lartesia = 360;
    
    public Trekendesh(Point pikaA, Point pikaB, Point pikaC) 
    {
        this.pikaA = pikaA;
        this.pikaB = pikaB;
        this.pikaC = pikaC;
    }
    
    public Trekendesh() {
        pikaA = new Point();
        pikaB = new Point();
        pikaC = new Point();
    }
    
    public Point getPikaA() 
    {
        return pikaA;
    }

    public void setPikaA(Point pikaA) 
    {
        this.pikaA = pikaA;
    }

    public Point getPikaB() 
    {
        return pikaB;
    }

    public void setPikaB(Point pikaB) 
    {
        this.pikaB = pikaB;
    }

    public Point getPikaC() 
    {
        return pikaC;
    }

    public void setPikaC(Point pikaC) 
    {
        this.pikaC = pikaC;
    }

    
    public int getDrejtimi() {
        if (pikaA.y==23) 
            return 1;
        else 
            return -1;
    }
    
    public boolean neTrekendesh(Point P)
    {
        double b0 = ((this.pikaB.x - this.pikaA.x) * (this.pikaC.y - this.pikaA.y) - (this.pikaC.x - this.pikaA.x) * (this.pikaB.y - this.pikaA.y));
        double b1 = (((this.pikaB.x - P.x) * (this.pikaC.y - P.y) - (this.pikaC.x - P.x) * (this.pikaB.y - P.y)) / b0);
        double b2 = (((this.pikaC.x - P.x) * (this.pikaA.y - P.y) - (this.pikaA.x - P.x) * (this.pikaC.y - P.y)) / b0);
        double b3 = 1 - b1 - b2;

        if ((b1 > 0) && (b2 > 0) && (b3 > 0))
            return true;
        else
            return false;        
    }
    
    public void ngjyros(Graphics g,Color c) {
        Color oldColor = g.getColor();
        g.setColor(c);
        int start=0, stop=0;
        for (int i = pikaA.x; i < pikaB.x; i++) {  
            if (getDrejtimi()==1) {
                start = pikaA.y;
                stop = pikaA.y+260;
            } else {
                start = pikaA.y - 260;
                stop = pikaA.y;
            }
            for (int j = start; j < stop; j++) {
                Point pika = new Point(i,j);
                if (neTrekendesh(pika)) {
                    g.drawLine(i, j, i, j);
                }                
            }
        }
        g.setColor(oldColor);
    }
    
}
