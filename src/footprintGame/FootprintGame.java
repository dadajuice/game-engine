package footprintGame;

import engine.Buffer;
import engine.Game;

import java.awt.*;
import java.util.ArrayList;

public class FootprintGame extends Game {

    private ArrayList<Footprint> footprints;
    private Player player;
    private GamePad gamePad;

    @Override
    protected void initialize() {
        footprints = new ArrayList<>();
        gamePad = new GamePad();
        player = new Player(gamePad);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            super.stop();
        }
        player.update();
        if (gamePad.isMoving()) {
            footprints.add(player.layFootprint());
        }
    }

    @Override
    protected void drawOnBuffer(Buffer buffer) {
        buffer.drawRectangle(0, 0, 800, 600, Color.BLUE);
        for (Footprint footprint : footprints) {
            footprint.draw(buffer);
        }
        player.draw(buffer);
    }
}
