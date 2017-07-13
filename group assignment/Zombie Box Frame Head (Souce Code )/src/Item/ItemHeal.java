package Item;

import Game.GameEngine;
import State.GameState;

import java.awt.*;


public class ItemHeal extends Item {

    float x;
    float y;
    Rectangle bound;
    int numOfBullet;
    GameEngine gameEngine;

    public ItemHeal(float x , float y, GameEngine gameEngine){
        super(x,y, gameEngine);
        bound = new Rectangle();
        this.gameEngine = gameEngine;
        this.x = x;
        this.y=y;
        bound.x = 0;
        bound.y =0;
        bound.width =32;
        bound.height =32;
        heal = true;

        ControllerItem.items.add(this);

    }

    public void tick(){}

    public void render(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.fillRect((int)(x-gameEngine.getCamera().getxOffset()),(int)(y-gameEngine.getCamera().getyOffset()),32,32);
    }

    public int getNumOfBullet() {
        return numOfBullet;
    }

    public Rectangle getBound() {
        return new Rectangle((int)(x+bound.x-gameEngine.getCamera().getxOffset()),(int)(y+bound.y-gameEngine.getCamera().getyOffset()),32,32);
    }
}
