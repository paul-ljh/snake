package src;

import src.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Fruit extends JComponent {
  public static final Image APPLE = FileService.loadAndScale("src/assets/apple.png", Constants.SNAKE_SEGMENT_SIZE, Constants.SNAKE_SEGMENT_SIZE).getImage();

  public ArrayList<Coordinate> progress;
  
  // KeyEvent.VK_1
  // KeyEvent.VK_2
  // KeyEvent.VK_3
  private int level;

  public Fruit(int level) {
    this.level = level;
    progress = this.currentLevelFruits();
  }

  public ArrayList<Coordinate> currentLevelFruits() {
    if (this.level == KeyEvent.VK_1) {
      return Constants.levelOneFruit;
    } else if (this.level == KeyEvent.VK_2) {
      return Constants.levelTwoFruit;
    } else {
      return Constants.levelThreeFruit;
    }
  }

  public void replaceFruit(int index) {
    progress.get(index).iterateSelf();
  }

  public void paintComponent(Graphics g) {
    for (Coordinate fruit : progress) {
      g.drawImage(APPLE, fruit.x, Constants.SCREEN_OFFSET + fruit.y, this);
    }
  }
}
