
import java.awt.*;
import javax.swing.*;


public class UIGrid extends JPanel {
  public static int DEFAULT_SIDE = 30;

  private ColorScheme colorScheme;
  private int side;
  private Manager mngr;
  private Grid grid;
  private int h;
  private int w;
  private Piece piece;

  public UIGrid() {
    colorScheme = ColorScheme.MONO;
    side = DEFAULT_SIDE;
  }

  public void setManager(Manager mngr) {
    this.mngr = mngr;
    grid = mngr.getGrid();
    h = grid.h;
    w = grid.w;
  }

  public void setPiece() {
    piece = mngr.getPiece();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawGridLines(g);
    drawBlocks(g);
    setPiece();
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
          g.setColor(colorScheme.getColor(grid.getBlockName(y, x)));
          g.fillRect(x * side, y * side, side, side);
        }
      }
    }
  }

  public void drawPiece(Graphics g) {
    g.setColor(colorScheme.getColor(piece.getBlockName()));

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
