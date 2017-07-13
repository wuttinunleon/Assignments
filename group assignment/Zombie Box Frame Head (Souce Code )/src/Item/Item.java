package Item;

import Game.GameEngine;

import java.awt.*;
import java.util.ArrayList;


public class Item {

    float x;
    float y;
    Rectangle bound;
    int numOfBullet;
    GameEngine gameEngine;
    public boolean heal;
    public Item(){

    }
    public Item(float x , float y, GameEngine gameEngine){
        bound = new Rectangle();
        this.gameEngine = gameEngine;
        this.x = x;
        this.y=y;
        bound.x = 0;
        bound.y =0;
        bound.width =32;
        bound.height =32;

        heal =false;

        numOfBullet = (int)(Math.random()*40+15);
        ControllerItem.items.add(this);

    }

    public void tick(){}

    public void render(Graphics graphics){
        graphics.setColor(Color.BLUE);
        graphics.fillRect((int)(x-gameEngine.getCamera().getxOffset()),(int)(y-gameEngine.getCamera().getyOffset()),32,32);
    }

    public int getNumOfBullet() {
        return numOfBullet;
    }

    public Rectangle getBound() {
        return new Rectangle((int)(x+bound.x-gameEngine.getCamera().getxOffset()),(int)(y+bound.y-gameEngine.getCamera().getyOffset()),32,32);
    }
}
