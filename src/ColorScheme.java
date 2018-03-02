
import java.util.*;
import java.awt.Color;


public enum ColorScheme {
  DEFAULT(defaultFillMap(), defaultBrightMap(), defaultDarkMap()),
  PASTEL(pastelFillMap(), pastelBrightMap(), pastelDarkMap()),
  MONO(monoFillMap(), monoBrightMap(), monoDarkMap());

  private Map<BlockName, Color> fillColorMap;
  private Map<BlockName, Color> brightColorMap;
  private Map<BlockName, Color> darkColorMap;

  private ColorScheme(Map<BlockName, Color> fillColorMap,
                      Map<BlockName, Color> brightColorMap,
                      Map<BlockName, Color> darkColorMap) {
    this.fillColorMap = fillColorMap; 
    this.brightColorMap = brightColorMap; 
    this.darkColorMap = darkColorMap; 
  }

  public Color getFillColor(BlockName blockName) {
    return fillColorMap.get(blockName);
  }

  public Color getBrightColor(BlockName blockName) {
    return brightColorMap.get(blockName);
  }

  public Color getDarkColor(BlockName blockName) {
    return darkColorMap.get(blockName);
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

  private static Map<BlockName, Color> defaultBrightMap() {
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

  private static Map<BlockName, Color> pastelBrightMap() {
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

  private static Map<BlockName, Color> monoBrightMap() {
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

  private static Map<BlockName, Color> defaultDarkMap() {
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

  private static Map<BlockName, Color> pastelDarkMap() {
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

  private static Map<BlockName, Color> monoDarkMap() {
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
