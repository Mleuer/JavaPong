package main.Models;

import main.Utility.Orientation;
import main.Utility.Utility;

import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Ball extends Ellipse2D.Double implements Serializable {

    public double velocityX;
    public double velocityY;

    public Ball(double x, double y, double w, double h, double velocityX, double velocityY) {
        super(x, y, w, h);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void move() {
        this.x += this.velocityX;
        this.y += this.velocityY;
        System.out.println("Ball's position is " + this.x + ',' + this.y);
        System.out.println("Ball's velocity is " + this.velocityX + ',' + this.velocityY);
    }
    
    public void reflectVelocity(Orientation surfaceOrientation){
        if (surfaceOrientation == Orientation.Vertical) {
            velocityX = -velocityX + Utility.randomNumberInASetRange(-0.10,0.10);
            velocityY += Utility.randomNumberInASetRange(-0.10,0.10);
        }
        if (surfaceOrientation == Orientation.Horizontal) {
            velocityY = -velocityY;
        }
    }

    public void serialize(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(this);
    }

    public static Ball deserialize(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        var ball = (Ball) inputStream.readObject();
        return ball;
    }
}

