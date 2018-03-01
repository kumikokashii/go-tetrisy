
public class Piece {
  public Block block;
  public BlockName blockName;
  public int y;
  public int x;

  public Piece() {}

  public Piece(Block block) {
    this.block = block;
    blockName = block.name;
    y = 0;  // Write later
    x = 3;  // Write later
  }

  public BlockName getBlockName() {
    return blockName;
  }

  public void shiftX(int value) {
    x += value;
  }

  public void shiftY(int value) {
    y += value;
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
    newPiece.blockName = blockName;
    newPiece.y = y;
    newPiece.x = x;
    return newPiece;
  }
}

