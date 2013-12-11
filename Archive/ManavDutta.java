import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
* This class defines the behavior of yours truly.
* Its going to be tough trying to kill the
* digital versions of me.
* @author Manav Dutta
* @version 2.0
*/
public class ManavDutta extends Enemy {
   /**
    * This constructs a digital copy of me.
    * They feel a lot like my own children.
    * @param x- the x location of my copy
    * @param y- the y location of my copy
    */
   public ManavDutta(int x, int y, Rectangle r) {
       super(x, y, r);
       setSpeed(25);
       setHealth(1400);
   }
   /**
    * This draws the copy of me.
    * I look pretty good don't you think.
    * @param g- the graphics where I am.
    */
   public void draw(Graphics g) throws IOException {
        BufferedImage image = ImageIO.read(new File("manavdutta.jpg"));
        g.drawImage(image, this.x, this.y, 25, 25, this.panel);
   }
}
