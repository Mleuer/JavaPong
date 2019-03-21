package test.Models;

import main.Models.Ball;
import main.Utility.Direction;
import org.junit.Test;
import org.junit.Assert;


public class BallTest {

    @Test
    public void MoveShouldMoveFourToTheRightAndFourDown(){

        var ball = new Ball();
        ball.setPosition(3, 7);

        ball.move(new Direction(4, 4));

        Assert.assertEquals(ball.x, 7);
        Assert.assertEquals(ball.y, 11);
    }
}
