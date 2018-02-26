
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Manager {
  public static void main(String[] args) {
    Manager m = new Manager(20, 10);

    while (! m.gameIsOver) {
      m.setupNewPiece();
      System.out.println(m.piece);
      m.rotatePieceLeft();
      System.out.println(m.piece);

      m.dropPiece();
      m.updateGrid();
      System.out.println(m.grid);
    }
  }

  public void updateGrid() {
    addPieceToGrid();
    checkGameOver();
    if (gameIsOver) {
      System.out.println("GAME OVER");
      return;
    }
    grid.removeRows(piece.y, (piece.y + piece.block.yLen));
    grid.addRows();
  }

  private Grid grid;
  private List<Block> blocks;
  private int blocks_size;
  private Piece piece;
  private boolean gameIsOver = false;

  public Manager(int grid_h, int grid_w) {
    this.grid = new Grid(grid_h, grid_w);
    blocks = Arrays.asList(Block.values()); 
    blocks_size = blocks.size();
  }

  public Grid getGrid() {
    return grid;
  }

  public Block getRandomBlock() {
    int i = ThreadLocalRandom.current().nextInt(0, blocks_size);
    return blocks.get(i);
  }

  public void setupNewPiece() {
    Block block = getRandomBlock();
    piece = new Piece(block);
  }

  public boolean moveIsValid(Piece maybePiece) {
    // Beyond left wall
    if (maybePiece.x < 0) {
      return false;
    }

    // Beyond right wall
    if ((maybePiece.x + maybePiece.block.xLen) > grid.w) {
      return false;
    }

    // Beyond floor
    if ((maybePiece.y + maybePiece.block.yLen) > grid.h) {
      return false;
    }

    // Overlap filled of grid
    for (int y = maybePiece.y; y < (maybePiece.y + maybePiece.block.yLen); y++) {
      if (y < 0 ) {
        continue;
      }
      for (int x = maybePiece.x; x < (maybePiece.x + maybePiece.block.xLen); x++) {
        if (! maybePiece.block.isFilled(y - maybePiece.y, x - maybePiece.x)) {
          continue;
        }
        if (grid.isFilled(y, x)) {
          return false;
        }
      }
    }

    return true;
  }

  public void shiftPieceX(int value) {
    Piece maybePiece = piece.copy();
    maybePiece.x += value;
    if (moveIsValid(maybePiece)) {
      piece.x += value;
    }
  }

  public void shiftPieceY(int value) {
    Piece maybePiece = piece.copy();
    maybePiece.y += value;
    if (moveIsValid(maybePiece)) {
      piece.y += value;
    }
  }

  public void rotatePieceRight() {
    Piece maybePiece = piece.copy();
    maybePiece.rotateRight();
    if (moveIsValid(maybePiece)) {
      piece.rotateRight();
    }
  }

  public void rotatePieceLeft() {
    Piece maybePiece = piece.copy();
    maybePiece.rotateLeft();
    if (moveIsValid(maybePiece)) {
      piece.rotateLeft();
    }
  }

  public void dropPiece() {
    Piece maybePiece = piece.copy();
    int count = 0;
    while (true) {
      maybePiece.y += 1;
      if (moveIsValid(maybePiece)) {
        count += 1;
      }
      else {
        break;
      }
    }

    shiftPieceY(count);
  }

  public void addPieceToGrid() {
    for (int y = piece.y; y < (piece.y + piece.block.yLen); y++) {
      if (y < 0) {
        continue;
      }
      for (int x = piece.x; x < (piece.x + piece.block.xLen); x++) {
        if (piece.block.isFilled(y - piece.y, x - piece.x)) {
          grid.fill(y, x);
        }
      }
    }
  }

  public void checkGameOver() {
    if (piece.y <= 0) {
      gameIsOver = true;
    }
  }

}
