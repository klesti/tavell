package tavell;

import java.util.*;

public class KoleksionLevizjesh extends Stack
{
    public KoleksionLevizjesh () 
    {
        
    }

    @Override public Levizje pop()
    {
        return (Levizje)super.pop();
    }
    
    @Override public Levizje get(int i)
    {
        return (Levizje)super.get(i);
    }
}