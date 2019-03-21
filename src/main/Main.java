package main;

import main.View.Window;

import javax.swing.JFrame;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

            Window window = new Window();
            JFrame frame = new JFrame("Pong");
            frame.add(window);
            frame.setVisible(true);
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
