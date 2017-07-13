package Attack;

import Game.GameEngine;

import java.awt.*;

/**
 * Created by duckk on 12/4/2560.
 */
public class BulletUp extends Bullets {
    public BulletUp(float x, float y, int speed, GameEngine gameEngine,int bulletType) {
        super(x, y, speed,gameEngine,bulletType);
        bound = new Rectangle();
        bound.x=0;
        bound.y=0;
        bound.width=5;
        bound.height=30;
        addBullet(this);
    }

    @Override
    public void tick() {

        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if(timer > 1){
            timer = 0;
            y -= speed;
        }

    }

}
