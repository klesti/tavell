/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import java.awt.Canvas;
import java.awt.Graphics;


/**
 *
 * @author Arbri
 */
public class AvatarImage extends Canvas{
    
    private SpriteCache sprites;
    private String fileName;
    
    public AvatarImage(String fileName) {
        sprites = new SpriteCache();
        this.fileName = fileName;
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(sprites.getSprite(this.fileName), 0, 0, 30,24,this);
    }
    
    public String getFileName() {
        return this.fileName;
    }    
}
