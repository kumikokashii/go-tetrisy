
import java.awt.*;
import javax.swing.*;


public class MenuPart {
  public static JLabel get(String text) {
    JLabel label = new JLabel(text);
    return label;
  }

  public static JPanel getControls() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridy = 0;
    panel.add(get("< \u2190 > Shift Left, < \u2192 > Shift Right"), c);
    c.gridy += 1;
    panel.add(get("< \u2193 > Shift Down"), c);
    c.gridy += 1;
    panel.add(get("< z > Rotate Left, < x > Rotate Right"), c);
    c.gridy += 1;
    panel.add(get("< Space Bar> Drop"), c);
    c.gridy += 1;
    panel.add(get("< p > Pause"), c);
    return panel;
  }

  public static JPanel getColorOptions() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridy = 0;
    panel.add(get("< 1 > Default"), c);
    c.gridy += 1;
    panel.add(get("< 2 > Pastel"), c);
    c.gridy += 1;
    panel.add(get("< 3 > B & W"), c);
    return panel;
  }

  public static JPanel getGridOptions() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridy = 0;
    panel.add(get("< c > Customize size"), c);
    c.gridy += 1;
    panel.add(get("< f > Fill some squares"), c);
    c.gridy += 1;
    panel.add(get("< g > Standard grid"), c);
    return panel;
  }


}
