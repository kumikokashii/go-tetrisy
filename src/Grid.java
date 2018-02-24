
import java.util.*;


public class Grid extends ArrayList<ArrayList<Integer>> {
  public static void main(String[] args) {
    Grid g = new Grid(5, 10);
    g.get(3).set(0, 1);
    g.get(2).set(5, 1);
    System.out.println(g);

    g.addPiece(Piece.S, 0);  // piece, leftX of the piece
    System.out.println(g);
  }

  private final int h;
  private final int w;

  public String toString() {
    String s = "";
    for (ArrayList row: this) {
      s += String.format("%s%n", row);
    }
    return s;
  }

  public Grid(int h, int w) {
    super();
    this.h = h;
    this.w = w;

    ArrayList<Integer> row = new ArrayList<Integer>();
    for (int x = 0; x < w; x++) {
      row.add(0);
    }

    for (int y = 0; y < h; y++) {
      add(new ArrayList<Integer>(row));
    }
  }

  public boolean isFilled(int y, int x) {
    int value = get(y).get(x);
    return (value == 1);
  }

  public int getTopFilled(Piece piece, int leftX) {
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
    this.get(y).set(x, 1);
  }


  public void addPiece(Piece piece, int leftX) {
    int nowTop = getTopFilled(piece, leftX);
    int newTop = nowTop - piece.yLen;

    if (newTop < 0) {
      System.out.println("Game Over");
      return;
    }

    for (int y = newTop; y < nowTop; y++) {
      for (int x = leftX; x < (leftX + piece.xLen); x++) {
        if (piece.isFilled(y - newTop, x - leftX)) {
          fill(y, x);
        }
      }
    }
  }

}




















