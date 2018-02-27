
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
  private UIGrid uiGrid;

  private Controller() {}

  public void setManager(Manager mngr) {
    this.mngr = mngr;
  }

  public void setWindow(Window window) {
    this.window = window;
  }

  public void shiftLeftAttempt() {
    mngr.shiftPieceX(-1); 
    uiGrid.repaint();
  }

  public void shiftRightAttempt() {
    mngr.shiftPieceX(1);
    uiGrid.repaint();
  }

  public void shiftDownAttempt() {
    mngr.shiftPieceY(1);
    uiGrid.repaint();
  }

  public void rotateLeftAttempt() {
    mngr.rotatePieceLeft();
    uiGrid.repaint();
  }

  public void rotateRightAttempt() {
    mngr.rotatePieceRight();
    uiGrid.repaint();
  }

  public void dropAttempt() {
    mngr.dropPiece();
    mngr.updateGrid();
    bringInNewPiece();
  }

  public void pause() {
    System.out.println("PAUSE");  // Write later
  }

  public void bringInNewPiece() {
    mngr.setupNewPiece();
    uiGrid.setPiece();
    uiGrid.repaint();
  }
}
