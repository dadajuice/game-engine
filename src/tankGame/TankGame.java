package tankGame;

import engine.Buffer;
import engine.CollidableRepository;
import engine.Game;
import engine.StaticEntity;

import java.util.ArrayList;

public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;
    private ArrayList<Missile> missiles;
    private ArrayList<Brick> bricks;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
        bricks = new ArrayList<>();
        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(500, 116));
        bricks.add(new Brick(500, 132));
        bricks.add(new Brick(484, 148));
        bricks.add(new Brick(500, 164));
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

        ArrayList<StaticEntity> killedElements = new ArrayList<>();
        for (Missile missile : missiles) {
            missile.update();
            for (Brick brick : bricks) {
                if (missile.hitBoxIntersectWith(brick)) {
                    killedElements.add(brick);
                    killedElements.add(missile);
                }
            }
        }

        for (StaticEntity entity : killedElements) {
            if (entity instanceof Brick) {
                bricks.remove(entity);
            } else if (entity instanceof Missile) {
                missiles.remove(entity);
            }
            CollidableRepository.getInstance().unregisterEntity(entity);
        }
    }

    @Override
    protected void drawOnBuffer(Buffer buffer) {
        tank.draw(buffer);
        for (Missile missile : missiles) {
            missile.draw(buffer);
        }
        for (Brick brick : bricks) {
            brick.draw(buffer);
        }
    }
}
