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
    protected void drawOnBuffer(Graphics2D buffer) {
        ball.draw(buffer);
        buffer.setPaint(Color.WHITE);
        buffer.drawString("Score: " + score, 10, 20);
    }
}
