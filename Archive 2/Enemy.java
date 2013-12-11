import java.awt.Rectangle;
import java.awt.Graphics;
import java.io.IOException;
/**
    * This abstract class defines general enemy behavior
    * @author Manav Dutta
    * @version 2.0
    */
public abstract class Enemy {
   protected Rectangle rectangle;
   protected int x;
   protected int y;
   protected InputPanel panel;
   protected int speed;
   protected int health;
   protected boolean underAttack;
   /**
    * This is the basic constructor used for enemies
    * @param x- the x location of the object
    * @param y- the y location of the object
    * @param r- the rectangle where the object is located
    */
   public Enemy(int x, int y, Rectangle r) {
       this.rectangle = r;
       this.x = x;
       this.y = y;
       this.panel = panel;
   }
   /**
    * This is the draw method for enemies.
    * All the enemy subclasses override it.
    * @param g- the graphics where the enemy is drawn
    */
   public abstract void draw(Graphics g) throws IOException;
   /**
    * This is a method to create a copy of an enemy object
    * @return the cloned enemy
    */
   public Enemy enemyClone() throws CloneNotSupportedException {
       return (Enemy) this.clone();
   }
   /**
    * This sets the enemy's speed
    * @param s- the enemy's speed
    */
   public void setSpeed(int s) {
        this.speed = s;
   }
   /**
    * This sets the enemy's health
    * @param h- the enemy's health
    */
   public void setHealth(int h) {
       this.health = h;
   }
}
