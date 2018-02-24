
import java.util.*;


public enum Piece {
  BAR(barShape(), 4, 1),
  L(lShape(), 3, 2),
  FLIP_L(flipLShape(), 3, 2),
  BOX(boxShape(), 2, 2),
  S(sShape(), 2, 3),
  Z(zShape(), 2, 3),
  T(tShape(), 2, 3);

  public final ArrayList<ArrayList<Integer>> shape;
  public final int yLen;
  public final int xLen;

  public boolean isFilled(int y, int x) {
    int value = shape.get(y).get(x);
    return (value == 1);
  }

  private Piece(ArrayList<ArrayList<Integer>> shape, int yLen, int xLen) {
    this.shape = shape;
    this.yLen = yLen;
    this.xLen = xLen;
  }

  private static ArrayList<ArrayList<Integer>> barShape() {
    ArrayList<ArrayList<Integer>> shape = new ArrayList<ArrayList<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    return shape;
  }

  private static ArrayList<ArrayList<Integer>> lShape() {
    ArrayList<ArrayList<Integer>> shape = new ArrayList<ArrayList<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static ArrayList<ArrayList<Integer>> flipLShape() {
    ArrayList<ArrayList<Integer>> shape = new ArrayList<ArrayList<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static ArrayList<ArrayList<Integer>> boxShape() {
    ArrayList<ArrayList<Integer>> shape = new ArrayList<ArrayList<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static ArrayList<ArrayList<Integer>> sShape() {
    ArrayList<ArrayList<Integer>> shape = new ArrayList<ArrayList<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0)));
    return shape;
  }

  private static ArrayList<ArrayList<Integer>> zShape() {
    ArrayList<ArrayList<Integer>> shape = new ArrayList<ArrayList<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
    return shape;
  }

  private static ArrayList<ArrayList<Integer>> tShape() {
    ArrayList<ArrayList<Integer>> shape = new ArrayList<ArrayList<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));
    return shape;
  }

}
