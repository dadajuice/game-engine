package tankGame;

import engine.Buffer;
import engine.Game;

import java.util.ArrayList;

public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;
    private ArrayList<Missile> missiles;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        if (gamePad.isFirePressed() && tank.canFire()) {
            missiles.add(tank.fire());
        }
        tank.update();
        for (Missile missile : missiles) {
            missile.update();
        }
    }

    @Override
    protected void drawOnBuffer(Buffer buffer) {
        tank.draw(buffer);
        for (Missile missile : missiles) {
            missile.draw(buffer);
        }
    }
}
