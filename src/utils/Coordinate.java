package src.utils;

import java.util.Random;

public class Coordinate {
  public int x;
  public int y;

  public Coordinate(int a, int b) {
    x = a;
    y = b;
  }

  public Boolean isEqual(Coordinate c) {
    return (x == c.x && y == c.y);
  }

  public void iterateSelf() {
    Random r = new Random();
    x = r.nextInt(Constants.BOARD_WIDTH / Constants.SNAKE_SEGMENT_SIZE) * Constants.SNAKE_SEGMENT_SIZE;
    y = r.nextInt(Constants.BOARD_HEIGHT / Constants.SNAKE_SEGMENT_SIZE - 1) * Constants.SNAKE_SEGMENT_SIZE;
  }
}
