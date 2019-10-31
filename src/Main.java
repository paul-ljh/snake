package src;

import src.utils.*;

import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Snake");

    frame.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Board board = new Board();
    frame.setContentPane(board);

    frame.setVisible(true);
  }
}
