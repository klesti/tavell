package tavell;

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

    public Trekendesh(Point pikaA, Point pikaB, Point pikaC) 
    {
        this.pikaA = pikaA;
        this.pikaB = pikaB;
        this.pikaC = pikaC;
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
}
