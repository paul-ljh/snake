package src.utils;

import java.awt.*;

// NOTE: third-party code from https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
public class Draw {
  public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
    // Get the FontMetrics
    FontMetrics metrics = g.getFontMetrics(font);

    // Determine the X coordinate for the text
    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;

    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
    
    // Set the font
    g.setFont(font);
    
    // Draw the String
    g.drawString(text, x, y);
} 
}
