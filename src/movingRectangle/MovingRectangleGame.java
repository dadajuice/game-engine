package movingRectangle;

import engine.Buffer;
import engine.Game;

import java.awt.*;

public class MovingRectangleGame extends Game {

    private Player player;
    private Npc npc;
    private Controller controller;

    @Override
    protected void initialize() {
        controller = new Controller();
        super.addKeyListener(controller);

        player = new Player(controller);
        npc = new Npc();
    }

    @Override
    protected void update() {
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
