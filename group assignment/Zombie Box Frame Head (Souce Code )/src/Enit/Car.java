package Enit;

import Assets.Assets;
import Game.GameEngine;
import Tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Car extends Enitity {

        public Car(GameEngine gameEngine, float x , float y, BufferedImage texture){
            super(gameEngine , x ,y,Tile.width*4,Tile.height*2,texture);

            bound.x = 32;
            bound.y = 32;
            bound.width=256;
            bound.height=128;
        }

    public void tick() {

    }

    public void render(Graphics graphics) {
            graphics.drawImage(Assets.car ,(int)( xPosition-gameEngine.getCamera().getxOffset()) ,(int)( yPosition-gameEngine.getCamera().getyOffset() ),width,height,null);
            graphics.setColor(Color.green);
           // graphics.fillRect((int)(xPosition+bound.x-gameEngine.getCamera().getxOffset()),(int)(yPosition+bound.y-gameEngine.getCamera().getyOffset()),bound.width,bound.height);
    }
    @Override
    public String toString(){
            return "Tree";
    }
}
