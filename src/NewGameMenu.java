
import java.awt.*;
import javax.swing.*;

public class NewGameMenu extends JPanel {

  private int width = 300;
  private int height = 500;

  public NewGameMenu() {
    super();
    setPreferredSize(new Dimension(width, height));
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.gridy = 0;
    add(MenuPart.get("NEW GAME"), c);

    c.gridy += 1;
    add(MenuPart.get("Press < s > to START!"), c);

    c.gridy += 1;
    add(MenuPart.get("Controls"), c);

    c.gridy += 1;
    add(MenuPart.getControls(), c);

    c.gridy += 1;
    add(MenuPart.get("Pick color scheme"), c);

    c.gridy += 1;
    add(MenuPart.getColorOptions(), c);

    c.gridy += 1;
    add(MenuPart.get("Make your own grid"), c);

    c.gridy += 1;
    add(MenuPart.getGridOptions(), c);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
