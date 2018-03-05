
import java.awt.*;
import javax.swing.*;


public class Menu extends JPanel {

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

  private GridBagConstraints c;

  public Menu() {
    super();
    setLayout(new GridBagLayout());
    c = new GridBagConstraints();
    c.gridy = 0;
  }

  public void addComp(Component comp) {
    super.add(comp, c);
    c.gridy += 1;
  }

}
