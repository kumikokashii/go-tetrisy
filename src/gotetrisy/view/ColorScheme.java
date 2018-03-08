
package gotetrisy.view;

import gotetrisy.model.BlockName;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;


// Reference: https://www.rapidtables.com/web/color/RGB_Color.html


public enum ColorScheme {
  DEFAULT(defaultFillMap(), defaultBrightMap(), defaultDarkMap(), defaultBackgroundColor(), defaultLineColor()),
  PASTEL(pastelFillMap(), pastelBrightMap(), pastelDarkMap(), pastelBackgroundColor(), pastelLineColor()),
  MONO(monoFillMap(), monoBrightMap(), monoDarkMap(), monoBackgroundColor(), monoLineColor());

  private Map<BlockName, Color> fillColorMap;
  private Map<BlockName, Color> brightColorMap;
  private Map<BlockName, Color> darkColorMap;
  private Color backgroundColor;
  private Color lineColor;

  private ColorScheme(Map<BlockName, Color> fillColorMap,
                      Map<BlockName, Color> brightColorMap,
                      Map<BlockName, Color> darkColorMap,
                      Color backgroundColor,
                      Color lineColor) {
    this.fillColorMap = fillColorMap; 
    this.brightColorMap = brightColorMap; 
    this.darkColorMap = darkColorMap;
    this.backgroundColor = backgroundColor;
    this.lineColor = lineColor;
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

  public Color getBackgroundColor() {
    return backgroundColor;
  }

  public Color getLineColor() {
    return lineColor;
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
    map.put(BlockName.WALL, new Color((float) 0.25, (float) 0.25, (float) 0.25));  // Black
    return map;
  }

  private static Map<BlockName, Color> pastelFillMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0.5, (float) 1, (float) 1));  // Light blue
    map.put(BlockName.L, new Color((float) 1, (float) 0.8, (float) 0.6));  // Orange
    map.put(BlockName.FLIP_L, new Color((float) 0.6, (float) 0.6, (float) 1));  // Blue
    map.put(BlockName.BOX, new Color((float) 1, (float) 1, (float) 0.5));  // Yellow
    map.put(BlockName.S, new Color((float) 0.5, (float) 1, (float) 0.5));  // Bright green
    map.put(BlockName.Z, new Color((float) 1, (float) 0.6, (float) 0.6));  // Red
    map.put(BlockName.T, new Color((float) 0.8, (float) 0.6, (float) 1));  // Purple
    map.put(BlockName.WALL, new Color((float) 0.625, (float) 0.625, (float) 0.625));  // Black
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
    map.put(BlockName.WALL, new Color((float) 1, (float) 0.6, (float) 0.6));  // Red
    return map;
  }

  private static Map<BlockName, Color> defaultBrightMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0.4, (float) 1, (float) 1));  // Light blue
    map.put(BlockName.L, new Color((float) 1, (float) 0.7, (float) 0.4));  // Orange
    map.put(BlockName.FLIP_L, new Color((float) 0.4, (float) 0.4, (float) 1));  // Blue
    map.put(BlockName.BOX, new Color((float) 1, (float) 1, (float) 0.4));  // Yellow
    map.put(BlockName.S, new Color((float) 0.4, (float) 1, (float) 0.4));  // Bright green
    map.put(BlockName.Z, new Color((float) 1, (float) 0.4, (float) 0.4));  // Red
    map.put(BlockName.T, new Color((float) 0.7, (float) 0.4, (float) 1));  // Purple
    map.put(BlockName.WALL, new Color((float) 0.375, (float) 0.375, (float) 0.375));  // Black
    return map;
  }

  private static Map<BlockName, Color> pastelBrightMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0.7, (float) 1, (float) 1));  // Light blue
    map.put(BlockName.L, new Color((float) 1, (float) 0.9, (float) 0.8));  // Orange
    map.put(BlockName.FLIP_L, new Color((float) 0.8, (float) 0.8, (float) 1));  // Blue
    map.put(BlockName.BOX, new Color((float) 1, (float) 1, (float) 0.7));  // Yellow
    map.put(BlockName.S, new Color((float) 0.7, (float) 1, (float) 0.7));  // Bright green
    map.put(BlockName.Z, new Color((float) 1, (float) 0.8, (float) 0.8));  // Red
    map.put(BlockName.T, new Color((float) 0.9, (float) 0.8, (float) 1));  // Purple
    map.put(BlockName.WALL, new Color((float) 0.75, (float) 0.75, (float) 0.75));  // Black
    return map;
  }

  private static Map<BlockName, Color> monoBrightMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0.25, (float) 0.25, (float) 0.25));
    map.put(BlockName.L, new Color((float) 0.375, (float) 0.375, (float) 0.375));
    map.put(BlockName.FLIP_L, new Color((float) 0.5, (float) 0.5, (float) 0.5));
    map.put(BlockName.BOX, new Color((float) 0.625, (float) 0.625, (float) 0.625));
    map.put(BlockName.S, new Color((float) 0.75, (float) 0.75, (float) 0.75));
    map.put(BlockName.Z, new Color((float) 0.875, (float) 0.875, (float) 0.875));
    map.put(BlockName.T, new Color((float) 1, (float) 1, (float) 1));
    map.put(BlockName.WALL, new Color((float) 1, (float) 0.8, (float) 0.8));  // Red
    return map;
  }

  private static Map<BlockName, Color> defaultDarkMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0, (float) 0.6, (float) 0.6));  // Light blue
    map.put(BlockName.L, new Color((float) 0.6, (float) 0.3, (float) 0));  // Orange
    map.put(BlockName.FLIP_L, new Color((float) 0, (float) 0, (float) 0.6));  // Blue
    map.put(BlockName.BOX, new Color((float) 0.6, (float) 0.6, (float) 0));  // Yellow
    map.put(BlockName.S, new Color((float) 0, (float) 0.6, (float) 0));  // Bright green
    map.put(BlockName.Z, new Color((float) 0.6, (float) 0, (float) 0));  // Red
    map.put(BlockName.T, new Color((float) 0.3, (float) 0, (float) 0.6));  // Purple
    map.put(BlockName.WALL, new Color((float) 0.125, (float) 0.125, (float) 0.125));  // Black
    return map;
  }

  private static Map<BlockName, Color> pastelDarkMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0.3, (float) 1, (float) 1));  // Light blue
    map.put(BlockName.L, new Color((float) 1, (float) 0.7, (float) 0.4));  // Orange
    map.put(BlockName.FLIP_L, new Color((float) 0.4, (float) 0.4, (float) 1));  // Blue
    map.put(BlockName.BOX, new Color((float) 1, (float) 1, (float) 0.3));  // Yellow
    map.put(BlockName.S, new Color((float) 0.3, (float) 1, (float) 0.3));  // Bright green
    map.put(BlockName.Z, new Color((float) 1, (float) 0.4, (float) 0.4));  // Red
    map.put(BlockName.T, new Color((float) 0.7, (float) 0.4, (float) 1));  // Purple
    map.put(BlockName.WALL, new Color((float) 0.5, (float) 0.5, (float) 0.5));  // Black
    return map;
  }

  private static Map<BlockName, Color> monoDarkMap() {
    Map<BlockName, Color> map = new HashMap<>();
    map.put(BlockName.BAR, new Color((float) 0, (float) 0, (float) 0));
    map.put(BlockName.L, new Color((float) 0.125, (float) 0.125, (float) 0.125));
    map.put(BlockName.FLIP_L, new Color((float) 0.25, (float) 0.25, (float) 0.25));
    map.put(BlockName.BOX, new Color((float) 0.375, (float) 0.375, (float) 0.375));
    map.put(BlockName.S, new Color((float) 0.5, (float) 0.5, (float) 0.5));
    map.put(BlockName.Z, new Color((float) 0.625, (float) 0.625, (float) 0.625));
    map.put(BlockName.T, new Color((float) 0.75, (float) 0.75, (float) 0.75));
    map.put(BlockName.WALL, new Color((float) 1, (float) 0.4, (float) 0.4));  // Red
    return map;
  }

  private static Color defaultBackgroundColor() {
    return new Color((float) 0, (float) 0, (float) 0);
  }

  private static Color pastelBackgroundColor() {
    return new Color((float) 0.375, (float) 0.375, (float) 0.375);
  }

  private static Color monoBackgroundColor() {
    return new Color((float) 1, (float) 0, (float) 0.5);
  }

  private static Color defaultLineColor() {
    return new Color((float) 0, (float) 0.5, (float) 1);
  }

  private static Color pastelLineColor() {
    return new Color((float) 0.6, (float) 0.8, (float) 1);
  }

  private static Color monoLineColor() {
    return new Color((float) 1, (float) 0.6, (float) 0.8);
  }

}
