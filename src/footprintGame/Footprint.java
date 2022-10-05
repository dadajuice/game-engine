package footprintGame;

import engine.Buffer;
import engine.StaticEntity;

import java.awt.*;
import java.util.Random;

public class Footprint extends StaticEntity {

    public Footprint(int x, int y) {
        teleport(x, y);
        setDimension(5, 5);
    }

    @Override
    public void draw(Buffer buffer) {
        Color color = new Color(getRandomValue(), getRandomValue(),
                getRandomValue());
        buffer.drawRectangle(x, y, width, height, color);
    }

    private int getRandomValue() {
        return (new Random()).nextInt(256);
    }
}
