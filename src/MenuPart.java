
import java.awt.*;
import javax.swing.*;


public class MenuPart extends JPanel {
  public static JLabel get(String text) {
    JLabel label = new JLabel(text);
    return label;
  }

  public static JPanel getTitlePanel(String title, String startInstruction) {
    MenuPart panel = new MenuPart();
    panel.addComp(get(title));
    panel.addComp(get(startInstruction));
    return panel;
  }

  public static JPanel getControlsPanel() {
    MenuPart panel = new MenuPart();
    panel.addComp(get("Controls"));
    panel.addComp(get("< \u2190 > Shift Left"));
    panel.addComp(get("< \u2192 > Shift Right"));
    panel.addComp(get("< \u2193 > Shift Down"));
    panel.addComp(get("< z > Rotate Left"));
    panel.addComp(get("< x > Rotate Right"));
    panel.addComp(get("< Space Bar> Drop"));
    panel.addComp(get("< p > Pause"));
    return panel;
  }

  public static JPanel getColorOptionsPanel(boolean paused) {
    MenuPart panel = new MenuPart();
    String instruction = "Pick color scheme";
    if (paused) {
      instruction = "Switch color scheme";
    }
    panel.addComp(get(instruction));
    panel.addComp(get("< 1 > Default"));
    panel.addComp(get("< 2 > Pastel"));
    panel.addComp(get("< 3 > B & W"));
    return panel;
  }

  public static JPanel getGridOptionsPanel() {
    MenuPart panel = new MenuPart();
    panel.addComp(get("Make your own grid"));
    panel.addComp(get("< c > Customize size"));
    panel.addComp(get("< f > Fill some squares"));
    panel.addComp(get("< g > Standard grid"));
    return panel;
  }

  private GridBagConstraints c;

  public MenuPart() {
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

