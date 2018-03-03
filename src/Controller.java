
public class Controller {
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

  public void setManager(Manager mngr) {
    this.mngr = mngr;
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


}
