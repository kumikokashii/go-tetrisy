
public class Controller {

  private final Manager m;
  private UIGrid uiGrid;

  public Controller(Manager m) {
    this.m = m;
  }

  public void setUIGrid(UIGrid uiGrid) {
    this.uiGrid = uiGrid;
  }

  public void shiftLeftAttempt() {
    m.shiftPieceX(-1); 
    uiGrid.repaint();
  }

  public void shiftRightAttempt() {
    m.shiftPieceX(1);
    uiGrid.repaint();
  }

  public void shiftDownAttempt() {
    m.shiftPieceY(1);
    uiGrid.repaint();
  }

  public void rotateLeftAttempt() {
    m.rotatePieceLeft();
    uiGrid.repaint();
  }

  public void rotateRightAttempt() {
    m.rotatePieceRight();
    uiGrid.repaint();
  }

  public void dropAttempt() {
    m.dropPiece();
    m.updateGrid();
    bringInNewPiece();
  }

  public void pause() {
    System.out.println("PAUSE");  // Write later
  }

  public void bringInNewPiece() {
    m.setupNewPiece();
    uiGrid.setPiece();
    uiGrid.repaint();
  }
}
