package test.Models;

import main.IO.InputController;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.mockito.Mockito.mock;

public class InputControllerTest {

    public static class ExampleAction {

        public static boolean didSomething = false;

        public static void doSomething(){
            didSomething = true;
        }
    }

    @Test
    public void RegisterForKeyEventShouldPerformActionWhenCorrespondingKeyIsPressed() { 
        var inputController = new InputController();
        var mockComponent = mock(Component.class);
        KeyEvent spaceBarIsPressed = new KeyEvent(mockComponent, 0, System.currentTimeMillis() + 10, 0, InputController.KeyPressType.Space.keyCode);
        Runnable action = ExampleAction::doSomething;
        
        inputController.registerForKeyEvent(InputController.KeyPressType.Space, action);
        inputController.keyPressed(spaceBarIsPressed);

        Assert.assertTrue(ExampleAction.didSomething);
    }

}
