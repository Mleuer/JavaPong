package test.Models;

import main.Models.Ball;
import main.Models.Game;
import main.Models.Paddle;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.List;

public class GameTest {

    @Test
    public void CheckForCollisionShouldReverseBallVelocityXIfBallAndPaddleOverlap(){
        Game game = new Game();
        game.ball.setPosition(30,30);
        game.ball.setSize(60,60);
        game.ball.velocityX = 5;
        game.rightTeamPaddle.setPosition(90,90);
        game.rightTeamPaddle.setSize(60,60);
        
        game.checkForCollision();

        Assert.assertEquals(game.ball.velocityX = -6, game.ball.velocityX, 0.0);
    }
}
