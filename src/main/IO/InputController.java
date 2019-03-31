package main.IO;

import java.awt.event.*;
import java.util.Arrays;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Optional;

public class InputController implements KeyListener {
    
    private HashMap<KeyPressType, Runnable> keyPressRegistry = new HashMap<>();
    
    public void registerForKeyEvent(KeyPressType key, Runnable action) {
       
        keyPressRegistry.put(key, action);
    }
    
    @Override
    public void keyTyped(KeyEvent event) {
        boolean t = true;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Optional<KeyPressType> possibleKeyPressType = KeyPressType.valueOf(event.getKeyCode());
        if (possibleKeyPressType.isPresent()) { 
            KeyPressType keyPressType = possibleKeyPressType.get();
            Runnable runnable = keyPressRegistry.get(keyPressType);
            if (runnable != null) {
                runnable.run();
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent event) {
        boolean t = true;
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
        W(0x57),
        S(0x53),
        Space(0x20),
        Up(0x26),
        Down(0x28);
       
        public int keyCode; 
        
        KeyPressType(int keyCode) {
           this.keyCode = keyCode;
        }
        
        public static Optional<KeyPressType> valueOf(int value) {
            return Arrays.stream(values())
                    .filter(keyPressType -> keyPressType.keyCode == value)
                    .findFirst();
        }
    }
}
