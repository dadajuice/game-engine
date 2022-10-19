package vikingGame;

import engine.Buffer;
import engine.Game;

public class VikingGame extends Game {

    private GamePad gamePad;
    private Player player;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
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
        player.draw(buffer);
    }
}
