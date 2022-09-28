import engine.Buffer;

import java.awt.*;
import java.util.Random;

public class Ball {

    private int radius;
    private int x;
    private int y;
    private int velocityX;
    private int velocityY;

    public Ball(int radius) {
        this.radius = radius;
        x = randomNumber(radius * 2, 800 - radius * 2);
        y = randomNumber(radius * 2, 600 - radius * 2);
        velocityX = randomNumber(0, 1) == 0 ? 5 : -5;
        velocityY = randomNumber(0, 1) == 0 ? 5 : -5;
    }

    public void update() {
        x += velocityX;
        y += velocityY;
        if (hasTouchVerticalBound()) {
            velocityY *= -1;
        }
        if (hasTouchHorizontalBound()) {
            velocityX *= -1;
        }
    }

    public boolean hasTouchBound() {
        return hasTouchHorizontalBound()
                || hasTouchVerticalBound();
    }

    private boolean hasTouchVerticalBound() {
        return y <= radius || y >= 600 - radius;
    }

    private boolean hasTouchHorizontalBound() {
        return x <= radius || x >= 800 - radius;
    }

    public void draw(Buffer buffer) {
        buffer.drawCircle(x, y, radius, Color.RED);
    }

    private int randomNumber(int min, int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }
}
