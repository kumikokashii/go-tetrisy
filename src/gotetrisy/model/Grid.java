
package gotetrisy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Grid extends ArrayList<ArrayList<BlockName>> {
  public final int h;
  public final int w;

  public Grid(int h, int w) {
    super();
    this.h = h;
    this.w = w;

    List<BlockName> row = getEmptyRow();
    for (int y = 0; y < h; y++) {
      add(new ArrayList<BlockName>(row));
    }
  }

  public BlockName getBlockName(int y, int x) {
    return get(y).get(x);
  }

  public String toString() {
    String s = "";
    for (ArrayList row: this) {
      s += String.format("%s%n", row);
    }
    return s;
  }

  public List<BlockName> getEmptyRow() {
    List<BlockName> row = new ArrayList<>();
    for (int x = 0; x < w; x++) {
      row.add(null);
    }
    return row;
  }

  public boolean isFilled(int y, int x) {
    BlockName blockName = get(y).get(x);
    return (blockName != null);
  }

  public void fill(int y, int x, BlockName blockName) {
    get(y).set(x, blockName);
  }

  public boolean rowIsFilled(int y) {
    for (BlockName blockName : get(y)) {
      if (blockName == null) {
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
    List<BlockName> row = getEmptyRow();
    for (int i = 0; i < n; i++) {
      add(0, new ArrayList<BlockName>(row));
    }
  }

}


