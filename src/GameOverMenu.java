
import java.awt.*;
import javax.swing.*;

public class GameOverMenu extends JPanel {

  private int width = 300;
  private int height = 500;

  public GameOverMenu() {
    super();
    setPreferredSize(new Dimension(width, height));
    
    JLabel text = new JLabel("GAME OVER MENU ^_^");
    add(text);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
