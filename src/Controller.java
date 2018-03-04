
import java.awt.event.*;


public class Controller implements GameOverEventListener {
  private static Controller cntr = null;

  public static Controller getInstance() {
    if (cntr == null) {
      cntr = new Controller();
    }
    return cntr;
  }

  private Manager mngr;
  private Window window;
  private GameStatus gameStatus;

  private Controller() {
    gameStatus = GameStatus.STARTING;
  }

  public void doWhenGameOver() {
    gameStatus = GameStatus.GAMEOVER;
    window.endGame();
  }

  public void setManager(Manager mngr) {
    this.mngr = mngr;
    this.mngr.addGameOverEventListner(this);
  }

  public void setWindow(Window window) {
    this.window = window;
    this.window.showNewGameMenu();
  }

  public void setGameOn() {
    gameStatus = GameStatus.ON;
    mngr.startGame();
    window.startGame(); 
  }

  public void pauseOrResume() {
    if (gameStatus == GameStatus.ON) {
      gameStatus = GameStatus.PAUSED;
    }
    else if (gameStatus == GameStatus.PAUSED) {
      gameStatus = GameStatus.ON;
    }
    mngr.toggleTimer();
    window.toggleGameOnPaused();
  }

  public void proceeKeyPressed(int key) {
    if ((gameStatus == GameStatus.STARTING) || (gameStatus == GameStatus.GAMEOVER)) {
      if (key == KeyEvent.VK_S) {
        setGameOn();
        return;
      }

      if (key == KeyEvent.VK_C) {
        window.showCustomizeSizeWindow();
      }
      else if (key == KeyEvent.VK_G) {
        mngr.updateGridToDefault();
      }
      else {}
    }

    if ((gameStatus == GameStatus.ON) || (gameStatus == GameStatus.PAUSED)) {
      // Pause or Resume
      if (key == KeyEvent.VK_P) {
        pauseOrResume();
        return;
      }
    }

    if (gameStatus == GameStatus.ON) {
      // Shift
      if (key == KeyEvent.VK_LEFT) {
        mngr.shiftPieceX(-1);
      }
      else if (key == KeyEvent.VK_RIGHT) {
        mngr.shiftPieceX(1);
      }
      else if (key == KeyEvent.VK_DOWN) {
        mngr.shiftPieceY(1);
      }

      // Rotate
      else if (key == KeyEvent.VK_Z) {
        mngr.rotatePieceLeft();
      }
      else if (key == KeyEvent.VK_X) {
        mngr.rotatePieceRight();
      }

      // Drop
      else if (key == KeyEvent.VK_SPACE) {
        mngr.dropPiece();
      }

      else {}
    }

    if (gameStatus != GameStatus.ON) {
      if (key == KeyEvent.VK_1) {
        window.setGridColorScheme(ColorScheme.DEFAULT);
      }
      else if (key == KeyEvent.VK_2) {
        window.setGridColorScheme(ColorScheme.PASTEL);
      }
      else if (key == KeyEvent.VK_3) {
        window.setGridColorScheme(ColorScheme.MONO);
      }
      else {}
    }
  }

  public void updateGridSize(int h, int w) {
    mngr.updateGridSize(h, w);
  }
}
