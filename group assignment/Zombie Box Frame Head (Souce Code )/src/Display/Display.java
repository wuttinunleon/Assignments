package Display;

import Game.GameEngine;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import sun.awt.WindowClosingListener;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;

public class Display {

    public static int width=1280;
    public static int height=720;

    public static final String NAME = "FRAME IDIOT";

    private static JFrame window;
    private  static Canvas canvas;

    private static JFrame window2;
    private static JPanel panel;
    private static int count=0;


    public static void createWindow(int width,int height) {


        window = new JFrame(NAME);
        window.setSize(width, height);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setFocusable(true);
        canvas = new Canvas();
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setPreferredSize(new Dimension(width, height));

        window.add(canvas);
        window.pack();

    }










    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getWindow() {
        return window;
    }
}

