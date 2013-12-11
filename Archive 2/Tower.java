import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
/**
    * This abstract class defines general tower behavior
    * @author Manav Dutta
    * @version 2.0
    */
public abstract class Tower {
   protected Rectangle rectangle;
   protected int x;
   protected int y;
   protected InputPanel panel;
   protected int money;
   protected int range;
   protected int damage;
   protected int spread;
   /**
    * This is the basic constructor for a Tower object.
    * @param x- the x location of the Tower
    * @param y- the y location of the Tower
    * @param r- the rectangle where the Tower is in
    */
   public Tower(int x, int y, Rectangle r) {
       this.rectangle = r;
       this.x = x;
       this.y = y;
       this.panel = panel;
   }
   /**
    * This is the draw method for a Tower.
    * All Tower subclasses override this method.
    * @param g- the graphics where the Tower is drawn
    */
   public abstract void draw(Graphics g) throws IOException;
   /**
    * This sets the cost of the tower.
    * @param m- the cost
    */
   public void setMoney(int m) {
       this.money = m;
   }
   /**
    * This sets the range of the tower.
    * @param r- the range of the tower.
    */
   public void setRange(int r) {
       this.range = r;
   }
   /**
    * This sets the damage of the tower.
    * @param d- the damage of the tower.
    */
   public void setDamage(int d) {
       this.damage = d;
   }
   /**
    * This sets the spread of the tower.
    * @param s- the spread of the tower
    */
   public void setSpread(int s) {
       this.spread = s;
   }
}
