package main.View;

import main.Models.Game;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class Window extends JPanel {
    
    private List<Shape> drawables;
    private Dimension size;

    public Window(List<Shape> drawables, Dimension size) {
        this.drawables = drawables;
        this.size = size;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.RED);

        for (Shape shape : drawables) {
            graphics2D.fill(shape);
        }
    }

    public void display() {
        JFrame frame = new JFrame("Pong");
        frame.add(this);
        frame.setVisible(true);
        frame.setSize(this.size);
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