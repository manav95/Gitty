import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
* This defines the behavior of a GamerDude.
* GamerDudes are lazy, fat people who
* sit on the couch all day and play video games.
* Thats pretty much all they're good at.
* @author Manav Dutta
* @version 2.0
*/
public class GamerDude extends Enemy {
   /**
    * This constructs a GamerDude.
    * @param x- x location of the gamer dude
    * @param y- y location of the gamer dude
    * @param r- rectangle gamer dude is in
    */
   public GamerDude(int x, int y, Rectangle r) {
       super(x, y, r);
       setSpeed(5);
       setHealth(300);
   }
   /**
    * This draws a gamer dude.
    * @param g- the graphics of the gamer dude
    */
   public void draw(Graphics g) throws IOException {
        BufferedImage image = ImageIO.read(new File("gamer.png"));
        g.drawImage(image, this.x, this.y, 25, 25, this.panel);
   }
}
