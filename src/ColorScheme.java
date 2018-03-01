
import java.util.*;
import java.awt.Color;


public enum ColorScheme {
  DEFAULT(defaultMap());
  //PASTEL(),
  //MONO();

  private Map<BlockName, Color> blockNameToColor;

  private ColorScheme(Map<BlockName, Color> blockNameToColor) {
    this.blockNameToColor = blockNameToColor; 
  }

  public Color getColor(BlockName blockName) {
    return blockNameToColor.get(blockName);
  }

  private static Map<BlockName, Color> defaultMap() {
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
}
