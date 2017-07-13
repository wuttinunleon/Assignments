package Enit;

import Assets.Animation;
import Assets.Assets;
import Game.GameEngine;
import State.GameState;
import State.MainMenuState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BotTank extends Status {
    Player player;
    BufferedImage skin;

    protected Animation animationDown;
    protected Animation animationUp;
    protected Animation animationLeft;
    protected Animation animationRight;
    protected Animation animationNow;

    public BotTank(GameEngine gameEngine, float x , float y, BufferedImage skin){
        super(gameEngine,x,y,96,96,Assets.monster);
        bound.x=width/3;
        bound.y=0;
        bound.width=width/2;
        bound.height=height;
        setMovementSpeed(1);
        setHealth(15);
        this.skin=skin;
        randomPlayer();
        animationDown = new Animation(180, Assets.zombieTank_down);
        animationNow = new Animation(180, Assets.zombieTank_down);
        animationUp = new Animation(180, Assets.zombieTank_up);
        animationRight = new Animation(180, Assets.zombieTank_right);
        animationLeft = new Animation(180, Assets.zombieTank_left);

    }

    public double max(double a,double b){
        if(a>b)return a;
        else return b;
    }
    public double min(double a,double b){
        if(a<b)return a;
        else return b;
    }
    int chh=0;
    @Override
    public void tick() {
        {
            if(MainMenuState.game == 1)
                this.player = GameState.player1;
            else if(MainMenuState.game == 2) {
                if (GameState.player1.status == 0 && GameState.player2.status == 0) {
                    return;

                } else if (GameState.player1.status == 0) {
                    this.player = GameState.player2;
                } else if (GameState.player2.status == 0) {
                    this.player = GameState.player1;
                }
            }

            int p=0;
            if (bothit.equals("Player1") || bothit.equals("Player2")) {

                for (int i = 0; i < gameEngine.getMap().getEnitityManager().getEnitities().size(); i++) {
                    if(gameEngine.getMap().getEnitityManager().getEnitities().get(i).toString().equals(bothit)){
                        if (bothit.equals("Player1")){
                            gameEngine.getMap().getEnitityManager().getEnitities().get(i).health-=2;
                        }
                        if (bothit.equals("Player2")){
                            gameEngine.getMap().getEnitityManager().getEnitities().get(i).health-=2;
                        }

                        if(gameEngine.getMap().getEnitityManager().getEnitities().get(i).health <= 0){
                            if(bothit.equals("Player1")){
                                GameState.player1.status =0;
                            }
                            if(bothit.equals("Player2")){
                                GameState.player2.status =0;
                            }
                            gameEngine.getMap().getEnitityManager().getEnitities().remove(i);
                        }
                    }
                }

                bothit="";


            } else {
                if (chh != 2) {
                    if (player.xPosition - xPosition > 0 && (!check(getBoundright()))) {
                        xPosition += movementSpeed;
                        animationNow =animationRight;
                        animationRight.tick();
                        p++;
                        chh = 1;
                    }
                    if (check(getBoundright()) && (yPosition == player.yPosition)) {
                        chh = 0;
                    }
                    if (player.xPosition - xPosition < 0 && ( !check(getBoundleft()))) {
                        xPosition -= movementSpeed;
                        animationNow = animationLeft;
                        animationLeft.tick();
                        chh = 1;
                        p++;
                    }
                    if (check(getBoundleft()) && (yPosition == player.yPosition)) {
                        chh = 0;
                    }
                    if (player.yPosition - yPosition > 0 && ( !check(getBounddown()))) {
                        yPosition += movementSpeed;
                        animationNow =animationDown;
                        animationDown.tick();
                        chh = 1;
                        p++;
                    }
                    if (check(getBounddown()) && (xPosition == player.xPosition)) chh = 0;
                    if (player.yPosition - yPosition < 0 && ( !check(getBoundup()))) {
                        yPosition -= movementSpeed;
                        animationNow = animationUp;
                        animationUp.tick();
                        chh = 1;
                        p++;
                    }
                    if (check(getBoundup()) && (xPosition == player.xPosition)) {
                        chh = 0;
                    }
                    if (bothit.equals("Player")) {return;}
                }
            }
        }
    }
    public Rectangle getBoundleft() {
        return new Rectangle((int)(xPosition+bound.x-gameEngine.getCamera().getxOffset()-5),(int)(yPosition+bound.y-gameEngine.getCamera().getyOffset()),bound.width,bound.height);
    }
    public Rectangle getBoundright() {
        return new Rectangle((int)(xPosition+bound.x-gameEngine.getCamera().getxOffset()+5),(int)(yPosition+bound.y-gameEngine.getCamera().getyOffset()),bound.width,bound.height);
    }
    public Rectangle getBoundup() {
        return new Rectangle((int)(xPosition+bound.x-gameEngine.getCamera().getxOffset()),(int)(yPosition+bound.y-gameEngine.getCamera().getyOffset()-5),bound.width,bound.height);
    }
    public Rectangle getBounddown() {
        return new Rectangle((int)(xPosition+bound.x-gameEngine.getCamera().getxOffset()),(int)(yPosition+bound.y-gameEngine.getCamera().getyOffset()+5),bound.width,bound.height);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(animationNow.getCurrentFrames(),(int)(xPosition-gameEngine.getCamera().getxOffset()),(int)(yPosition-gameEngine.getCamera().getyOffset()),width,height,null);
        graphics.setColor(Color.red);
        //graphics.fillRect((int)(xPosition+bound.x-gameEngine.getCamera().getxOffset()),(int)(yPosition+bound.y-gameEngine.getCamera().getyOffset()),bound.width,bound.height);

    }

    @Override
    public String toString(){
        return "Bot";
    }


    public void randomPlayer(){
        if((int)(Math.random()*2)>0){
            this.player = GameState.player1;}
        else{
            this.player = GameState.player2;
        }
    }

}

