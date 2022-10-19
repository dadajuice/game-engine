package vikingGame;

import engine.Buffer;
import engine.Game;

public class VikingGame extends Game {

    private GamePad gamePad;
    private Player player;
    private World world;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        world = new World();
        world.load();
        player.teleport(200, 200);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
    }

    @Override
    protected void drawOnBuffer(Buffer buffer) {
        world.draw(buffer);
        player.draw(buffer);
    }
}
