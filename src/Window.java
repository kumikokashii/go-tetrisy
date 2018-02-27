
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Window extends JFrame implements KeyListener {

  public static int DEFAULT_WIDTH = 500;
  public static int DEFAULT_HEIGHT = 650;
  public static int DEFAULT_REPAINT_EVERY = 100;  // 1000 milliseconds = 1 sec

  private static Window window = null;

  public static Window getInstance() {
    if (window == null) {
      window = new Window();
    }
    return window;
  }

  private UIGrid uiGrid;
  private Manager mngr;
  private Controller cntr;
  private Timer repaintTimer;

  private Window() {
    super("Go Tetrisy");
    uiGrid = new UIGrid();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setContentPane(uiGrid);

    repaintTimer = new Timer(DEFAULT_REPAINT_EVERY, new repaintTimerActionListener());

    addKeyListener(this);
    setFocusable(true);
  }

  public void setManager(Manager mngr) {
    this.mngr = mngr;
    uiGrid.setManager(mngr);
  }

  public void setController(Controller cntr) {
    this.cntr = cntr;
    uiGrid.setController(cntr);
  }

  public class repaintTimerActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }

  public void setOn() {
    repaintTimer.start();
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    // Shift
    if (key == KeyEvent.VK_LEFT) {
      cntr.shiftLeftAttempt();
    }
    else if (key == KeyEvent.VK_RIGHT) {
      cntr.shiftRightAttempt();
    }
    else if (key == KeyEvent.VK_DOWN) {
      cntr.shiftDownAttempt();
    }

    // Rotate
    else if (key == KeyEvent.VK_Z) {
      cntr.rotateLeftAttempt();
    }
    else if (key == KeyEvent.VK_X) {
      cntr.rotateRightAttempt();
    }

    // Drop
    else if (key == KeyEvent.VK_SPACE) {
      cntr.dropAttempt();
    }

    // Pause
    else if (key == KeyEvent.VK_P) {
      cntr.pause();
    }

    else {}
  }

  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {}

}

