package src.utils;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Constants {
  public static final Color SPLASH_OR_QUIT_BACKGROUND_COLOR = Color.getHSBColor(76/360f, 68/360f, 72/360f);
  public static final Color SPLASH_OR_QUIT_FONT_COLOR = Color.getHSBColor(82/360f, 60/360f, 140/360f);
  public static final Color SNAKE_BODY_COLOR = Color.getHSBColor(100/360f, 36/360f, 88/360f);

  public static final Font SCORE_FONT = new Font("Comic Sans MS", Font.BOLD, 30);
  public static final Font TITLE_FONT = new Font("Comic Sans MS", Font.BOLD, 40);
  public static final Font BODY_FONT = new Font("Comic Sans MS", Font.BOLD, 20);

  public static final String SPLASH = "SPLASH";
  public static final String OVER = "OVER";
  public static final String IN_GAME = "IN_GAME";
  public static final String PAUSED = "PAUSED";

  public static final int SCREEN_WIDTH = 1280;  
  public static final int SCREEN_HEIGHT = 700;
  public static final int SCREEN_OFFSET = 100;

  public static final int SCORE_BOARD_HEIGHT = 100;

  public static final int BOARD_WIDTH = 1280; 
  public static final int BOARD_HEIGHT = 600;

  public static final int SNAKE_SEGMENT_SIZE = 40;
  public static final int ICON_SIZE = 70;

  public static final Map<Integer, Integer> SNAKE_SPEED = new HashMap<Integer, Integer>() {{
    put(KeyEvent.VK_1, 400);
    put(KeyEvent.VK_2, 200);
    put(KeyEvent.VK_3, 100);
  }};

  // NOTE: all coordinates below have to be bounded within BOARD_WIDTH, BOARD_HEIGHT && divisible by SNAKE_SEGMENT_SIZE
  // mark the position of snake head
  public static final int SNAKE_INIT_Y = 200;
  public static final int SNAKE_INIT_X = 320;
  public static final int SNAKE_INIT_SIZE = 3;

  public static final ArrayList<Coordinate> levelOneFruit = new ArrayList<Coordinate>(
    List.of(
      new Coordinate(40, 80),
      new Coordinate(1000, 400),
      new Coordinate(80, 320),
      new Coordinate(720, 120),
      new Coordinate(800, 160)
    )
  );
  public static final ArrayList<Coordinate> levelTwoFruit = new ArrayList<Coordinate>(
    List.of(
      new Coordinate(40, 80),
      new Coordinate(1000, 400),
      new Coordinate(80, 320),
      new Coordinate(720, 120),
      new Coordinate(800, 160),
      new Coordinate(200, 400),
      new Coordinate(1200, 240),
      new Coordinate(800, 120),
      new Coordinate(600, 40),
      new Coordinate(80, 280)
    )
  );
  public static final ArrayList<Coordinate> levelThreeFruit = new ArrayList<Coordinate>(
    List.of(
      new Coordinate(40, 80),
      new Coordinate(1000, 400),
      new Coordinate(80, 320),
      new Coordinate(720, 120),
      new Coordinate(800, 160),
      new Coordinate(200, 400),
      new Coordinate(1200, 240),
      new Coordinate(800, 120),
      new Coordinate(600, 40),
      new Coordinate(80, 280),
      new Coordinate(1200, 40),
      new Coordinate(1240, 600),
      new Coordinate(360, 360),
      new Coordinate(440, 400),
      new Coordinate(40, 440)
    )
  );
}
