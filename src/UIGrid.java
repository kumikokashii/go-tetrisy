
import java.awt.*;
import javax.swing.*;


public class UIGrid extends JPanel {

  public static void main(String [] args) {
    Manager m = new Manager(20, 10);
    m.setupNewPiece();
    m.dropPiece();
    m.updateGrid();
    System.out.println(m.getGrid());

    JFrame window = new JFrame("Go Tetrisy");
    JPanel uiGrid = new UIGrid(30, m.getGrid());
    window.setContentPane(uiGrid);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(500, 650);
    window.setVisible(true);
  }

  private final int h;
  private final int w;
  private final int side;
  private final Grid grid;

  public UIGrid(int side, Grid grid) {
    this.h = grid.h;
    this.w = grid.w;
    this.side = side;
    this.grid = grid;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawGridLines(g);
    drawBlocks(g);
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
}
