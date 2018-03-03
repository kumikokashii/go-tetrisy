
import java.awt.*;
import javax.swing.*;

public class NewGameMenu extends JPanel {

  private int width = 300;
  private int height = 500;

  public NewGameMenu() {
    super();
    setPreferredSize(new Dimension(width, height));
    
    JLabel text = new JLabel("NEW GAME MENU ^_^");
    add(text);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
