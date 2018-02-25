
import java.util.*;


public enum Piece {
  BAR(barShape(), 4, 1),
  L(lShape(), 3, 2),
  FLIP_L(flipLShape(), 3, 2),
  BOX(boxShape(), 2, 2),
  S(sShape(), 2, 3),
  Z(zShape(), 2, 3),
  T(tShape(), 2, 3);

  public final List<List<Integer>> shape;
  public final int yLen;
  public final int xLen;

  public boolean isFilled(int y, int x) {
    int value = shape.get(y).get(x);
    return (value == 1);
  }

  private Piece(List<List<Integer>> shape, int yLen, int xLen) {
    this.shape = shape;
    this.yLen = yLen;
    this.xLen = xLen;
  }

  private static List<List<Integer>> barShape() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    return shape;
  }

  private static List<List<Integer>> lShape() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static List<List<Integer>> flipLShape() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static List<List<Integer>> boxShape() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static List<List<Integer>> sShape() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0)));
    return shape;
  }

  private static List<List<Integer>> zShape() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
    return shape;
  }

  private static List<List<Integer>> tShape() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));
    return shape;
  }

}
