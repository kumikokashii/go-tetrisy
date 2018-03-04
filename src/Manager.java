
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Timer;
import java.awt.event.*;

public class Manager {
  public static int DEFAULT_GRID_H = 20;
  public static int DEFAULT_GRID_W = 10;
  public static int DEFAULT_DROP_EVERY = 1000;  // 1000 milliseconds = 1 sec
  
  private static Manager mngr = null;

  public static Manager getInstance() {
    if (mngr == null) {
      mngr = new Manager();
    }
    return mngr;
  }

  private int grid_h;
  private int grid_w;
  private Grid grid;
  private List<Block> blocks;
  private int blocks_size;
  private Piece piece;
  private boolean gameIsOver;
  private boolean pieceIsOver;
  private Timer dropTimer;
  private List<GameOverEventListener> gameOverEventListeners = new ArrayList<>();

  private Manager() {
    grid_h = DEFAULT_GRID_H;
    grid_w = DEFAULT_GRID_W;
    grid = new Grid(grid_h, grid_w);
    blocks = Arrays.asList(Block.values()); 
    blocks_size = blocks.size();
    piece = null;
    gameIsOver = false;
    dropTimer = new Timer(DEFAULT_DROP_EVERY, new dropTimerActionListener());
  }

  public void addGameOverEventListner(GameOverEventListener listener) {
    gameOverEventListeners.add(listener);
  }

  public void startGame() {
    clearGrid();
    piece = null;
    gameIsOver = false;
    dropTimer.start();
  }

  public class dropTimerActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (piece == null) {
        setupNewPiece();
        return;
      }

      checkPieceIsOver();
      if (! pieceIsOver) {
        shiftPieceY(1);
        return;
      }

      addPieceToGrid();

      checkGameOver();
      if (gameIsOver) {
        dropTimer.stop();
        for (GameOverEventListener listener : gameOverEventListeners) {
          listener.doWhenGameOver();
        }
        return;
      }

      grid.removeRows(piece.y, (piece.y + piece.block.yLen));
      grid.addRows();
      setupNewPiece();
    }
  }

  public void updateGridToDefault() {
    grid_h = DEFAULT_GRID_H;
    grid_w = DEFAULT_GRID_W; 
  }

  public void updateGridSize(int h, int w) {
    grid_h = h;
    grid_w = w;
  }

  public void clearGrid() {
    grid = new Grid(grid_h, grid_w);
  }

  public void toggleTimer() {
    if (dropTimer.isRunning()) {
      dropTimer.stop();
    }
    else {
      dropTimer.start();
    }
  }

  public Grid getGrid() {
    return grid;
  }

  public Piece getPiece() {
    return piece;
  }

  public Block getRandomBlock() {
    int i = ThreadLocalRandom.current().nextInt(0, blocks_size);
    return blocks.get(i);
  }

  public void setupNewPiece() {
    Block block = getRandomBlock();
    piece = new Piece(block);
    pieceIsOver = false;
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
    maybePiece.shiftX(value);
    if (moveIsValid(maybePiece)) {
      piece.shiftX(value);
    }
  }

  public void shiftPieceY(int value) {
    Piece maybePiece = piece.copy();
    maybePiece.shiftY(value);
    if (moveIsValid(maybePiece)) {
      piece.shiftY(value);
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
          grid.fill(y, x, piece.getBlockName());
        }
      }
    }
  }

  public void checkGameOver() {
    if (piece.y <= 0) {
      gameIsOver = true;
    }
  }

  public void checkPieceIsOver() {
    // If right below is a filled square, it's over
    for (int y = piece.y; y < (piece.y + piece.block.yLen); y++) {
      if (y < 0) {
        continue;
      }
      for (int x = piece.x; x < (piece.x + piece.block.xLen); x++) {
        if (piece.block.isFilled(y - piece.y, x - piece.x)) {
          if (((y + 1) == grid.h) || (grid.isFilled(y + 1, x))) {
            pieceIsOver = true;
            return;
          }
        }
      }
    }
  }

}


