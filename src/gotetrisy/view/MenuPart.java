
package gotetrisy.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class MenuPart extends JPanel {
  public static JLabel get(String text, int size) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("American Typewriter", Font.BOLD, size));
    return label;
  }

  public static JLabel get(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Futura", Font.PLAIN, 16));
    return label;
  }

  public static JPanel getTitlePanel(String title, String startInstruction) {
    MenuPart panel = new MenuPart();
    panel.addComp(get(title, 22));
    panel.addComp(get(startInstruction));
    return panel;
  }

  public static JPanel getControlsPanel() {
    MenuPart panel = new MenuPart();
    panel.addComp(get("Controls", 20));
    panel.add2Col(get("< \u2190 >"), get("Shift Left"));
    panel.add2Col(get("< \u2192 >"), get("Shift Right"));
    panel.add2Col(get("< \u2193 >"), get("Shift Down"));
    panel.add2Col(get("< z >"), get("Rotate Left"));
    panel.add2Col(get("< x >"), get("Rotate Right"));
    panel.add2Col(get("< Space >"), get("Drop"));
    panel.add2Col(get("< p >"), get("Pause"));
    return panel;
  }

  public static JPanel getColorOptionsPanel(boolean paused) {
    MenuPart panel = new MenuPart();
    String instruction = "Pick color scheme";
    if (paused) {
      instruction = "Switch color scheme";
    }
    panel.addComp(get(instruction, 20));
    panel.add2Col(get("< 1 >"), get("Default"));
    panel.add2Col(get("< 2 >"), get("Pastel"));
    panel.add2Col(get("< 3 >"), get("B & W"));
    return panel;
  }

  public static JPanel getGridOptionsPanel() {
    MenuPart panel = new MenuPart();
    panel.addComp(get("Make your own grid", 20));
    panel.add2Col(get("< c >"), get("Customize size"));
    panel.add2Col(get("< g >"), get("Standard grid"));
    return panel;
  }

  private GridBagConstraints c;

  MenuPart() {
    super();
    setLayout(new GridBagLayout());
    c = new GridBagConstraints();
    c.gridy = 0;
    c.gridx = 0;
  }

  public void addComp(Component comp) {
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    super.add(comp, c);
    c.gridy += 1;
  }

  public void add2Col(Component comp1, Component comp2) {
    c.gridwidth = 1;
    c.weightx = 0.5;

    c.anchor = GridBagConstraints.CENTER;
    c.ipadx = 10;
    super.add(comp1, c);

    c.gridx += 1;
    c.anchor = GridBagConstraints.LINE_START;
    c.ipadx = 0;
    super.add(comp2, c);

    c.gridy += 1;
    c.gridx -= 1;
  }
}

