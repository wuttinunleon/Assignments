package Attack;

import Game.GameEngine;
import Item.*;
import State.GameState;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by duckk on 12/4/2560.
 */
public class Controller {
    public static ArrayList<Bullets> bullets = new ArrayList<>();
    private GameEngine gameEngine;

    public Controller(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void tick() {

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).tick();

            if(bullets.get(i).x > 4000 ||bullets.get(i).y >4000){
                bullets.remove(i);
                break;
            }

            for (int j =0 ;j<gameEngine.getMap().getEnitityManager().getEnitities().size();j++){
                if(gameEngine.getMap().getEnitityManager().getEnitities().get(j).getBound().intersects(bullets.get(i).getBullet())){
                    if(gameEngine.getMap().getEnitityManager().getEnitities().get(j).toString().equals("Bot") ||gameEngine.getMap().getEnitityManager().getEnitities().get(j).toString().equals("Boss")||gameEngine.getMap().getEnitityManager().getEnitities().get(j).toString().equals("BotMc")) {
                       if(bullets.get(i).getBulletType()==3){
                           GameState.score += 2 ;
                           gameEngine.getMap().getEnitityManager().getEnitities().get(j).health -= 2;
                       }else{
                           GameState.score++;
                           gameEngine.getMap().getEnitityManager().getEnitities().get(j).health -= 1;
                       }
                    }
                    if(gameEngine.getMap().getEnitityManager().getEnitities().get(j).health<=0){
                        randomItem(gameEngine.getMap().getEnitityManager().getEnitities().get(j).xPosition,gameEngine.getMap().getEnitityManager().getEnitities().get(j).yPosition,gameEngine);
                        if(gameEngine.getMap().getEnitityManager().getEnitities().get(j).toString().equals("Boss")){
                            GameState.win=true;
                        }
                        gameEngine.getMap().getEnitityManager().getEnitities().remove(j);
                    }
                    if(bullets.get(i).getBulletType()==3){
                        bullets.get(i).figure--;
                        if(bullets.get(i).figure == 0){
                            bullets.remove(i);
                        }
                    }else {
                        bullets.remove(i);
                    }

                    break;
                }
            }
        }


    }

    public void render(Graphics g) {

        for (Bullets b : bullets) {
            b.render(g);
        }
    }


    public void randomItem(Float x , Float y,GameEngine gameEngine){
        if((int)(Math.random()*8)==1)
        new Item(x,y,gameEngine);
        else if ((int)(Math.random()*8)==1)
           new ItemHeal(x,y,gameEngine);
    }

}

