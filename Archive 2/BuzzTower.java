import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * This class defines the behavior of a buzz tower
 * Buzz Towers are awesome, but they are
 * also cheap. And they are our mascot.
 * @author: Manav Dutta
 * @version: 2.0
 */
public class BuzzTower extends Tower {
   /**
    * This constructs a nice buzz tower
    * The cost, range, damage, and spread are all defined here
    * @param x the x location of the tower
    * @param y the y location of the tower
    * @param r the rectangle where the tower is located
    */
   public BuzzTower(int x, int y, Rectangle r) {
       super(x, y, r);
       setMoney(50);
       setRange(40);
       setDamage(350);
       setSpread(3);
   }
   /**
    * This returns the cost of an arbitrary buzz tower
    * @return the cost which is 50
    */
   public static int getMoney() {
       return 50;
   }
   /**
    * This draws the buzz tower for all to see.
    * @param g the graphics context where this tower is
    */
   public void draw(Graphics g) throws IOException {
        BufferedImage image = ImageIO.read(new File("buzz.png"));
        g.drawImage(image, this.x, this.y, 35, 35, this.panel);
    }
}
