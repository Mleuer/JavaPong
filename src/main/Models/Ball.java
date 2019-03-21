package main.Models;

import main.Utility.Direction;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Ball extends Ellipse2D.Double {

    public double x = 20;
    public double y = 20;
    public double width = 20;
    public double height = 20;
    public double velocityX = 2;
    public double velocityY = 2;

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

