
import java.util.*;


public class Grid extends ArrayList<ArrayList<Integer>> {
  public static void main(String[] args) {
    Grid g = testGrid();
    System.out.println(g);
    g.setPiece(Piece.T_3);
    g.update(5);
    g.setPiece(Piece.BOX);
    g.update(5);
    System.out.println(g);
  }

  public void update(int leftX) {
    addPiece(leftX);
    removeRows();
    addRows();
  }

  public static Grid testGrid() {
    Grid g = new Grid(5, 10);
    for (int y = 0; y < 5; y++) {
      for (int x = 0; x < 10; x++) {
        if (x == 1) {g.get(y).set(x, 0);}
        else {g.get(y).set(x, 0);}
      }
    }
    return g;
  }

  private final int h;
  private final int w;

  private Piece piece;  // Currently falling piece
  private int beforeTop;  // Specific to when adding piece
  private int nowTop;  // Specific to when adding piece

  public Grid(int h, int w) {
    super();
    this.h = h;
    this.w = w;

    List<Integer> row = getEmptyRow();
    for (int y = 0; y < h; y++) {
      add(new ArrayList<Integer>(row));
    }
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public String toString() {
    String s = "";
    for (ArrayList row: this) {
      s += String.format("%s%n", row);
    }
    return s;
  }

  public List<Integer> getEmptyRow() {
    List<Integer> row = new ArrayList<Integer>();
    for (int x = 0; x < w; x++) {
      row.add(0);
    }
    return row;
  }

  public boolean isFilled(int y, int x) {
    int value = get(y).get(x);
    return (value == 1);
  }

  public int getTopFilled(int leftX) {
    // Find highest filled y across width of piece
    for (int y = 0; y < h; y++) {
      for (int x = leftX; x < (leftX + piece.xLen); x++) {
        if (isFilled(y, x)) {
          return y;
        } 
      }
    }
    return h;
  }

  public void fill(int y, int x) {
    get(y).set(x, 1);
  }

  public void addPiece(int leftX) {
    beforeTop = getTopFilled(leftX);
    nowTop = beforeTop - piece.yLen;

    if (nowTop <= 0) {
      System.out.println("Game Over");
      return;
    }

    for (int y = nowTop; y < beforeTop; y++) {
      for (int x = leftX; x < (leftX + piece.xLen); x++) {
        if (piece.isFilled(y - nowTop, x - leftX)) {
          fill(y, x);
        }
      }
    }
  }

  public boolean rowIsFilled(int y) {
    for (int value : get(y)) {
      if (value == 0) {
        return false;
      }
    }
    return true;
  }

  public List<Integer> getRowsToRemove() {
    List<Integer> rowsToRemove = new ArrayList<Integer>();
    for (int y = nowTop; y < beforeTop; y++) {
      if (rowIsFilled(y)) {
        rowsToRemove.add(y);
      }
    }
    return rowsToRemove;
  }

  public void removeRows() {
    List<Integer> rowsToRemove = getRowsToRemove();
    Collections.sort(rowsToRemove, Collections.reverseOrder());
    for (int y : rowsToRemove) {
      remove(y);
    }
  }

  public void addRows() {
    int n = h - this.size();
    List<Integer> row = getEmptyRow();
    for (int i = 0; i < n; i++) {
      add(0, new ArrayList<Integer>(row));
    }
  }

}


