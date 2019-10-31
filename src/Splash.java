package src;

import src.utils.*;

import javax.swing.*;
import java.awt.*;


public class Splash extends JPanel {  
  public void paintComponent(Graphics g) {
    g.setColor(Constants.SPLASH_OR_QUIT_BACKGROUND_COLOR);
    g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

    g.setColor(Constants.SPLASH_OR_QUIT_FONT_COLOR);
    Draw.drawCenteredString(g, "SNAKE", new Rectangle(0, Constants.SCREEN_OFFSET, Constants.BOARD_WIDTH, 60), Constants.TITLE_FONT);

    Draw.drawCenteredString(g, "User: j656li", new Rectangle(0, Constants.SCREEN_OFFSET + 80, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "Arrow keys: Control the snake around the board and collect the apples to grow.", new Rectangle(0, Constants.SCREEN_OFFSET + 120, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "P: Pause/Un-Pause the game", new Rectangle(0, Constants.SCREEN_OFFSET + 160, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "R: Reset to the splash screen", new Rectangle(0, Constants.SCREEN_OFFSET + 200, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "1: Start level 1", new Rectangle(0, Constants.SCREEN_OFFSET + 240, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "2: Start level 2", new Rectangle(0, Constants.SCREEN_OFFSET + 280, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "3: Start level 3", new Rectangle(0, Constants.SCREEN_OFFSET + 320, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
    
    Draw.drawCenteredString(g, "Q: Quit and show the high score", new Rectangle(0, Constants.SCREEN_OFFSET + 360, Constants.BOARD_WIDTH, 30), Constants.BODY_FONT);
  }
}
