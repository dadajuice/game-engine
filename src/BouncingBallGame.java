import engine.Buffer;
import engine.Game;
import engine.GameTime;

import java.awt.*;

public class BouncingBallGame extends Game {

    private Ball ball;
    private int score;

    @Override
    protected void initialize() {
        ball = new Ball(25);
        score = 0;
    }

    @Override
    protected void update() {
        ball.update();
        if (ball.hasTouchBound()) {
            score += 10;
        }
    }

    @Override
    protected void drawOnBuffer(Buffer buffer) {
        ball.draw(buffer);
        buffer.drawString("Score: " + score, 10, 20, Color.WHITE);
        buffer.drawString(GameTime.getElapsedFormattedTime(), 10, 40, Color.WHITE);
        buffer.drawString("FPS: " + GameTime.getCurrentFps(), 10, 60, Color.WHITE);
    }
}
