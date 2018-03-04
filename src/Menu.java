
import java.awt.*;
import javax.swing.*;


public class Menu extends JPanel {

  public static int DEFAULT_WIDTH = 300;
  public static int DEFAULT_HEIGHT = 500;

  public static Menu getNewGame() {
    Menu menu = new Menu();
    
    menu.add(MenuPart.getTitlePanel("NEW GAME", "Press < s > to START!"), menu.c);

    menu.c.gridy += 1;
    menu.add(MenuPart.getControlsPanel(), menu.c);

    menu.c.gridy += 1;
    menu.add(MenuPart.getColorOptionsPanel(false), menu.c);

    menu.c.gridy += 1;
    menu.add(MenuPart.getGridOptionsPanel(), menu.c);

    return menu;
  }

  public static Menu getPause() {
    Menu menu = new Menu();

    menu.add(MenuPart.getTitlePanel("PAUSED", "Press < p > to RESUME!"), menu.c);

    menu.c.gridy += 1;
    menu.add(MenuPart.getControlsPanel(), menu.c);

    menu.c.gridy += 1;
    menu.add(MenuPart.getColorOptionsPanel(true), menu.c);

    return menu;
  }

  public static Menu getGameOver() {
    Menu menu = new Menu();
    
    menu.add(MenuPart.getTitlePanel("GAME OVER", "Press < s > to START!"), menu.c);

    menu.c.gridy += 1;
    menu.add(MenuPart.getControlsPanel(), menu.c);

    menu.c.gridy += 1;
    menu.add(MenuPart.getColorOptionsPanel(false), menu.c);

    menu.c.gridy += 1;
    menu.add(MenuPart.getGridOptionsPanel(), menu.c);

    return menu;
  }

  int width;
  int height;
  private GridBagConstraints c;

  public Menu() {
    super();
    width = DEFAULT_WIDTH;
    height = DEFAULT_HEIGHT;
    setPreferredSize(new Dimension(width, height));
    setLayout(new GridBagLayout());
    c = new GridBagConstraints();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
