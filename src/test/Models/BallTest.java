package test.Models;

import main.Models.Ball;
import main.Models.Paddle;
import main.Utility.Direction;
import org.junit.Test;
import org.junit.Assert;


public class BallTest {

    @Test
    public void MoveShouldMoveFourToTheRightAndFourDown(){

    }
    
    @Test
    public void ReflectVelocityShouldChangePositiveVelocityToNegative(){
        var ball = new Ball(30,30,20,20);
        ball.velocityX = 2;
        ball.velocityY = 6;
        
        ball.reflectVelocity();
        
        Assert.assertEquals(-2, ball.velocityX, 0.0);
        Assert.assertEquals(-6, ball.velocityY, 0.0);
    }
    
    
}
