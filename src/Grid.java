
import java.util.*;


public class Grid extends ArrayList<ArrayList<Integer>> {
  public final int h;
  public final int w;

  public Grid(int h, int w) {
    super();
    this.h = h;
    this.w = w;

    List<Integer> row = getEmptyRow();
    for (int y = 0; y < h; y++) {
      add(new ArrayList<Integer>(row));
    }
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

  public void fill(int y, int x) {
    get(y).set(x, 1);
  }

  public boolean rowIsFilled(int y) {
    for (int value : get(y)) {
      if (value == 0) {
        return false;
      }
    }
    return true;
  }

  public List<Integer> getRowsToRemove(int startY, int endY) {
    List<Integer> rowsToRemove = new ArrayList<Integer>();
    for (int y = startY; y < endY; y++) {
      if (rowIsFilled(y)) {
        rowsToRemove.add(y);
      }
    }
    return rowsToRemove;
  }

  public void removeRows(int startY, int endY) {
    List<Integer> rowsToRemove = getRowsToRemove(startY, endY);
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


