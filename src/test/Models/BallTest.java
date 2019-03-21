package test.Models;

import main.Models.Ball;
import main.Utility.Direction;
import org.junit.Test;
import org.junit.Assert;


public class BallTest {

    @Test
    public void MoveShouldMoveFourToTheRightAndFourDown(){

        var ball = new Ball(3, 7, 20, 20);

        ball.move(new Direction(4, 4));

        Assert.assertEquals(ball.x, 7, 0.0);
        Assert.assertEquals(ball.y, 11, 0.0);
    }
}
