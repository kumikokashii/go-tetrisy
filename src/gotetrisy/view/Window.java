
package gotetrisy.view;

import gotetrisy.model.*;
import gotetrisy.controller.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Window extends JFrame implements KeyListener {

  public static int DEFAULT_REPAINT_EVERY = 100;  // 1000 milliseconds = 1 sec

  private UIGrid uiGrid;
  private Menu newGameMenu;
  private Menu pauseMenu;
  private Menu gameOverMenu;
  private List<JPanel> menus;
  private Manager mngr;
  private int gridSideSize;
  private int menuW;
  private int menuH;
  private Controller cntr;
  private Timer repaintTimer;

  public Window() {
    super("Go Tetrisy");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    uiGrid = new UIGrid();
    gridSideSize = uiGrid.getSide();
    setContentPane(uiGrid);
    uiGrid.setLayout(null);

    newGameMenu = Menu.getNewGame(); 
    pauseMenu = Menu.getPause(); 
    gameOverMenu = Menu.getGameOver(); 
    menus = new ArrayList<JPanel>(Arrays.asList(newGameMenu, pauseMenu, gameOverMenu));
    for (JPanel menu : menus) {
      uiGrid.add(menu);
    }
    
    repaintTimer = new Timer(DEFAULT_REPAINT_EVERY, new repaintTimerActionListener());

    addKeyListener(this);
    setFocusable(true);
  }

  public void setManager(Manager mngr) {
    this.mngr = mngr;
    uiGrid.setManager(mngr);
    initMenuSize();
    refresh();
  }

  public void setController(Controller cntr) {
    this.cntr = cntr;
  }

  public void refresh() {
    uiGrid.resetPointer();
    resetMenuLocation();
    pack();
    repaint();
  }

  public void initMenuSize() {
    menuW = (mngr.getGridW() - 2) * gridSideSize;
    menuH = (mngr.getGridH() - 2) * gridSideSize;

    for (JPanel menu : menus) {
      menu.setBounds(gridSideSize, gridSideSize, menuW, menuH);
    }
  }

  public void resetMenuLocation() {
    int menuX = ((mngr.getGridW() * gridSideSize) - menuW) / 2;
    for (JPanel menu : menus) {
      menu.setLocation(menuX, gridSideSize);
    }
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
    refresh();
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

