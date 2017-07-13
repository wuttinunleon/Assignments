package State;


import Game.GameEngine;
import Loader.ImageLoader;
import Sound.Sound;
import SpriteSheet.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenuState extends StateManager {

public static int game;
private int gameMode = 1;
int x , y;
    private Sound BGmusic;

    public MainMenuState(GameEngine gameEngine) {
        super(gameEngine);
        this.x = 200;
        this.y = 450;
        BGmusic = new Sound("/Menu.wav");
        BGmusic.loop();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(ImageLoader.loadImage("/menu.png"),0,0,null);
        graphics.setColor(Color.green);
        graphics.fillRect(x,y,64,64);

    }

    @Override
    public void init() {

    }

    @Override
    public void tick() {

        if(gameEngine.getKeyManager().left2 && gameMode == 2){


            gameMode=1;
            this.x = 200;
            this.y = 450;

        }

        if(gameEngine.getKeyManager().right2 && gameMode == 1) {
            gameMode=2;
            this.x = 580;
            this.y = 450;
        }

        if(gameEngine.getKeyManager().enter){
            this.game = gameMode;
            BGmusic.close();
            setRunningState(new GameState(gameEngine));

        }
    }
}
