package vikingGame;

import engine.Buffer;
import engine.Game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class VikingGame extends Game {

    private GamePad gamePad;
    private Player player;
    private World world;
    private Tree tree;
    private int soundCooldown;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.load();
        world = new World();
        world.load();
        player.teleport(200, 200);
        tree = new Tree(300, 350);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
        if (player.getY() < tree.getY() + 52) {
            tree.blockadeFromTop();
        } else {
            tree.blockadeFromBottom();
        }

        soundCooldown--;
        if (soundCooldown < 0) {
            soundCooldown = 0;
        }

        if (gamePad.isFirePressed() && soundCooldown == 0) {
            soundCooldown = 100;
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream stream = AudioSystem.getAudioInputStream(
                        this.getClass().getClassLoader().getResourceAsStream("audios/fire.wav")
                );
                clip.open(stream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void drawOnBuffer(Buffer buffer) {
        world.draw(buffer);
        // 80 (tree height) - 28 (max for layer switch)
        if (player.getY() < tree.getY() + 52) {
            player.draw(buffer);
            tree.draw(buffer);
        } else {
            tree.draw(buffer);
            player.draw(buffer);
        }

    }
}
