package main.Models;

import java.awt.*;

public class Paddle {

    public Point position = new Point();




    public void setPosition(int x, int y){
        this.position.x = x;
        this.position.y = y;
    }

    public Point getPosition(){
        return this.position;
    }
}
