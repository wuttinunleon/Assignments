package Attack;


import Game.GameEngine;

import java.awt.*;
import java.util.ArrayList;

public abstract class Bullets {


    protected float x;
    protected float y;
    protected int speed;
    protected Rectangle bound;
    protected int cooldown=200;
    protected long timer,lastTime;
    protected GameEngine gameEngine;
    private  int bulletType;
    public int figure = 3;

    public Bullets(float x , float y , int speed , GameEngine gameEngine , int bulletType){

        this.x = x;
        this.y = y;
        this.speed =speed;
        lastTime = System.currentTimeMillis();
        this.gameEngine = gameEngine;
        this.bulletType = bulletType;

    }

    public abstract void tick();

    public void render(Graphics g){

        g.setColor(Color.red);
        g.fillRect((int)(x-gameEngine.getCamera().getxOffset()),(int)(y-gameEngine.getCamera().getyOffset()),(int)bound.getWidth(),(int)bound.getHeight());

    }

    public void addBullet(Bullets b){
        Controller.bullets.add(b);
    }

    public Rectangle getBullet() {
        return new Rectangle((int)(x-gameEngine.getCamera().getxOffset()),(int)(y-gameEngine.getCamera().getyOffset()),bound.width,bound.height);
    }

    public int getBulletType() {
        return bulletType;
    }

    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }
}
