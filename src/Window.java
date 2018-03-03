
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
  private NewGameMenu newGameMenu;
  private PauseMenu pauseMenu;
  private GameOverMenu gameOverMenu;
  private Manager mngr;
  private Controller cntr;
  private Timer repaintTimer;

  private Window() {
    super("Go Tetrisy");
    uiGrid = new UIGrid();
    pauseMenu = new PauseMenu();
    newGameMenu = new NewGameMenu();
    gameOverMenu = new GameOverMenu();
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setContentPane(uiGrid);
    uiGrid.setLayout(null);

    pauseMenu.setBounds(30, 30, pauseMenu.getWidth(), pauseMenu.getHeight());
    newGameMenu.setBounds(30, 30, newGameMenu.getWidth(), newGameMenu.getHeight());
    gameOverMenu.setBounds(30, 30, gameOverMenu.getWidth(), newGameMenu.getHeight());
    uiGrid.add(pauseMenu);
    uiGrid.add(newGameMenu);
    uiGrid.add(gameOverMenu);

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

  public class repaintTimerActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }

  public void showNewGameMenu() {
    newGameMenu.setVisible(true);
    pauseMenu.setVisible(false);
    gameOverMenu.setVisible(false);
  }

  public void startGame() {
    pauseMenu.setVisible(false);
    newGameMenu.setVisible(false);
    repaintTimer.start();
  }

  public void endGame() {
    gameOverMenu.setVisible(true);
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

  

  public void keyPressed(KeyEvent e) {
    cntr.proceeKeyPressed(e.getKeyCode());
  }

  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {}

}

