package src;

import src.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Snake extends JComponent {
  public static final Image SNAKEHEAD = FileService.loadAndScale("src/assets/snakehead.png", Constants.SNAKE_SEGMENT_SIZE, Constants.SNAKE_SEGMENT_SIZE).getImage();

  // Stores the relative position, transform to absolute positions when drawing
  private ArrayList<Coordinate> snakeBody;
  
  // 0: VK_LEFT	37
  // 1: VK_UP	38
  // 2: VK_RIGHT 39
  // 3: VK_DOWN	40
  private int direction;
  
  public Snake() {
    this.snakeBody = new ArrayList<Coordinate>();
    this.direction = 2;

    Coordinate c;
    for (int i = 0; i < Constants.SNAKE_INIT_SIZE; i++) {
      c = new Coordinate(Constants.SNAKE_INIT_X - (i * Constants.SNAKE_SEGMENT_SIZE), Constants.SNAKE_INIT_Y);
      snakeBody.add(c);
    }
  }

  public void grow() {
    Coordinate lastSegment = this.snakeBody.get(this.snakeBody.size() - 1);
    Coordinate newSegment;
    switch (this.direction) {
      case 0:
        newSegment = new Coordinate(lastSegment.x + Constants.SNAKE_SEGMENT_SIZE, lastSegment.y);
      case 1:
        newSegment = new Coordinate(lastSegment.x, lastSegment.y + Constants.SNAKE_SEGMENT_SIZE);
      case 2:
        newSegment = new Coordinate(lastSegment.x - Constants.SNAKE_SEGMENT_SIZE, lastSegment.y);
      default:
        newSegment = new Coordinate(lastSegment.x, lastSegment.y - Constants.SNAKE_SEGMENT_SIZE);
    }
    this.snakeBody.add(newSegment);
  }

  public void control(int key) {
    switch (key) {
      case KeyEvent.VK_LEFT:
        if (this.direction != 2) this.direction = 0;
        break;
      case KeyEvent.VK_UP:
        if (this.direction != 3) this.direction = 1;
        break;
      case KeyEvent.VK_RIGHT:
        if (this.direction != 0) this.direction = 2;
        break;
      case KeyEvent.VK_DOWN:
        if (this.direction != 1) this.direction = 3;
        break;
    }
  }

  public void move() {
    for (int i = this.snakeBody.size() - 1; i > 0; i--) {
      this.snakeBody.get(i).x = this.snakeBody.get(i-1).x;
      this.snakeBody.get(i).y = this.snakeBody.get(i-1).y; 
    }

    switch (this.direction) {
      case 0:
        this.snakeBody.get(0).x -= Constants.SNAKE_SEGMENT_SIZE;
        break;
      case 1:
        this.snakeBody.get(0).y -= Constants.SNAKE_SEGMENT_SIZE;
        break;
      case 2:
        this.snakeBody.get(0).x += Constants.SNAKE_SEGMENT_SIZE;
        break;
      case 3:
        this.snakeBody.get(0).y += Constants.SNAKE_SEGMENT_SIZE;
        break;
    }
  }

  public Boolean checkSelfCollision() {
    Coordinate head = this.snakeBody.get(0);
    for (int i = 1; i < this.snakeBody.size(); i++) {
      if (head.isEqual(this.snakeBody.get(i))) {
        return true;
      }
    }
    return false;
  }

  public Boolean checkBorderCollision() {
    Coordinate head = this.snakeBody.get(0);
    return (head.y >= Constants.BOARD_HEIGHT || head.y < 0 || head.x >= Constants.BOARD_WIDTH || head.x < 0);
  }

  // -1 if no collision, index of collided fruit otherwise
  public int checkFruitCollision(ArrayList<Coordinate> fruits) {
    for (Coordinate segment : this.snakeBody) {
      for (Coordinate fruit : fruits) {
        if (segment.isEqual(fruit)) return fruits.indexOf(fruit);
      }
    }
    return -1;
  }
  
  public void paintComponent(Graphics g) {
    for (int i = 0; i < snakeBody.size(); i++) {
      if (i == 0) {
        g.drawImage(SNAKEHEAD, snakeBody.get(i).x, Constants.SCREEN_OFFSET + snakeBody.get(i).y, this);
      } else {
        g.setColor(Constants.SNAKE_BODY_COLOR);
        g.fillOval(snakeBody.get(i).x, Constants.SCREEN_OFFSET + snakeBody.get(i).y, Constants.SNAKE_SEGMENT_SIZE, Constants.SNAKE_SEGMENT_SIZE);
      }
    }
  }
}
