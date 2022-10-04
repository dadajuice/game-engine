package engine;

import java.awt.event.KeyListener;

public abstract class Game {

    private RenderingEngine renderingEngine;
    private boolean playing = true;
    private GameTime gameTime;

    protected abstract void initialize();
    protected abstract void update();
    protected abstract void drawOnBuffer(Buffer buffer);

    public Game() {
        renderingEngine = new RenderingEngine();
    }

    public final void start() {
        initialize();
        run();
        conclude();
    }

    protected void conclude() {

    }

    protected void stop() {
        playing = false;
    }

    protected void addKeyListener(KeyListener listener) {
        renderingEngine.addKeyListener(listener);
    }

    private void run() {
        renderingEngine.start();
        gameTime = new GameTime();
        while (playing) {
            update();
            drawOnBuffer(renderingEngine.buildBuffer());
            renderingEngine.drawBufferOnScreen();
            gameTime.synchronize();
        }
        renderingEngine.stop();
    }
}
