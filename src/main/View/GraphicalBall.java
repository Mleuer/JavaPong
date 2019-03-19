package main.View;

import main.Models.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GraphicalBall extends JPanel {

    private int ballSpriteWidth = 8;
    private int ballSpriteHeight = 8;
    private Ball ball = new Ball();

    public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            graphics.setColor(Color.cyan);
            graphics.fillRect(ball.position.x, ball.position.y, ballSpriteWidth, ballSpriteHeight);
    }
}
