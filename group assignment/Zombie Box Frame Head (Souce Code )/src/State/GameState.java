package State;

import Assets.Assets;
import Attack.Bullets;
import Attack.Controller;
import Enit.*;
import Game.GameEngine;
import Item.Item;
import Sound.Sound;
import World.Map;
import Item.ControllerItem;

import java.awt.*;


public class GameState extends StateManager {

public static Player player1;
public static Player player2;

private Bot bot,bot2,bot3;
private Controller controller;
private ControllerItem controllerItem;
private int cooldown = 500;
private int mon = 0;
private int trueMon = 0;
private long timer, lastTime;
private boolean spawn = true;
private boolean bossSpawn = true;
public static int score = 0;
private Sound BGmusic;
public static Boolean win= false;
private int numOfZombie = 150;
    Map map;
    public GameState(GameEngine gameEngine){
        super(gameEngine);
        controller = new Controller(gameEngine);
        controllerItem = new ControllerItem();
        player1 = new Player1(gameEngine,2100,2100,Assets.player);
        if(MainMenuState.game==2){
            player2 = new Player2(gameEngine,2000,2000,Assets.player);

        }
        gameEngine.getCamera().setPlayer1(player1);
        gameEngine.getCamera().setPlayer2(player2);
        map= new Map(gameEngine);
        if(MainMenuState.game==2){
            gameEngine.getMap().getEnitityManager().addEntities(player2);

        }
        gameEngine.getMap().getEnitityManager().addEntities(player1);
        BGmusic = new Sound("/Play.wav");
        BGmusic.loop();
        score = 0;
        win= false;


    }
    @Override
    public void init() {

    }

    @Override
    public void render(Graphics graphics) {

        map.render(graphics);
        controllerItem.render(graphics);
        controller.render(graphics);

    }

    @Override
    public void tick() {
        int count = 0;
        if (trueMon >= numOfZombie) {
            spawn = false;
        }
        if (cooldown() && spawn) {
            if(trueMon%10==0){
                gameEngine.getMap().getEnitityManager().getEnitities().add(new BotMc(gameEngine,(float)Math.random() * 1000 + 4000, (float) Math.random() * 40*mon, null));
                gameEngine.getMap().getEnitityManager().getEnitities().add(new BotTank(gameEngine,(float)Math.random() - 1000 , (float) Math.random() * 40*mon, null));
            }if(trueMon%20==0){
                gameEngine.getMap().getEnitityManager().getEnitities().add(new BotTank(gameEngine,(float)Math.random() * 1000 + 4000, (float) Math.random() * 40*mon, null));
                gameEngine.getMap().getEnitityManager().getEnitities().add(new BotTank(gameEngine,(float)Math.random() - 1000, (float) Math.random() * 40*mon, null));
            }
            gameEngine.getMap().getEnitityManager().getEnitities().add(new Bot(gameEngine, (float) Math.random() * 1000 + 4000, (float) Math.random() * 40*mon, Assets.monster));
            gameEngine.getMap().getEnitityManager().getEnitities().add(new Bot(gameEngine, (float) Math.random() * -1000, (float) Math.random() * 4000, Assets.monster));
            trueMon+=2;
            }


        if (!spawn && mon < numOfZombie/5 && bossSpawn) {
            BGmusic.close();
            BGmusic = new Sound("/titan.wav");
            BGmusic.loop();
            gameEngine.getMap().getEnitityManager().getEnitities().add(new Boss(gameEngine, (float) 2000, (float) 2000, Assets.monster));
            bossSpawn =false;
        }
        for (Enitity e : gameEngine.getMap().getEnitityManager().getEnitities()
                ) {
            if (e.toString().equals("Bot"))
                count++;
        }

        if(win){
            BGmusic.close();
            setRunningState(new GameOver(gameEngine));
        }

        if(MainMenuState.game==1 && player1.status == 0){
            BGmusic.close();

            setRunningState(new GameOver(gameEngine));
        }
        if(MainMenuState.game==2 && player1.status ==0 && player2.status == 0){
            BGmusic.close();

            setRunningState(new GameOver(gameEngine));
        }
        mon = count;
        System.out.println(mon);
        map.tick();
        controller.tick();

    }
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean cooldown(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (timer >cooldown) {
            timer = 0;
            return true;
        } else
            return false;

    }
}
