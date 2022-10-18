package tankGame;

import engine.Buffer;
import engine.ControllableEntity;
import engine.MovementController;

import java.awt.*;

public class Tank extends ControllableEntity {

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(2);
        teleport(100, 100);
    }

    @Override
    public void update() {
        moveWithController();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.GREEN);
    }
}
