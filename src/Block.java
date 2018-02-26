
import java.util.*;


public enum Block {
  BAR_0(barShape_0()),
  BAR_1(barShape_1()),
  L_0(lShape_0()),
  L_1(lShape_1()),
  L_2(lShape_2()),
  L_3(lShape_3()),
  FLIP_L_0(flipLShape_0()),
  FLIP_L_1(flipLShape_1()),
  FLIP_L_2(flipLShape_2()),
  FLIP_L_3(flipLShape_3()),
  BOX(boxShape()),
  S_0(sShape_0()),
  S_1(sShape_1()),
  Z_0(zShape_0()),
  Z_1(zShape_1()),
  T_0(tShape_0()),
  T_1(tShape_1()),
  T_2(tShape_2()),
  T_3(tShape_3());

  private static Map<Block, Block> rightRotated = initRightRotated();
  private static Map<Block, Block> leftRotated = initLeftRotated();

  private static Map<Block, Block> initRightRotated() {
    Map<Block, Block> rightRotated = new HashMap<Block, Block>();
    rightRotated.put(BAR_0, BAR_1);
    rightRotated.put(BAR_1, BAR_0);
    rightRotated.put(L_0, L_1);
    rightRotated.put(L_1, L_2);
    rightRotated.put(L_2, L_3);
    rightRotated.put(L_3, L_0);
    rightRotated.put(FLIP_L_0, FLIP_L_1);
    rightRotated.put(FLIP_L_1, FLIP_L_2);
    rightRotated.put(FLIP_L_2, FLIP_L_3);
    rightRotated.put(FLIP_L_3, FLIP_L_0);
    rightRotated.put(BOX, BOX);
    rightRotated.put(S_0, S_1);
    rightRotated.put(S_1, S_0);
    rightRotated.put(Z_0, Z_1);
    rightRotated.put(Z_1, Z_0);
    rightRotated.put(T_0, T_1);
    rightRotated.put(T_1, T_2);
    rightRotated.put(T_2, T_3);
    rightRotated.put(T_3, T_0);
    return rightRotated;
  }

  private static Map<Block, Block> initLeftRotated() {
    Map<Block, Block> leftRotated = new HashMap<Block, Block>();
    for (Map.Entry<Block, Block> entry : rightRotated.entrySet()) {
      leftRotated.put(entry.getValue(), entry.getKey());
    }
    return leftRotated;
  }

  public final List<List<Integer>> shape;
  public final int yLen;
  public final int xLen;

  private Block(List<List<Integer>> shape) {
    this.shape = shape;
    this.yLen = shape.size();
    this.xLen = shape.get(0).size();
  }

  public Block getRightRotated(Block piece) {
    return rightRotated.get(piece);
  }

  public Block getLeftRotated(Block piece) {
    return leftRotated.get(piece);
  }

  public boolean isFilled(int y, int x) {
    int value = shape.get(y).get(x);
    return (value == 1);
  }

  public String toString() {
    String s = "";
    for (List row: this.shape) {
      s += String.format("%s%n", row);
    }
    return s;
  }

  private static List<List<Integer>> barShape_0() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1)));
    return shape;
  }

  private static List<List<Integer>> barShape_1() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)));
    return shape;
  }

  private static List<List<Integer>> lShape_0() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static List<List<Integer>> lShape_1() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0)));
    return shape;
  }

  private static List<List<Integer>> lShape_2() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    return shape;
  }

  private static List<List<Integer>> lShape_3() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
    return shape;
  }

  private static List<List<Integer>> flipLShape_0() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static List<List<Integer>> flipLShape_1() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
    return shape;
  }

  private static List<List<Integer>> flipLShape_2() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    return shape;
  }

  private static List<List<Integer>> flipLShape_3() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1)));
    return shape;
  }

  private static List<List<Integer>> boxShape() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    return shape;
  }

  private static List<List<Integer>> sShape_0() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0)));
    return shape;
  }

  private static List<List<Integer>> sShape_1() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    return shape;
  }

  private static List<List<Integer>> zShape_0() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
    return shape;
  }

  private static List<List<Integer>> zShape_1() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    return shape;
  }

  private static List<List<Integer>> tShape_0() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));
    return shape;
  }

  private static List<List<Integer>> tShape_1() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
    return shape;
  }

  private static List<List<Integer>> tShape_2() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
    return shape;
  }

  private static List<List<Integer>> tShape_3() {
    List<List<Integer>> shape = new ArrayList<List<Integer>>();
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
    shape.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
    return shape;
  }

}
