import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
* This class defines the behavior of a Simpkins Tower.
* The Simpkins Tower is wise and all-knowing. He
* does more damage than the Buzz Tower, but is more
* expensive too. He also imparts his programming wisdom
* to his CS 1331 students.
* @author Manav Dutta
* @version 2.0
*/
public class SimpkinsTower extends Tower {
  /**
    * This constructs a Simpkins Tower
    * @param x- the x location of the tower
    * @param y- the y location of the tower
    * @param r- the rectangle of the tower
    */
   public SimpkinsTower(int x, int y, Rectangle r) {
       super(x, y, r);
       setMoney(100);
       setRange(25);
       setDamage(200);
       setSpread(2);
   }
   /**
    * This returns the cost of the Simpkins Tower
    * @return 100- the cost of the Simpkins Tower
    */
   public static int getMoney() {
       return 100;
   }
   /**
    * This draws the Simpkins Tower
    * @param g- the graphics where the tower is located
    */
   public void draw(Graphics g) throws IOException {
        BufferedImage image = ImageIO.read(new File("simpkins.png"));
        g.drawImage(image, this.x, this.y, 35, 35, this.panel);
    }
}
