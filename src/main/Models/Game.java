package main.Models;

import Utility.Orientation;
import main.IO.InputController;
import main.View.Window;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Game {
    private Window window;
    public InputController inputController = new InputController();
    public Ball ball;
    public Paddle leftTeamPaddle;
    public Paddle rightTeamPaddle;
    private Dimension size = new Dimension(640, 360);
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
        initialize();
    }

    private void initialize() {
        initializeGameObjects();
        window = new Window(getDrawables(), size, inputController);
        setupPlayerInput();
    }
    
    private void initializeGameObjects() {
        double paddleHeight = size.height / 3;
        double paddleWidth = size.width / 60;
        leftTeamPaddle = new Paddle(0,(size.height - paddleHeight) / 2, paddleWidth, paddleHeight);
        rightTeamPaddle = new Paddle(size.width - paddleWidth,(size.height - paddleHeight) / 2, paddleWidth, paddleHeight);
        double ballSize = size.width * .025;
        ball = new Ball(size.width / 2, size.height / 2, ballSize, ballSize, paddleWidth - 1, paddleWidth - 1);
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
           window.reset();
           reset();
           window.display();
        }
        updatePlayerScores();
        chooseWinner();
    }
    
    public void reset() {
        initialize();
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
