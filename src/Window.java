
import java.awt.*;
import javax.swing.*;


public class Window extends JFrame {

  public static int DEFAULT_WIDTH = 500;
  public static int DEFAULT_HEIGHT = 650;

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

  private Window() {
    super("Go Tetrisy");
    uiGrid = new UIGrid();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setContentPane(uiGrid);
  }

  public void setManager(Manager mngr) {
    this.mngr = mngr;
    uiGrid.setManager(mngr);
  }

  public void setController(Controller cntr) {
    this.cntr = cntr;
    uiGrid.setController(cntr);
  }
}
