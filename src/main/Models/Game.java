package main.Models;

import Utility.Orientation;
import main.IO.InputController;
import main.View.Window;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Game {
    public Window window;
    public InputController inputController = new InputController();
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
        initializeGameObjects();
        window = new Window(getDrawables(), size, inputController);
        setupPlayerInput();
    }

    private void initializeGameObjects() {
        double ballSize = size.width * .05;
        ball = new Ball(size.width / 2, size.height / 2, ballSize, ballSize);
        double paddleHeight = size.height / 3;
        double paddleWidth = size.width / 120;
        leftTeamPaddle = new Paddle(0,(size.height - paddleHeight) / 2, paddleWidth, paddleHeight);
        rightTeamPaddle = new Paddle(size.width - paddleWidth,(size.height - paddleHeight) / 2, paddleWidth, paddleHeight);
    }

    private void setupPlayerInput() {
        inputController.registerForKeyEvent(InputController.KeyPressType.W, leftTeamPaddle::moveUp);
        inputController.registerForKeyEvent(InputController.KeyPressType.S, leftTeamPaddle::moveDown);
        inputController.registerForKeyEvent(InputController.KeyPressType.Up, rightTeamPaddle::moveUp);
        inputController.registerForKeyEvent(InputController.KeyPressType.Down, rightTeamPaddle::moveDown);
    }
    
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
        var gameThread = new Thread(this::play);
        gameThread.start();
        window.display();
    }
    
    public void update(){
        ball.move();
        checkForCollision();
        boolean playerScored = updatePlayerScores();
        if (playerScored) {
           reset();
        }
        updatePlayerScores();
        chooseWinner();
    }
    
    public void reset() {
        initializeGameObjects();
    }
    
    public boolean updatePlayerScores() {
        boolean playerScored = false;
        
        if (ball.x > size.width) {
            leftTeamScore += 1;
            playerScored = true;
        }
        else if (ball.x < 0) {
            rightTeamScore += 1;
            playerScored = true;
        }
        return playerScored;
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
