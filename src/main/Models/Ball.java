package main.Models;

import main.Utility.Direction;

import java.awt.*;


public class Ball {

    private Dimension size = new Dimension(20, 20);
    private Point position = new Point(640, 360);

    public void move(Direction direction){
        this.position.x += direction.value.x;
        this.position.y += direction.value.y;
    }

    public void setPosition(int x, int y){
        this.position.x = x;
        this.position.y = y;
    }
    public Point getPosition(){
        return this.position;
    }

    public void setSize(int width, int height){
        this.size.width = width;
        this.size.height = height;
    }
    public Dimension getSize(){
        return this.size;
    }





}

