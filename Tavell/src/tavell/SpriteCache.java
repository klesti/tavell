     package tavell;
    
    import java.awt.image.BufferedImage;
    import java.net.URL;
    import java.util.HashMap;
    
    import javax.imageio.ImageIO;
    
    public class SpriteCache {
      private HashMap sprites;
      
      public SpriteCache() {
        sprites = new HashMap();
      }
      
      private BufferedImage loadImage(String name) {
        URL url=null;
        try {
          url = getClass().getClassLoader().getResource(name);
          return ImageIO.read(url);
        } catch (Exception e) {
          System.out.println("Nuk ishte i mundur ngarkimi i imazhit " + name +" nga "+url);
          System.out.println("Gabimi : "+e.getClass().getName()+" "+e.getMessage());
          System.exit(0);
          return null;
        }
      }
      
      public BufferedImage getSprite(String name) {
        BufferedImage img = (BufferedImage)sprites.get(name);
        if (img == null) {
          img = loadImage("img/"+name);
          sprites.put(name,img);
        }
        return img;
      }
    }
