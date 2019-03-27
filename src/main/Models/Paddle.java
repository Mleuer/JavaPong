package main.Models;

import main.Utility.Direction;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Paddle extends Rectangle2D.Double {

    public Paddle(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }
    public void move(){}
}
