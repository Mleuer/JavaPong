package main.View;

import main.Models.Ball;
import main.Models.Paddle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JPanel implements ActionListener {

    Timer timer = new Timer(5, this);

    private Ball ball = new Ball();
    private Paddle paddle = new Paddle();



    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.BLACK);
        graphics2D.fill(this.ball);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ball.x < 0 || ball.x > 580 ) {
            ball.velocityX = -ball.velocityX;
        }
        if (ball.y < 0 || ball.y > 380 ) {
            ball.velocityY = -ball.velocityY;
        }

        ball.x += ball.velocityX;
        ball.y += ball.velocityY;
        repaint();
    }

//    public void display() {
//
//        JFrame frame = new JFrame("Pong");
//        frame.add(this);
//        frame.setVisible(true);
//        frame.setSize(600, 400);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
}
