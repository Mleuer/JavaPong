package main.View;

import main.Models.Paddle;

import javax.swing.*;
import java.awt.*;

public class GraphicalPaddle extends JPanel {

    private int paddleHeight = 40;
    private int paddleWidth = 5;
    private Paddle paddle = new Paddle();

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.CYAN);
        graphics.fillRect(paddle.position.x, paddle.position.y, paddleWidth, paddleHeight);
    }


}
