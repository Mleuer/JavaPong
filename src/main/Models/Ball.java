package main.Models;

import main.Utility.Direction;

import java.awt.*;


public class Ball {

    public Dimension size = new Dimension(4, 4);
    public Point position = new Point();

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

}
