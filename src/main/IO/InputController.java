package main.IO;

import java.awt.event.*;
import java.util.EventListener;
import java.util.HashMap;

public class InputController implements KeyListener, MouseListener {
    
    public HashMap<MouseButtonType, Runnable> mouseEventRegistry = new HashMap<>();
    public HashMap<KeyPressType, Runnable> keyPressRegistry = new HashMap<>();
    
    
    public void registerForMouseEvent(MouseButtonType button, Runnable action) {
        mouseEventRegistry.put(button, action);
    }
    public void registerForKeyEvent(KeyPressType key, Runnable action) {
       keyPressRegistry.put(key, action);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        for (keyActionPair:
//             keyPressRegistry){
//
//        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    public enum MouseButtonType {
        ButtonOne(1),
        ButtonTwo(2);
        
        int ID;
        MouseButtonType(int i) {
            ID = i;
        }
    }
    public enum KeyPressType {
        W('w'),
        A('a'),
        S('s'),
        D('d');
        
        char ID;
        KeyPressType(char i) {
            ID = i;
        }
    }
}
