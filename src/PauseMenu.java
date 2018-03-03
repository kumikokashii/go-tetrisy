
import java.awt.*;
import javax.swing.*;

public class PauseMenu extends JPanel {

  private int width = 300;
  private int height = 500;

  public PauseMenu() {
    super();
    setPreferredSize(new Dimension(width, height));
    
    JLabel text = new JLabel("PAUSE MENU ^_^");
    add(text);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
