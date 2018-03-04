
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
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
  private Menu newGameMenu;
  private Menu pauseMenu;
  private Menu gameOverMenu;
  private List<JPanel> menus;
  private Manager mngr;
  private Controller cntr;
  private Timer repaintTimer;

  private Window() {
    super("Go Tetrisy");
    uiGrid = new UIGrid();
    newGameMenu = Menu.getNewGame(); 
    pauseMenu = Menu.getPause(); 
    gameOverMenu = Menu.getGameOver(); 
    menus = new ArrayList<JPanel>(Arrays.asList(newGameMenu, pauseMenu, gameOverMenu));
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setContentPane(uiGrid);
    uiGrid.setLayout(null);

    for (JPanel menu : menus) {
      menu.setBounds(30, 30, menu.getWidth(), menu.getHeight());
      uiGrid.add(menu);
    }

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
  }

  public void resetGridPointer() {
    uiGrid.resetPointer();
  }

  public class repaintTimerActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }

  public void onlyShow(JPanel visibleMenu) {
    // If visibleMenu is null, all menus are set to invisible
    for (JPanel menu : menus) {
      menu.setVisible(menu == visibleMenu);
    }
  }

  public void showNewGameMenu() {
    onlyShow(newGameMenu);
  }

  public void startGame() {
    resetGridPointer();
    onlyShow(null);
    repaintTimer.start();
  }

  public void endGame() {
    onlyShow(gameOverMenu);
    repaintTimer.stop();
  }

  public void toggleGameOnPaused() {
    pauseMenu.setVisible(! pauseMenu.isVisible());
    if (repaintTimer.isRunning()) {
      repaintTimer.stop();
    }
    else {
      repaintTimer.start();
    }
  }

  public void setGridColorScheme(ColorScheme colorScheme) {
    uiGrid.setColorScheme(colorScheme);
    uiGrid.repaint();
  }

  public void keyPressed(KeyEvent e) {
    cntr.proceeKeyPressed(e.getKeyCode());
  }

  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {}

  public void showCustomizeSizeWindow() {
    CustomizeSizeWindow.show(cntr);
  }
}

