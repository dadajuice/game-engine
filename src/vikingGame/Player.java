package vikingGame;

import engine.Buffer;
import engine.ControllableEntity;
import engine.MovementController;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(MovementController controller) {
        super(controller);
        setDimension(32, 32);
        setSpeed(3);
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.RED);
    }

    @Override
    public void update() {
        super.update();
        moveWithController();
    }
}
