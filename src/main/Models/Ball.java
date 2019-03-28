package main.Models;

import Utility.Orientation;
import main.Utility.Utility;

import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Ball extends Ellipse2D.Double {

    public double velocityX = 8;
    public double velocityY = 8;

    public Ball(double x, double y, double w, double h) {
        super(x, y, w, h);
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
    










}

