import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
* This class defines the behavior of a GeorgiaFan.
* Georgia Fans tend to be obnoxious and really loud.
* They are also very annoying. Luckily, they don't
* have that much health and speed.
* @author Manav Dutta
* @version 2.0
*/
public class GeorgiaFan extends Enemy {
   /**
    * This constructs a Georgia Fan.
    * @param x- the x location of the Georgia Fan
    * @param y- the y location of the Georgia Fan
    * @param r- the rectangle where the Fan is in
    */
   public GeorgiaFan(int x, int y, Rectangle r) {
       super(x, y, r);
       setSpeed(10);
       setHealth(150);
   }
   /**
    * This draws a Georgia fan.
    * @param g- the graphics where the Georgia fan
    * is located.
    */
   public void draw(Graphics g) throws IOException {
        BufferedImage image = ImageIO.read(new File("ugafatguy.jpg"));
        g.drawImage(image, this.x, this.y, 25, 25, this.panel);
    }
}
