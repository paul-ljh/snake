package src;

import src.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements KeyListener {
  private String gameState;
  private int score = 0;
  private int time;
  private int key;
  private int level;
  
  private Splash splash = new Splash();
  private Snake snake = new Snake();
  private Quit quit = new Quit();
  private Fruit fruit;
  private Timer snakeTimer;
  private Timer gameTimer;

  public static final Image BACKGROUND = FileService.loadAndScale("src/assets/soil.jpg", Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT).getImage();

  public static final Image SCORE = FileService.loadAndScale("src/assets/score.jpg", Constants.ICON_SIZE, Constants.ICON_SIZE).getImage();

  public static final Image TIMER = FileService.loadAndScale("src/assets/timer.jpg", Constants.ICON_SIZE, Constants.ICON_SIZE).getImage();

  public static final Image TROPHY = FileService.loadAndScale("src/assets/trophy.png", Constants.ICON_SIZE, Constants.ICON_SIZE).getImage();

  public Board() {
    addKeyListener(this);
    this.gameState = Constants.SPLASH;
  }

  public void keyPressed(KeyEvent e) {
    key = e.getKeyCode();

    // user can switch levels at any stage of game
    if (key == KeyEvent.VK_1 || key == KeyEvent.VK_2 || key == KeyEvent.VK_3) {
      this.level = key;
      // reset game only when it is currently at splash or over
      this.gameOn(this.gameState == Constants.SPLASH || this.gameState == Constants.OVER);
    }

    // user can reset the game anytime except at splash
    else if (this.gameState != Constants.SPLASH && key == KeyEvent.VK_R) {
      this.gameState = Constants.SPLASH;
      this.snakeTimer.stop();
      this.gameTimer.stop();
      repaint();
    }

    // direction keys only work when user is in game
    else if (this.gameState == Constants.IN_GAME && (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)) {
      this.snake.control(key);
    }

    // pause key only works when it is in game or paused
    else if ((this.gameState == Constants.IN_GAME || this.gameState == Constants.PAUSED) && key == KeyEvent.VK_P) {
      this.pauseOrResumeGame();
    }

    // can quit game anytime except splash
    else if (this.gameState != Constants.SPLASH && key == KeyEvent.VK_Q) {
      this.gameState = Constants.OVER;
      repaint();
    }
  }

  private void initTimer() {
    if (this.gameTimer != null) {
      this.gameTimer.stop();
      this.gameTimer = null;
    }
    if (this.snakeTimer != null) {
      this.snakeTimer.stop();
      this.snakeTimer = null;
    }

    ActionListener gamePerformer = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        --time;
      // no level up for level 3
        if (level != KeyEvent.VK_3 && time == 0) {
          levelUp();
          gameOn(false); // preseve game state when level up
        }
        repaint();
      }
    };
    // repaint 25 times per second, therefore refresh every 40 msecs
    this.gameTimer = new Timer(40, gamePerformer);

    ActionListener snakePerformer = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        snake.move();
        int collisionResult = snake.checkFruitCollision(fruit.progress);
        if (collisionResult != -1) {
          fruit.replaceFruit(collisionResult);
          snake.grow();
          ++score;
        }
        if (snake.checkBorderCollision() || snake.checkSelfCollision()) {
          gameState = Constants.OVER;
          snakeTimer.stop();
        }
      }
    };
    this.snakeTimer = new Timer(Constants.SNAKE_SPEED.get(this.level), snakePerformer);
  }

  private void levelUp() {
    if (level == KeyEvent.VK_1 || level == KeyEvent.VK_2) ++level;
  }

  private void gameOn(Boolean reset) {
    this.gameState = Constants.IN_GAME;
    this.time = 750;
    this.fruit = new Fruit(this.level);
    this.initTimer();

    if (reset) {
      this.snake = new Snake(); // if reset, create new snake
      this.score = 0;
    }
    this.gameTimer.start();
    this.snakeTimer.start();

    repaint();
  }

  private void pauseOrResumeGame() {
    if (this.gameState == Constants.IN_GAME) {
      this.gameState = Constants.PAUSED;
      this.gameTimer.stop();
      this.snakeTimer.stop();
    } else if (this.gameState == Constants.PAUSED) {
      this.gameState = Constants.IN_GAME;
      this.gameTimer.start();
      this.snakeTimer.start();
    }
  }

  public void paintComponent(Graphics g) {
    if (this.gameState == Constants.SPLASH) {      
      this.splash.paintComponent(g);
    }
    else if (this.gameState == Constants.OVER) {
      this.quit.paintComponent(g, this.score);
    }
    else {
      g.setColor(Constants.SPLASH_OR_QUIT_BACKGROUND_COLOR);
      g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCORE_BOARD_HEIGHT);

      g.setColor(Color.BLACK);
      g.setFont(Constants.TITLE_FONT);

      g.drawImage(TROPHY, 50, 15, this);
      g.drawString("" + this.level % 48, 150, 70);

      g.drawImage(SCORE, 300, 15, this);
      g.drawString("" + this.score, 400, 70);

      if (this.level != KeyEvent.VK_3) {
        g.drawImage(TIMER, 500, 15, this);
        g.drawString("" + this.time / 25, 600, 70);
      }

      g.drawImage(BACKGROUND, 0, Constants.SCREEN_OFFSET, this);
      this.snake.paintComponent(g);
      this.fruit.paintComponent(g);
    }
  }

  public void addNotify() {
    super.addNotify();
    requestFocus();
  }

  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {}
}
