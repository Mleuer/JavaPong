package main;

import main.Models.Game;
import main.View.Window;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

           var game = new Game();
           game.start();
    }

}
