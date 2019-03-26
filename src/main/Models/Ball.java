package main.Models;

import main.Utility.Direction;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Ball extends Ellipse2D.Double {

    public double velocityX = 2;
    public double velocityY = 2;

    public Ball(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    public void move() {
        this.x += this.velocityX;
        this.y += this.velocityY;
        System.out.println("Ball's position is " + this.x + ',' + this.y);
    }
    
    public void reflectVelocity(){
        velocityX = -velocityX;
        velocityY = -velocityY;
    }
    










}

