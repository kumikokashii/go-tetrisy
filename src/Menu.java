
import java.awt.*;
import javax.swing.*;


public class Menu extends JPanel {

  public static int DEFAULT_WIDTH = 300;
  public static int DEFAULT_HEIGHT = 500;

  public static Menu getNewGame() {
    Menu menu = new Menu();
    menu.addComp(MenuPart.getTitlePanel("NEW GAME", "Press < s > to START!"));
    menu.addComp(MenuPart.getControlsPanel());
    menu.addComp(MenuPart.getColorOptionsPanel(false));
    menu.addComp(MenuPart.getGridOptionsPanel());
    return menu;
  }

  public static Menu getPause() {
    Menu menu = new Menu();
    menu.addComp(MenuPart.getTitlePanel("PAUSED", "Press < p > to RESUME!"));
    menu.addComp(MenuPart.getControlsPanel());
    menu.addComp(MenuPart.getColorOptionsPanel(true));
    return menu;
  }

  public static Menu getGameOver() {
    Menu menu = new Menu();
    menu.addComp(MenuPart.getTitlePanel("GAME OVER", "Press < s > to START!"));
    menu.addComp(MenuPart.getControlsPanel());
    menu.addComp(MenuPart.getColorOptionsPanel(false));
    menu.addComp(MenuPart.getGridOptionsPanel());
    return menu;
  }

  private int width;
  private int height;
  private GridBagConstraints c;

  public Menu() {
    super();
    width = DEFAULT_WIDTH;
    height = DEFAULT_HEIGHT;
    setPreferredSize(new Dimension(width, height));
    setLayout(new GridBagLayout());
    c = new GridBagConstraints();
    c.gridy = 0;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void addComp(Component comp) {
    super.add(comp, c);
    c.gridy += 1;
  }

}
