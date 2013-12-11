import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.Timer;
/**
    * This is the input Panel. This allows the user to
    * build towers and start the actual game.
    * @author Manav Dutta
    * @version 2.0
    */
public class InputPanel extends JPanel {
    private JButton sendWave, simpkinsTower, buzzTower, burdellTower;
    private JLabel money, drugs;
    protected int moneyAmount, score;
    private JLabel current;
    private String towerType;
    protected Timer timer;
    /**
     * This constructs the whole input panel
     * with the various tower buttons and
     * the button to send in a wave of enemies.
     * @param t- the timer
     */
    public InputPanel(Timer t) {
       timer = t;
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       setPreferredSize(new Dimension(150, 600));
       sendWave = new JButton("SendWave");
       simpkinsTower = new JButton("SimpkinsTower");
       simpkinsTower.addActionListener(new ButtonListener("SimpkinsTower"));
       buzzTower = new JButton("BuzzTower");
       buzzTower.addActionListener(new ButtonListener("BuzzTower"));
       burdellTower = new JButton("BurdellTower");
       burdellTower.addActionListener(new ButtonListener("BurdellTower"));
       sendWave.addActionListener(new InitializerListener(timer));
       add(burdellTower);
       add(Box.createRigidArea(new Dimension(20, 20)));
       add(buzzTower);
       add(Box.createRigidArea(new Dimension(20, 20)));
       add(simpkinsTower);
       add(Box.createRigidArea(new Dimension(20, 20)));
       add(sendWave);
       add(Box.createRigidArea(new Dimension(20, 20)));
       score = 9;
       moneyAmount = 200;
       money = new JLabel("Money: " + moneyAmount);
       drugs = new JLabel("Score: " + score);
       current = new JLabel("Current tower selected: " + towerType);
       add(drugs);
       add(Box.createRigidArea(new Dimension(20, 20)));
       add(money);
       add(Box.createRigidArea(new Dimension(20, 20)));
       add(current);
    }
    /**
    * This returns the type of the tower.
    * @return the type of the tower
    */
    public String getTowerType() {
        return towerType;
    }
    /**
    * This sets the money the player has.
    * This is displayed on the panel.
    */
    public void setMoney() {
        money.setText("Money: " + moneyAmount);
    }
    /**
    * This sets the player's score.
    */
    public void setScore() {
        drugs.setText("Score: " + score);
    }
    private class InitializerListener implements ActionListener {
      private Timer timer;
      public InitializerListener(Timer t) {
          timer = t;
      }
      public void actionPerformed(ActionEvent e) {
            timer.start();
      }
    }
    private class ButtonListener implements ActionListener {
        private String name;
        /**
        * Constructs a new button listener.
        * @param className the name of the class
        */
        public ButtonListener(String className) {
            name = className;
        }
        /**
        * Performs an action.
        * @param e the name of an action
        */
        public void actionPerformed(ActionEvent e) {
            towerType = name;
            current.setText(name);
        }
    }
}
