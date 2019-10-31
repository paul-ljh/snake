package src;

import src.utils.*;

import javax.swing.*;
import java.awt.*;


public class Quit extends JPanel {  
  public void paintComponent(Graphics g, int score) {
    g.setColor(Constants.SPLASH_OR_QUIT_BACKGROUND_COLOR);
    g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    
    g.setColor(Constants.SPLASH_OR_QUIT_FONT_COLOR);
    Draw.drawCenteredString(g, "GAME OVER!", new Rectangle(0, Constants.SCREEN_OFFSET, Constants.BOARD_WIDTH, 30), Constants.TITLE_FONT);
    Draw.drawCenteredString(g, "Score: " + score, new Rectangle(0, Constants.SCREEN_OFFSET + 80, Constants.BOARD_WIDTH, 30), Constants.TITLE_FONT);

    Draw.drawCenteredString(g, "1 : Start level 1", new Rectangle(0, Constants.SCREEN_OFFSET + 140, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "2 : Start level 2", new Rectangle(0, Constants.SCREEN_OFFSET + 180, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "3 : Start level 3", new Rectangle(0, Constants.SCREEN_OFFSET + 220, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);

    Draw.drawCenteredString(g, "R: Reset to the splash screen", new Rectangle(0, Constants.SCREEN_OFFSET + 260, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
  }
}
