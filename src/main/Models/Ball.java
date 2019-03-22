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
        if (this.x < 0 || this.x > 580) {
            this.velocityX = -this.velocityX;
        }
        if (this.y < 0 || this.y > 380) {
            this.velocityY = -this.velocityY;
        }

        this.x += this.velocityX;
        this.y += this.velocityY;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }









}

