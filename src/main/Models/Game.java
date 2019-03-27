package main.Models;

import Utility.Orientation;
import main.View.Window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Game implements ActionListener {

    public Window window;
    public Ball ball;
    public Paddle leftTeamPaddle;
    public Paddle rightTeamPaddle;
    private Dimension size = new Dimension(1280, 720);
    private int leftTeamScore = 0;
    private int rightTeamScore = 0;
    private boolean running;

    public List<Shape> getDrawables(){
        return Arrays.asList(this.ball, this.leftTeamPaddle, this.rightTeamPaddle);
    }
    public Dimension getSize() {
        return size;
    }

    public Game(){
        double ballSize = size.width * .05;
        ball = new Ball(size.width / 2, size.height / 2, ballSize, ballSize);
        double paddleHeight = size.height / 3;
        double paddleWidth = size.width / 60;
        leftTeamPaddle = new Paddle(0,(size.height - paddleHeight) / 2, paddleWidth, paddleHeight);
        rightTeamPaddle = new Paddle(size.width - paddleWidth,(size.height - paddleHeight) / 2, paddleWidth, paddleHeight);
        window = new Window(getDrawables(), size);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {}
   
    private void play() {
        running = true;
        try {
            while (running) {
                update();
                Thread.sleep(128);
            }
        } catch (InterruptedException exception) {
            System.exit(1);
        }
    }
    
    public void start(){
        Thread thread = new Thread(this::play);
        thread.start();
        window.display();
    }
    
    public void update(){
        ball.move();
        checkForCollision();
        checkIfPlayerScored();
        chooseWinner();
    }
    
    public void checkIfPlayerScored() {
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
            running = false;
        }
        if (rightTeamScore >= 7) {
            System.out.println("Right Team Wins");
            running = false;
        }
    }
    public void checkForCollision(){
        if (ball.intersects(leftTeamPaddle) || ball.intersects(rightTeamPaddle)) {
            ball.reflectVelocity(Orientation.Vertical);
        }
        if (ball.y <= 0 || ball.y + ball.height >= size.height) {
            ball.reflectVelocity(Orientation.Horizontal);
        }
    }

    
}
