package main.View;

import main.Models.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.*;

public class Window extends JPanel implements ActionListener {
    
    private List<Shape> drawables;
    private Dimension size;
    private final JFrame frame = new JFrame("Pong");
    private final Timer timer = new Timer(32, this);

    public Window(List<Shape> drawables, Dimension size, KeyListener inputController) {
        this.drawables = drawables;
        this.size = size;
        frame.add(this);
        frame.setSize(this.size.width, this.size.height + (int)(this.size.height * 0.10));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addKeyListener(inputController);
        timer.start();
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
    
    public void reset() {
        frame.setVisible(false);
        frame.dispose();
    }
    
    public void display() {
        frame.setVisible(true);
////        try {
////            while (true) {
////                Thread.sleep(32);
////                repaint();
////            }
//        } catch (InterruptedException exception) {
//            System.exit(1);
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}