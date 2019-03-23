package main.View;

import main.Models.Ball;
import main.Models.Game;
import main.Models.Paddle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JPanel {

    private Game newGame = new Game();

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.RED);

        for (Shape shape : newGame.getGamePieces()) {
            graphics2D.fill(shape);
        }
    }

    public void display() {
        JFrame frame = new JFrame("Pong");
        frame.add(this);
        frame.setVisible(true);
        frame.setSize(newGame.getSize().width, newGame.getSize().height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            while (true) {
                Thread.sleep(32);
                repaint();
            }
        } catch (InterruptedException exception) {
            System.exit(1);
        }
    }
}