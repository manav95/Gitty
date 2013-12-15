import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * This class defines a Burdell Tower
 * Burdell Towers are the best type of tower.
 * They are also rare and expensive and mysterious.
 * @author Manav Dutta
 * @version 2.0
 */
public class BurdellTower extends Tower {
   /**
    * This constructs a Burdell Tower
    * @param x- the x location of the tower
    * @param y- the y location of the tower
    * @param r- the rectangle where the tower is located
    */
   public BurdellTower(int x, int y, Rectangle r) {
       super(x, y, r);
       setMoney(300);
       setRange(40);
       setDamage(350);
       setSpread(3);
   }
   /**
    * This returns the cost of the Burdell tower
    * @return 300- the cost of the tower
    */
   public static int getMoney() {
       return 300;
   }
   /**
    * This draws the Burdell Tower.
    * But this isn't the actual picture
    * No one knows what a true Burdell Tower
    * looks like.
    * @param g- the graphics where the tower is in
    */
   public void draw(Graphics g) throws IOException {
        BufferedImage image = ImageIO.read(new File("burdell.png"));
        g.drawImage(image, this.x, this.y, 35, 35, this.panel);
    }
}
