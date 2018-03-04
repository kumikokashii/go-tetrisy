
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.NumberFormatException;

public class CustomizeSizeWindow extends JFrame {

  public static int DEFAULT_WIDTH = 200;
  public static int DEFAULT_HEIGHT = 100;
  public static int MIN = 10;
  public static int MAX = 50;

  public static void show(Controller cntr) {
    CustomizeSizeWindow csw = new CustomizeSizeWindow(cntr);
    csw.setVisible(true);
  }

  Controller cntr;
  InputsPanel inputsPanel = new InputsPanel();
  JButton cancelButton = new CancelButton();
  JButton setButton = new SetButton();

  public CustomizeSizeWindow(Controller cntr) {
    super("Go Tetrisy Customize Size");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel cp = new JPanel();
    cp.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    cp.add(new JLabel(String.format("Enter integers between %d and %d.", MIN, MAX)));
    cp.add(inputsPanel);
    cp.add(cancelButton);
    cp.add(setButton);

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
      String.format("Sorry, only integers between %d and %d.", MIN, MAX),
      "Input Error",
      JOptionPane.ERROR_MESSAGE);
  }

  public class InputsPanel extends JPanel {
    JTextField widthInput = new JTextField(4);
    JTextField heightInput = new JTextField(4);

    public InputsPanel() {
      super();
      add(new JLabel("Width:"));
      add(widthInput);
      add(new JLabel("Height:"));
      add(heightInput);
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

