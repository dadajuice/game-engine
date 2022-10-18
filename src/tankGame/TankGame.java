package tankGame;

import engine.Buffer;
import engine.Game;

public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        tank.update();
    }

    @Override
    protected void drawOnBuffer(Buffer buffer) {
        tank.draw(buffer);
    }
}
