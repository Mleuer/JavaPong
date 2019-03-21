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

    public void move(Direction direction){
        this.x += direction.value.x;
        this.y += direction.value.y;
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

