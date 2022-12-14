package tankGame;

import engine.Buffer;
import engine.CollidableRepository;
import engine.ControllableEntity;
import engine.MovementController;

import java.awt.*;

public class Tank extends ControllableEntity {

    private int cooldown = 0;

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(2);
        teleport(100, 100);
    }

    public Missile fire() {
        cooldown = 50;
        return new Missile(this);
    }

    public boolean canFire() {
        return cooldown == 0;
    }

    @Override
    public void update() {
        super.update();
        moveWithController();
        cooldown--;
        if (cooldown < 0) {
            cooldown = 0;
        }
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.GREEN);
        if (hasMoved()) {
            drawHitBox(buffer);
        }
    }
}
