
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
    mngr.setTimerOn();
    window.startGame(); 
  }

  public void shiftLeftAttempt() {
    mngr.shiftPieceX(-1); 
  }

  public void shiftRightAttempt() {
    mngr.shiftPieceX(1);
  }

  public void shiftDownAttempt() {
    mngr.shiftPieceY(1);
  }

  public void rotateLeftAttempt() {
    mngr.rotatePieceLeft();
  }

  public void rotateRightAttempt() {
    mngr.rotatePieceRight();
  }

  public void dropAttempt() {
    mngr.dropPiece();
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

    if (gameStatus == GameStatus.STARTING) {
      if (key == KeyEvent.VK_S) {
        setGameOn();
        return;
      }
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
        shiftLeftAttempt();
      }
      else if (key == KeyEvent.VK_RIGHT) {
        shiftRightAttempt();
      }
      else if (key == KeyEvent.VK_DOWN) {
        shiftDownAttempt();
      }

      // Rotate
      else if (key == KeyEvent.VK_Z) {
        rotateLeftAttempt();
      }
      else if (key == KeyEvent.VK_X) {
        rotateRightAttempt();
      }

      // Drop
      else if (key == KeyEvent.VK_SPACE) {
        dropAttempt();
      }

      else {}
    }

  }

}
