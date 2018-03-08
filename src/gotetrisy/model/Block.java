
package gotetrisy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum Block {
  BAR_0(barShape_0(), BlockName.BAR),
  BAR_1(barShape_1(), BlockName.BAR),
  L_0(lShape_0(), BlockName.L),
  L_1(lShape_1(), BlockName.L),
  L_2(lShape_2(), BlockName.L),
  L_3(lShape_3(), BlockName.L),
  FLIP_L_0(flipLShape_0(), BlockName.FLIP_L),
  FLIP_L_1(flipLShape_1(), BlockName.FLIP_L),
  FLIP_L_2(flipLShape_2(), BlockName.FLIP_L),
  FLIP_L_3(flipLShape_3(), BlockName.FLIP_L),
  BOX(boxShape(), BlockName.BOX),
  S_0(sShape_0(), BlockName.S),
  S_1(sShape_1(), BlockName.S),
  Z_0(zShape_0(), BlockName.Z),
  Z_1(zShape_1(), BlockName.Z),
  T_0(tShape_0(), BlockName.T),
  T_1(tShape_1(), BlockName.T),
  T_2(tShape_2(), BlockName.T),
  T_3(tShape_3(), BlockName.T);

  public List<List<BlockName>> shape;
  public final BlockName name;
  public final int yLen;
  public final int xLen;

  private Block(List<List<Integer>> shapeInt, BlockName blockName) {
    name = blockName;
    yLen = shapeInt.size();
    xLen = shapeInt.get(0).size();
    initShape(shapeInt);
  }

  public void initShape(List<List<Integer>> shapeInt) {
    shape = new ArrayList<>();
    for (int y = 0; y < yLen; y++) {
      List<Integer> rowInt = shapeInt.get(y);
      List<BlockName> row = new ArrayList<>();
      for (int x = 0; x < xLen; x++) {
        if (rowInt.get(x) == 0) {
          row.add(null);
        }
        else {
          row.add(name);
        }
      }
      shape.add(row);
    }
  }

  private static Map<Block, Block> rightRotated = initRightRotated();
  private static Map<Block, Block> leftRotated = initLeftRotated();
  private static Map<Block, Integer> rotateShiftY = initRotateShiftY();
  private static Map<Block, Integer> rotateRightShiftX = initRotateRightShiftX();
  private static Map<Block, Integer> rotateLeftShiftX = initRotateLeftShiftX();

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

  private static Map<Block, Integer> initRotateShiftY() {
    Map<Block, Integer> rotateShiftY = new HashMap<Block, Integer>();
    rotateShiftY.put(BAR_0, 1);
    rotateShiftY.put(BAR_1, -1);
    rotateShiftY.put(L_0, 1);
    rotateShiftY.put(L_1, -1);
    rotateShiftY.put(L_2, 1);
    rotateShiftY.put(L_3, -1);
    rotateShiftY.put(FLIP_L_0, 1);
    rotateShiftY.put(FLIP_L_1, -1);
    rotateShiftY.put(FLIP_L_2, 1);
    rotateShiftY.put(FLIP_L_3, -1);
    rotateShiftY.put(BOX, 0);
    rotateShiftY.put(S_0, -1);
    rotateShiftY.put(S_1, 1);
    rotateShiftY.put(Z_0, -1);
    rotateShiftY.put(Z_1, 1);
    rotateShiftY.put(T_0, -1);
    rotateShiftY.put(T_1, 1);
    rotateShiftY.put(T_2, -1);
    rotateShiftY.put(T_3, 1);
    return rotateShiftY;
  }

  private static Map<Block, Integer> initRotateRightShiftX() {
    Map<Block, Integer> rotateRightShiftX = new HashMap<Block, Integer>();
    rotateRightShiftX.put(BAR_0, -2);
    rotateRightShiftX.put(BAR_1, 2);
    rotateRightShiftX.put(L_0, -1);
    rotateRightShiftX.put(L_1, 0);
    rotateRightShiftX.put(L_2, 0);
    rotateRightShiftX.put(L_3, 1);
    rotateRightShiftX.put(FLIP_L_0, 0);
    rotateRightShiftX.put(FLIP_L_1, 1);
    rotateRightShiftX.put(FLIP_L_2, -1);
    rotateRightShiftX.put(FLIP_L_3, 0);
    rotateRightShiftX.put(BOX, 0);
    rotateRightShiftX.put(S_0, 0);
    rotateRightShiftX.put(S_1, 0);
    rotateRightShiftX.put(Z_0, 1);
    rotateRightShiftX.put(Z_1, -1);
    rotateRightShiftX.put(T_0, 0);
    rotateRightShiftX.put(T_1, 0);
    rotateRightShiftX.put(T_2, 1);
    rotateRightShiftX.put(T_3, -1);
    return rotateRightShiftX;
  }

  private static Map<Block, Integer> initRotateLeftShiftX() {
    Map<Block, Integer> rotateLeftShiftX = new HashMap<Block, Integer>(rotateRightShiftX);
    rotateLeftShiftX.put(T_0, 1);
    rotateLeftShiftX.put(T_1, -1);
    rotateLeftShiftX.put(T_2, 0);
    rotateLeftShiftX.put(T_3, 0);
    return rotateLeftShiftX;
  }

  public Block getRightRotated() {
    return rightRotated.get(this);
  }

  public Block getLeftRotated() {
    return leftRotated.get(this);
  }

  public int getRotateShiftY() {
    return rotateShiftY.get(this);
  }

  public int getRotateRightShiftX() {
    return rotateRightShiftX.get(this);
  }

  public int getRotateLeftShiftX() {
    return rotateLeftShiftX.get(this);
  }

  public boolean isFilled(int y, int x) {
    BlockName blockName = shape.get(y).get(x);
    return (blockName != null);
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
