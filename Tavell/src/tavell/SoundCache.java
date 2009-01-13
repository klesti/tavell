/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tavell;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;

public class SoundCache {
    protected HashMap resources;
      
    public SoundCache() {
        resources = new HashMap();
    }
      
    protected Object loadResource(String name) {
        URL url=null;
        url = getClass().getClassLoader().getResource(name);
        return loadResource(url);
      }
      
    protected Object getResource(String name) {
        Object res = resources.get(name);
        if (res == null) {
          res = loadResource("snd/"+name);
          resources.put(name,res);
        }
        return res;
      }
      
    protected Object loadResource(URL url) {
        return Applet.newAudioClip(url);
        
    }
    
    public AudioClip getAudioClip(String name) {
        return (AudioClip)getResource(name);  
    }
      
    public void playSound(final String name) {
       getAudioClip(name).play();
    }
      
    public void loopSound(final String name) {
        getAudioClip(name).loop();
    }

}
