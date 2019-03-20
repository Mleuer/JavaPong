package main;

import main.View.GraphicalBall;
import main.View.Window;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window window = new Window();
                window.display();
            }
        });



    }
}
