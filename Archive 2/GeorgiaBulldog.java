import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
* This class defines the behavior of a GeorgiaBulldog.
* This is the mascot of UGA, and it is fairly powerful.
* Unlike the Georgia Fan, the Bulldog is a formidable
* enemy that is durable and fast.
* @author Manav Dutta
* @version 2.0
*/
public class GeorgiaBulldog extends Enemy {
    /**
    * This constructs a Bulldog.
    * @param x- x location of the bulldog
    * @param y- y location of the bulldog
    * @param r- rectange where bulldog is
    */
   public GeorgiaBulldog(int x, int y, Rectangle r) {
       super(x, y, r);
       setSpeed(12);
       setHealth(800);
   }
   /**
   * This draws a bulldog
   * @param g- graphics where the bulldog is located
   */
   public void draw(Graphics g) throws IOException {
        BufferedImage image = ImageIO.read(new File("58721.jpg"));
        g.drawImage(image, this.x, this.y, 25, 25, this.panel);
   }
}
