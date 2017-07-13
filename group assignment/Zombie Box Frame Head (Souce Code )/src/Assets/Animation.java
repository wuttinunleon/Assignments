package Assets;

import java.awt.image.BufferedImage;

/**
 * Created by duckk on 11/4/2560.
 */
public class Animation {



    private int speed, index;
    private long timer, lastTime;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index ++;
            timer = 0;
            if(index >= frames.length){
                index = 0;
            }

        }

    }

    public BufferedImage getCurrentFrames() {
        return frames[index];
    }
}
