package Enit;

import Assets.Assets;
import Game.GameEngine;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Status extends Enitity {

    int health = 10 ;
    int movementSpeed;
    final static protected int DEFAULT_PLAYER_WIDTH =64;
    final static protected int DEFAULT_PLAYER_HEIGHT =64;
    final static protected int DEFAULT_BOT_WIDTH =64;
    final static protected int DEFAULT_BOT_HEIGHT =64;
    final static protected int DEFAULT_BOSS_WIDTH =512;
    final static protected int DEFAULT_BOSS_HEIGHT =512;


    public Status(GameEngine gameEngine, float x, float y, int width, int height,BufferedImage texture){
        super(gameEngine,x,y,width,height,texture);
        movementSpeed = 10;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {

    }
    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

}
