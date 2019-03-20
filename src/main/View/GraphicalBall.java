package main.View;

import main.Models.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GraphicalBall extends JPanel {

    private Ball ball = new Ball();
    private int ballSpriteWidth = ball.getSize().width;
    private int ballSpriteHeight = ball.getSize().height;

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.cyan);
        graphics.fillRect(ball.getPosition().x, ball.getPosition().y, ballSpriteWidth, ballSpriteHeight);
    }
}
