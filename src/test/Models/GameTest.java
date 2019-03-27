package test.Models;

import Utility.Orientation;
import main.Models.Ball;
import main.Models.Game;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    public class MockBall extends Ball {

        public boolean reflectVelocityWasCalled = false;

        public MockBall(double x, double y, double w, double h) {
            super(x, y, w, h);
        }
        @Override
        public void reflectVelocity(Orientation surfaceOrientation){
            reflectVelocityWasCalled = true;
        }
    }
    
    @Test
    public void CheckForCollisionShouldReflectBallVelocity(){
        Game game = new Game();
        var ball = new MockBall(60,60,61,61);
        game.ball = ball;
        game.ball.velocityX = 5;
        game.rightTeamPaddle.setPosition(90,90);
        game.rightTeamPaddle.setSize(60,60);
        
        game.checkForCollision();

        Assert.assertTrue(ball.reflectVelocityWasCalled);
        
       

        
    }
}
