package main.Models;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Game implements ActionListener {

    public Ball ball = new Ball(300,200,20,20);
    public Paddle leftTeamPaddle = new Paddle(0,150,20,100);
    public Paddle rightTeamPaddle = new Paddle(580,150,20,100);
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


    public void play() {
        score();
        chooseWinner();
    }
    public void changeTrajectory(){
        if (this.ball.intersects(this.rightTeamPaddle)){
            ball.velocityX = -ball.velocityX;
        }
        if (this.ball.intersects(this.leftTeamPaddle)){
            ball.velocityX = -ball.velocityX;
        }
    }
    
    public void score() {
        if (ball.x > size.width) {
            leftTeamScore += 1;
        }
        if (ball.x > size.width) {
            rightTeamScore += 1;
        }
    }
    public void chooseWinner(){
        if (leftTeamScore >= 7) {
            System.out.println("Left Team Wins");
        }
        if (rightTeamScore >= 7) {
            System.out.println("Right Team Wins");
        }
    }
}
