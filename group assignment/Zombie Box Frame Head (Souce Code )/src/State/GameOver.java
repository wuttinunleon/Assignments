package State;

import Attack.Controller;
import Enit.Enitity;
import EntityManger.EnitityManager;
import Game.GameEngine;
import Item.ControllerItem;
import Loader.ImageLoader;
import Sound.Sound;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class GameOver extends StateManager {
    private GameEngine gameEngine;
    Font h = new Font("Helvetica", Font.PLAIN, 72);
    private BufferedImage BG;
    private Sound BGmusic;

    public GameOver(GameEngine gameEngine){
        super();
        this.gameEngine =gameEngine;
        if(GameState.win){
            BG = ImageLoader.loadImage("/winner.png");
            BGmusic = new Sound("/Victory.wav");
        }else{
            BG = ImageLoader.loadImage("/lose.png");
            BGmusic = new Sound("/Fail.wav");
        }
        BGmusic.loop();
    }
    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(h);
        graphics.drawImage(BG,0,0,null);
        graphics.drawString("   GAME OVER",gameEngine.WIDTH/2-280,gameEngine.HEIGHT/3);
        graphics.setColor(Color.red);
        graphics.drawString("Score  :" +String.valueOf(GameState.score),gameEngine.WIDTH/2-180,gameEngine.HEIGHT/2+50);
        graphics.setColor(Color.GREEN);
        graphics.drawString("     Press    R    to menu",gameEngine.WIDTH/2-430,gameEngine.HEIGHT/2+200);
    }

    @Override
    public void tick() {

        if(gameEngine.getKeyManager().r){
            BGmusic.close();
            gameEngine.getMap().getEnitityManager().getEnitities().clear();
            Controller.bullets.clear();
            ControllerItem.items.clear();
            setRunningState(new MainMenuState(gameEngine));
        }

    }

    @Override
    public void init() {

    }


}
