package Enit;

import Assets.Assets;
import Game.GameEngine;
import State.GameState;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enitity {

    public float xPosition;
    public float yPosition;
    public BufferedImage texture;
    protected int width;
    protected int height;
    GameEngine gameEngine;
    Rectangle bound;
    String bothit="olo";
    public String side="down";
    public int health=2;
    public int status =1 ;
    public Enitity(GameEngine gameEngine,float xPosition , float yPosition , int width,int height,BufferedImage texture){
        this.gameEngine=gameEngine;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.width=width;
        this.height=height;
        this.texture=texture;
        bound = new Rectangle(0,0,width,height);

    }

    public boolean check(Rectangle bound){

        for (Enitity e:gameEngine.getMap().getEnitityManager().getEnitities()
             ) {
            if (e.equals(this))
                continue;
            if(e.toString().equals("Boss"))
                return  false;
            if(e.getBound().intersects(bound)) {
               bothit=e.toString();
                return true;

            }
        }
        return false;
    }

    public Rectangle getBound() {
        return new Rectangle((int)(xPosition+bound.x-gameEngine.getCamera().getxOffset()),(int)(yPosition+bound.y-gameEngine.getCamera().getyOffset()),bound.width,bound.height);

    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    public int getHealth() {
        return health;
    }
}
