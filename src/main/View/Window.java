package main.View;

import main.Models.Ball;
import main.Models.Paddle;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Window extends JPanel {

    private GraphicalBall ball = new GraphicalBall();
    private GraphicalPaddle paddle = new GraphicalPaddle();

    // create the GUI explicitly on the Swing event thread
    public void display() {

        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(ball);
        frame.getContentPane().add(paddle);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }



}
