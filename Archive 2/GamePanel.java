import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Point;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.util.Random;
import java.lang.reflect.Method;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
    * This abstract class defines the game panel.
    * This is where all the action takes place.
    * Towers and enemies are shown here.
    * @author Manav Dutta
    * @version 2.0
    */
public class GamePanel extends JPanel {
    public static final int WIDTH = 600, HEIGHT = 600;
    protected ArrayList<Tower> towers = new ArrayList<Tower>();
    private InputPanel cPanel;
    private Timer timer;
    private Rectangle bounds;
    /**
    * This constructs the game panel.
    * @param panel- the input panel this game panel is using
    */
    public GamePanel(InputPanel panel) {
        cPanel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        bounds = new Rectangle(0, 0, WIDTH, HEIGHT);
        addMouseListener(new ClickListener());
        this.timer = panel.timer;
        timer.addActionListener(new WaveListener());
    }
    /**
    * This returns the input panel of this game panel
    * @return the input panel
    */
    public InputPanel getInputPanel() {
        return this.cPanel;
    }
    /**
    * This draws the path the enemies follow.
    * @param g- the graphics the path is in
    */
    public void drawPath(Graphics g) {
        g.drawLine(0, 300, 600, 300);
    }
    /**
    * This paints the panel and the towers.
    * @param g- the graphics of the panel
    */
    public void paintComponent(Graphics g) {
    try {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        for (Tower a : towers) {
            a.draw(g);
        }
        drawPath(g);
    }
    catch (IOException e) {
        System.out.println(e.getClass());
       }
    }
    /**
    * This generates the next enemy in the wave.
    * 10 enemies can be generated during one round
    * of the game. The difficulty is used
    * during the random generation of the enemy.
    * @param difficulty- used in the enemy generation process
    * @return the enemy generated
    */
    public Enemy generateEnemy(int difficulty) {
          Random random = new Random();
          int randnext = random.nextInt(difficulty);
          if (randnext <= 1) {
             return new GeorgiaFan(0, 300, bounds);
          }
          else if (randnext <= 4) {
              return new GamerDude(0, 300, bounds);
          }
          else if (randnext <= 6)  {
              return new GeorgiaBulldog(0, 300, bounds);
          }
          else {
              return new ManavDutta(0, 300, bounds);
          }
    }
    /**
    * This moves all the enemies
    * @param enemies- the list of enemies
    */
    public void moveAll(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            enemy.x = enemy.x + enemy.speed;
        }
    }
    /**
    * This removes the enemies that are
    * either off the map or have 0 health.
    * @param enemies- the current arraylist of enemies
    * @return the new arraylist of enemies
    */
    public ArrayList<Enemy> removeEnemies(ArrayList<Enemy> enemies) {
       ArrayList<Enemy> enemCopy = new ArrayList<Enemy>();
       for (Enemy e : enemies) {
          enemCopy.add(e);
       }
       for (Enemy enemy : enemies) {
           if (enemy.x > 600) {
                enemCopy.remove(enemy);
                cPanel.score = cPanel.score - 1;
                cPanel.setScore();
       }
           else if (enemy.health <= 0) {
                   enemCopy.remove(enemy);
                   cPanel.moneyAmount = cPanel.moneyAmount + 50;
                   cPanel.setMoney();
           }
           else {
               cPanel.setMoney();
           }
       }
       enemies = enemCopy;
       return enemies;
    }
    /**
    * This method first clears the rectangle.
    * Then it repaints the path and towers.
    * After that, it draws everything.
    * @param enemies- the current arraylist of enemies
    */
    public void paintEverything(ArrayList<Enemy> enemies) throws IOException {
        getGraphics().clearRect(0, 0, 600, 600);
        paintComponent(getGraphics());
        for (Enemy enemy : enemies) {
            enemy.draw(getGraphics());
        }
    }
    /**
    * This abstract class defines general enemy behavior
    * @param enemies- the current arraylist of enemies
    */
    public void doDamage(ArrayList<Enemy> enemies) {
       for (Tower t : towers) {
         int enemiesHit = 0;
         for (Enemy enemy : enemies) {
           int r = t.range;
           int xRange = Math.abs(t.x - enemy.x);
           int yRange = Math.abs(t.y - enemy.y);
           double diff = Math.hypot(xRange, yRange);
           if (enemiesHit < t.spread && diff <= r) {
             enemy.setHealth(enemy.health - t.damage);
             try {
               BufferedImage image = ImageIO.read(new File("red-dot.png"));
               int xLoc = enemy.x;
               int yLoc = enemy.y;
               getGraphics().drawImage(image, xLoc, yLoc, 15, 15, enemy.panel);
             }
                 catch (IOException e) {
                     System.out.println(e.getMessage());
                 }
                 enemiesHit = enemiesHit + 1;
               }
           }
        }
       }
    private class WaveListener implements ActionListener {
        private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        private int round;
        private int difficulty;
        public WaveListener() {
            round = 1;
            difficulty = 1;
            enemies.add(generateEnemy(difficulty));
        }
        public void actionPerformed(ActionEvent e) {
          int size = enemies.size();
          if (cPanel.score <= 0 || (size == 0 && round >= 10)) {
              timer.stop();
              round = 0;
              difficulty = difficulty + 1;
          }
          else {
               try {
                 paintEverything(enemies);
               }
               catch (IOException a) {
                   System.out.println(0);
               }
               catch (NullPointerException a) {
                      System.out.println("oops");
               }
               doDamage(enemies);
               moveAll(enemies);
               enemies = removeEnemies(enemies);
               if (round < 10) {
                    round = round + 1;
                    enemies.add(generateEnemy(difficulty));
               }
          }
    }
}
    private class ClickListener extends MouseAdapter {
       //***You do not need to edit this private inner class
       // but you should know what it is accomplishing.
       /**
        * You are not required to know what exactly is going on in this method.
        * However, if you are curious, you should check out the Class API. Using
        * a tool called 'reflection', it is instantiating a Fish given a
        * String that represents the class name. This way, we don't need a long
        * series of 'if' statements to create a certain type of Fish.
        *@param Point p is where the fish will be placed to start.
        *@param String className is the class name for the type of Fish that
        *       we want to instantiate.
        *@return Fish that is exactly the type of Fish that we want to add
        *        to the panel.
        */
        public Tower instantiateTowerSpecies(Point p, String className) {
          try {
          Class cl = Class.forName(className);
          return (Tower) (cl.getDeclaredConstructor(
          int.class, int.class, Rectangle.class).newInstance(
                    p.x, p.y, bounds));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (InstantiationException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                System.exit(1);
            }
            return null;
        }
        public void mousePressed(MouseEvent e) {
            String towerType = cPanel.getTowerType();
            Point p = e.getPoint();
            try {
                Class c1 = Class.forName(towerType);
                Method method = c1.getMethod("getMoney", null);
                int price = (Integer) method.invoke(null, null);
                if (cPanel.moneyAmount - price >= 0) {
                    towers.add(instantiateTowerSpecies(p, towerType));
                    cPanel.moneyAmount = cPanel.moneyAmount - price;
                    repaint();
                    cPanel.setMoney();
                }
            }
            catch (Exception a) {
                a.printStackTrace();
                System.exit(1);
            }
       }
}
}

