package src.utils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileService {  
  public static File loadFile(String filePath, Boolean exitOnError) {
    File f = null;
    try {
      f = new File(filePath);
      if (!f.exists()) throw new IOException();
    } catch(Exception e) {
      e.printStackTrace();
      System.out.println("FAILED to load " + filePath);
      if (exitOnError) System.exit(0);
    }
    return f;
  }

  public static ImageIcon loadAndScale(String filePath, int width, int height) {
    loadFile(filePath, true);
    ImageIcon icon = new ImageIcon(filePath);
    // transform to Image class then resize
    Image newImg = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
  }
}
