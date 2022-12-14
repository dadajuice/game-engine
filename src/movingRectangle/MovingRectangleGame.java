package movingRectangle;

import engine.Buffer;
import engine.Game;

import java.awt.*;

public class MovingRectangleGame extends Game {

    private Player player;
    private Npc npc;
    private GamePad gamePad;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        npc = new Npc();
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            super.stop();
        }
        player.update();
        npc.update();
    }

    @Override
    protected void drawOnBuffer(Buffer buffer) {
        buffer.drawRectangle(0, 0, 800, 600, Color.BLUE);
        player.draw(buffer);
        npc.draw(buffer);
    }
}
