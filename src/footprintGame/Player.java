package footprintGame;

import engine.Buffer;
import engine.ControllableEntity;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(GamePad gamePad) {
        super(gamePad);
        teleport(200, 200);
        setDimension(20, 60);
        setSpeed(3);
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }

    public void update() {
        moveWithController();
    }

    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.WHITE);
    }
}
