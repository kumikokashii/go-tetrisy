
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.lang.NumberFormatException;


public class CustomizeSizeWindow extends JFrame {

  public static int MIN = 10;
  public static int MAX = 50;

  public static void show(Controller cntr) {
    CustomizeSizeWindow csw = new CustomizeSizeWindow(cntr);
    csw.setVisible(true);
  }

  InputsPanel inputsPanel = new InputsPanel();
  Controller cntr;

  public CustomizeSizeWindow(Controller cntr) {
    super("Go Tetrisy Customize Size");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel cp = new JPanel();
    cp.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridy = 0;
    cp.add(MenuPart.get(String.format("Enter integers between %d and %d.", MIN, MAX), 20), c);
    c.gridy += 1;
    cp.add(inputsPanel, c);
    c.gridy += 1;
    cp.add(new ButtonsPanel(), c);

    cp.setBorder(new EmptyBorder(20, 20, 20, 20));
    setContentPane(cp);
    pack();

    this.cntr = cntr;
  }

  public void processSetRequest() {
    int widthInput;
    int heightInput;

    try {
      widthInput = Integer.valueOf(inputsPanel.widthInput.getText());
      heightInput = Integer.valueOf(inputsPanel.heightInput.getText());
    }
    catch (NumberFormatException e) {
      showInputError();
      return;
    }

    if (isOutOfRange(widthInput) || isOutOfRange(heightInput)) {
      showInputError();
      return;
    }

    cntr.updateGridSize(heightInput, widthInput);
    dispose();

  }

  public boolean isOutOfRange(int i) {
    return ((i < MIN) || (i > MAX));
  }

  public void showInputError() {
    JOptionPane.showMessageDialog(this, 
      MenuPart.get(String.format("Sorry, only integers between %d and %d.", MIN, MAX)),
      "Input Error",
      JOptionPane.ERROR_MESSAGE);
  }

  public class InputsPanel extends JPanel {
    JTextField widthInput = new InputField(); 
    JTextField heightInput = new InputField(); 

    public InputsPanel() {
      super();
      add(MenuPart.get("Width:"));
      add(widthInput);
      add(MenuPart.get("Height:"));
      add(heightInput);
    }
  }

  public class InputField extends JTextField {
    public InputField() {
      super(4);
      addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          processSetRequest();
        }
      });
    }
  }

  public class ButtonsPanel extends JPanel {
    public ButtonsPanel() {
      super();
      add(new CancelButton());
      add(new SetButton());
    }
  }

  public class CancelButton extends JButton {
    public CancelButton() {
      super("Cancel");
      addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          CustomizeSizeWindow.this.dispose();
        }
      });
    }
  }

  public class SetButton extends JButton {
    public SetButton() {
      super("Set");
      addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          CustomizeSizeWindow.this.processSetRequest();
        }
      });
    }
  }

}
