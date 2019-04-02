package test.Models;

import Utility.Orientation;
import main.Models.Ball;
import org.junit.Test;
import org.junit.Assert;


public class BallTest {

    @Test
    public void MoveShouldMoveFourToTheRightAndFourDown(){

    }
    
    @Test
    public void ReflectVelocityShouldReflectYVelocityWhenBallHitsTopOrBottom(){
        var ball = new Ball(30,30,20,20, 2, 6);
        ball.velocityX = 2;
        ball.velocityY = 6;
        
        ball.reflectVelocity(Orientation.Horizontal);
        
        Assert.assertEquals(-6, ball.velocityY, 0.11);
        Assert.assertEquals(2, ball.velocityX, 0.11);
    }
    
    @Test
    public void ReflectVelocityShouldReflectXVelocityWhenBallHitsAPaddle() {
        var ball = new Ball(30,30,20,20, 2, 6);
        ball.velocityX = 2;
        ball.velocityY = 6;

        ball.reflectVelocity(Orientation.Vertical);

        Assert.assertEquals(-2, ball.velocityX, 0.11); 
        Assert.assertEquals(6, ball.velocityY, 0.11); 
    }
}
