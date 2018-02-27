
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UIGrid extends JPanel {
  public static int DEFAULT_SIDE = 30;

  private int side;
  private Manager mngr;
  private Grid grid;
  private int h;
  private int w;
  private Piece piece;
  private Controller cntr;

  public UIGrid() {
    side = DEFAULT_SIDE;

    addKeyListener(new uiGridKeyListener());
    setFocusable(true);
  }

  public void setManager(Manager mngr) {
    this.mngr = mngr;
    grid = mngr.getGrid();
    h = grid.h;
    w = grid.w;
    piece = mngr.getPiece();
  }

  public void setController(Controller cntr) {
    this.cntr = cntr;
  }

  public void setPiece() {
    piece = mngr.getPiece();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawGridLines(g);
    drawBlocks(g);
    if (piece != null) {
      drawPiece(g);
    }
  }

  public void drawGridLines(Graphics g) {
    g.setColor(Color.PINK);

    // Horizontal lines
    for (int y = 0; y < (h + 1); y++) {
      g.drawLine(0, y * side, w * side, y * side);
    }

    // Vertical lines
    for (int x = 0; x < (w + 1); x++) {
      g.drawLine(x * side, 0, x * side, h * side);
    }
  }

  public void drawBlocks(Graphics g) {
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (grid.isFilled(y, x)) {
          g.fillRect(x * side, y * side, side, side);
        }
      }
    }
  }

  public void drawPiece(Graphics g) {
    g.setColor(Color.BLUE);

    for (int y = piece.y; y < (piece.y + piece.block.yLen); y++) {
      if (y < 0) {
        continue;
      }
      for (int x = piece.x; x < (piece.x + piece.block.xLen); x++) {
        if (piece.block.isFilled(y - piece.y, x - piece.x)) {
          g.fillRect(x * side, y * side, side, side);
        }
      }
    }
  }

  public class uiGridKeyListener implements KeyListener {

    public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();

      // Shift
      if (key == KeyEvent.VK_LEFT) {
        cntr.shiftLeftAttempt();
      }
      else if (key == KeyEvent.VK_RIGHT) {
        cntr.shiftRightAttempt();
      }
      else if (key == KeyEvent.VK_DOWN) {
        cntr.shiftDownAttempt();
      }

      // Rotate
      else if (key == KeyEvent.VK_Z) {
        cntr.rotateLeftAttempt();
      }
      else if (key == KeyEvent.VK_X) {
        cntr.rotateRightAttempt();
      }

      // Drop
      else if (key == KeyEvent.VK_SPACE) {
        cntr.dropAttempt();
      }

      // Pause
      else if (key == KeyEvent.VK_P) {
        cntr.pause();
      }

      else {}
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
  }

}
