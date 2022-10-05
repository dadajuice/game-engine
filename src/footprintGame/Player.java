package footprintGame;

import engine.Buffer;
import engine.MovableEntity;

import java.awt.*;

public class Player extends MovableEntity {

    private GamePad gamePad;

    public Player(GamePad gamePad) {
        this.gamePad = gamePad;
        teleport(200, 200);
        setDimension(20, 60);
        setSpeed(3);
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }

    public void update() {
        if (gamePad.isDownPressed()) {
            moveDown();
        } else if (gamePad.isUpPressed()) {
            moveUp();
        } else if (gamePad.isLeftPressed()) {
            moveLeft();
        } else if (gamePad.isRightPressed()) {
            moveRight();
        }
    }

    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.WHITE);
    }
}
