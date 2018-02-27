
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

  private Controller() {}

  public void setManager(Manager mngr) {
    this.mngr = mngr;
  }

  public void setWindow(Window window) {
    this.window = window;
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

  public void pause() {
    System.out.println("PAUSE");  // Write later
  }

  public void setOn() {
    mngr.setOn();
    window.setOn();
  }

}
