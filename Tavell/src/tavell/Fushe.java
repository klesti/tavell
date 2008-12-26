/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Klesti H
 */
public class Fushe extends Canvas {
    public static final int WIDTH = 864;
    public static final int HEIGHT = 656;
    public SpriteCache sprites;
    private static final String background = "background.png";
    
    public Fushe() {
        sprites = new SpriteCache();
        setBounds(0,0,WIDTH,HEIGHT);
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(sprites.getSprite(background),0,0,this);
    }
      

}
