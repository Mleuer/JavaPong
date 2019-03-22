package main.Models;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Game implements ActionListener {

    private Ball ball = new Ball(300,200,20,20);
    private Paddle leftTeamPaddle = new Paddle();
    private Paddle rightTeamPaddle = new Paddle();
    private Dimension size = new Dimension(600, 400);
    private int leftTeamScore = 0;
    private int rightTeamScore = 0;

    public List<Shape> getGamePieces(){
        return Arrays.asList(this.ball, this.leftTeamPaddle, this.rightTeamPaddle);
    }
    public Dimension getSize() {
        return size;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
    }

    public void score() {
        if (ball.x > size.width) {
            leftTeamScore += 1;
        }
        if (ball.x > size.width) {
            rightTeamScore += 1;
        }
    }
    
    public void play() {
        
    }
}
