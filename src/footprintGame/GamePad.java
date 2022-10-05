package footprintGame;

import engine.MovementController;

import java.awt.event.KeyEvent;

public class GamePad extends MovementController {

    private int quitKey = KeyEvent.VK_Q;

    public GamePad() {
        bindKey(quitKey);
    }

    public void useWasdKeys() {
        setUpKey(KeyEvent.VK_W);
        setDownKey(KeyEvent.VK_S);
        setLeftKey(KeyEvent.VK_A);
        setRightKey(KeyEvent.VK_D);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }
}
