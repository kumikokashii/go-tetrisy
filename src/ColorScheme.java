
import java.util.*;
import java.awt.Color;


public enum ColorScheme {
  DEFAULT(defaultFillMap()),
  PASTEL(pastelFillMap()),
  MONO(monoFillMap());

  private Map<BlockName, Color> blockNameToColor;

  private ColorScheme(Map<BlockName, Color> blockNameToColor) {
    this.blockNameToColor = blockNameToColor; 
  }

  public Color getColor(BlockName blockName) {
    return blockNameToColor.get(blockName);
  }

  private static Map<BlockName, Color> defaultFillMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0, (float) 1, (float) 1));  // Light blue
    map.put(BlockName.L, new Color((float) 1, (float) 0.5, (float) 0));  // Orange
    map.put(BlockName.FLIP_L, new Color((float) 0, (float) 0, (float) 1));  // Blue
    map.put(BlockName.BOX, new Color((float) 1, (float) 1, (float) 0));  // Yellow
    map.put(BlockName.S, new Color((float) 0, (float) 1, (float) 0));  // Bright green
    map.put(BlockName.Z, new Color((float) 1, (float) 0, (float) 0));  // Red
    map.put(BlockName.T, new Color((float) 0.5, (float) 0, (float) 1));  // Purple
    return map;
  }

  private static Map<BlockName, Color> pastelFillMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0.6, (float) 1, (float) 1));  // Light blue
    map.put(BlockName.L, new Color((float) 1, (float) 0.8, (float) 0.6));  // Orange
    map.put(BlockName.FLIP_L, new Color((float) 0.6, (float) 0.6, (float) 1));  // Blue
    map.put(BlockName.BOX, new Color((float) 1, (float) 1, (float) 0.6));  // Yellow
    map.put(BlockName.S, new Color((float) 0.6, (float) 1, (float) 0.6));  // Bright green
    map.put(BlockName.Z, new Color((float) 1, (float) 0.6, (float) 0.6));  // Red
    map.put(BlockName.T, new Color((float) 0.8, (float) 0.6, (float) 1));  // Purple
    return map;
  }

  private static Map<BlockName, Color> monoFillMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0.125, (float) 0.125, (float) 0.125));
    map.put(BlockName.L, new Color((float) 0.25, (float) 0.25, (float) 0.25));
    map.put(BlockName.FLIP_L, new Color((float) 0.375, (float) 0.375, (float) 0.375));
    map.put(BlockName.BOX, new Color((float) 0.5, (float) 0.5, (float) 0.5));
    map.put(BlockName.S, new Color((float) 0.625, (float) 0.625, (float) 0.625));
    map.put(BlockName.Z, new Color((float) 0.75, (float) 0.75, (float) 0.75));
    map.put(BlockName.T, new Color((float) 0.875, (float) 0.875, (float) 0.875));
    return map;
  }

}
