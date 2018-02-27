
public class Piece {
  public Block block;
  public int y;
  public int x;
  public boolean isOver;

  public Piece() {}

  public Piece(Block block) {
    this.block = block;
    y = 0;  // Write later
    x = 3;  // Write later
    isOver = false;
  }   

  public void setIsOver(boolean isOver) {
    this.isOver = isOver;
  }

  public void rotateRight() {
    y += block.getRotateShiftY();
    x += block.getRotateRightShiftX();
    block = block.getRightRotated();
  }   

  public void rotateLeft() {
    y += block.getRotateShiftY();
    x += block.getRotateLeftShiftX();
    block = block.getLeftRotated();
  }   

  public String toString() {
    String s = String.format("y=%d, x=%d%n", y, x); 
    s += block;
    return s;
  }

  public Piece copy() {
    Piece newPiece = new Piece();
    newPiece.block = block;
    newPiece.y = y;
    newPiece.x = x;
    return newPiece;
  }
}

