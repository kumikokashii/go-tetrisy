
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UIGrid extends JPanel {

  public static void main(String [] args) {
    Manager m = new Manager(20, 10);
    m.setupNewPiece();
    m.dropPiece();
    m.updateGrid();
    System.out.println(m.getGrid());

    Controller controller = new Controller(m);
    JFrame window = new JFrame("Go Tetrisy");
    UIGrid uiGrid = new UIGrid(30, m, controller);
    controller.setUIGrid(uiGrid);
    controller.bringInNewPiece();

    window.setContentPane(uiGrid);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(500, 650);
    window.setVisible(true);

  }

  private final int h;
  private final int w;
  private final int side;
  private final Manager m;
  private Grid grid;
  private Piece piece;
  private final Controller controller;

  public void setPiece() {
    this.piece = m.getPiece();
  }

  public class uiGridKeyListener implements KeyListener {

    public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();

      // Shift
      if (key == KeyEvent.VK_LEFT) {
        controller.shiftLeftAttempt();
      }
      else if (key == KeyEvent.VK_RIGHT) {
        controller.shiftRightAttempt();
      }
      else if (key == KeyEvent.VK_DOWN) {
        controller.shiftDownAttempt();
      }

      // Rotate
      else if (key == KeyEvent.VK_Z) {
        controller.rotateLeftAttempt();
      }
      else if (key == KeyEvent.VK_X) {
        controller.rotateRightAttempt();
      }

      // Drop
      else if (key == KeyEvent.VK_SPACE) {
        controller.dropAttempt();
      }

      // Pause
      else if (key == KeyEvent.VK_P) {
        controller.pause();
      }

      else {}
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
  }

  public UIGrid(int side, Manager m, Controller controller) {
    this.m = m;
    this.grid = m.getGrid();
    this.h = grid.h;
    this.w = grid.w;
    this.side = side;
    this.controller = controller;
    this.piece = piece;

    addKeyListener(new uiGridKeyListener());
    setFocusable(true);
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
}
