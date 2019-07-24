package main.Models;

import main.Utility.Direction;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Paddle extends Rectangle2D.Double implements Serializable {

    public Paddle(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    
    public void setPosition(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }
    public void moveUp(){
        setPosition(x, y - 30);
        System.out.println("Paddle position is " + this.x + ", " + this.y);
    }
    public void moveDown(){
        setPosition(x, y + 30);
        System.out.println("Paddle position is " + this.x + ", " + this.y);
    }

    public void serialize(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(this);
    }

    public static Paddle deserialize(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        var paddle = (Paddle) inputStream.readObject();
        return paddle;
    }
}
