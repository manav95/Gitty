import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.Timer;
/**
 * This class is the driver class for the game
 * @author: Manav Dutta
 * @version: 2.0
 */
public class TowerDefenseGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TowerDefense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer timer = new Timer(500, null);
        InputPanel control = new InputPanel(timer);
        frame.add(control, BorderLayout.WEST);
        frame.add(new GamePanel(control));
        frame.pack();
        frame.setVisible(true);
    }
}
