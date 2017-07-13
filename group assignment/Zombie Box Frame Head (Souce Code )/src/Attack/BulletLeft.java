package Attack;

import Game.GameEngine;

import java.awt.*;

/**
 * Created by duckk on 12/4/2560.
 */
public class BulletLeft extends Bullets {
    public BulletLeft(float x, float y, int speed, GameEngine gameEngine,int bulletType) {
        super(x, y, speed,gameEngine, bulletType);
        bound = new Rectangle();
        bound.x=0;
        bound.y=0;
        bound.width=30;
        bound.height=5;
        addBullet(this);
    }

    @Override
    public void tick() {

        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if(timer > 1){
            timer = 0;
            x -= speed;
        }

    }

}
