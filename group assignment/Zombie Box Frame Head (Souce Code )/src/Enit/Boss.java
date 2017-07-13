package Enit;

import Assets.Animation;
import Assets.Assets;
import Game.GameEngine;
import State.GameState;
import State.MainMenuState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Boss extends Status {
    Player player;
    BufferedImage skin;
    protected Animation animationDown;
    protected Animation animationUp;
    protected Animation animationLeft;
    protected Animation animationRight;
    protected Animation animationNow;
    double plaxx,playy;
    private int cooldown = 0;
    private long timer, lastTime;
    public Boss(GameEngine gameEngine, float x , float y, BufferedImage skin){
        super(gameEngine,x,y,Status.DEFAULT_BOSS_WIDTH,Status.DEFAULT_BOSS_HEIGHT,null);
        bound.x=width/3;
        bound.y=0;
        bound.width=width/2;
        bound.height=height;
        setMovementSpeed(1);
        setHealth(200);
        this.skin=skin;
        randomPlayer();
        animationDown = new Animation(180, Assets.boss_down);
        animationNow = new Animation(180, Assets.boss_down);
        animationUp = new Animation(180, Assets.boss_up);
        animationRight = new Animation(180, Assets.boss_right);
        animationLeft = new Animation(180, Assets.boss_left);

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

                if(cooldown < 300) {
                    cooldown++;
                    plaxx=player.xPosition;
                    playy=player.yPosition;
                    if (plaxx - xPosition > 200) {
                        xPosition += movementSpeed;
                        animationNow = animationRight;
                        animationRight.tick();
                    }
                    if (plaxx - xPosition  < 200 ) {
                        xPosition -= movementSpeed;
                        animationNow = animationLeft;
                        animationLeft.tick();
                    }
                    if (playy - yPosition > 400 ) {
                        yPosition += movementSpeed;
                        animationNow = animationDown;
                        animationDown.tick();
                    }
                    if (playy - yPosition < 400 ) {
                        yPosition -= movementSpeed;
                        animationNow = animationUp;
                        animationUp.tick();
                    }
                    if (bothit.equals("Player")) {
                        return;
                    }
                }else{   //Boss spi
                    if (plaxx - xPosition > 200 ) {
                        xPosition += movementSpeed;
                        animationNow = animationRight;
                        animationRight.tick();
                    }
                    if (plaxx - xPosition < 200 ) {
                        xPosition -= movementSpeed;
                        animationNow = animationLeft;
                        animationLeft.tick();
                    }
                    if (playy - yPosition > 400 ) {
                        yPosition += movementSpeed;
                        animationNow = animationDown;
                        animationDown.tick();
                    }
                    if (check(getBounddown()) && (xPosition == plaxx )) chh = 0;
                    if (playy - yPosition < 400 ) {
                        yPosition -= movementSpeed;
                        animationNow = animationUp;
                        animationUp.tick();
                    }
                    if (bothit.equals("Player")) {
                        return;
                    }
                    setMovementSpeed(10);
                    cooldown++;
                    if(cooldown==400){
                        setMovementSpeed(1);
                        cooldown=0;
                    }
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
        return "Boss";
    }


    public void randomPlayer(){
        if((int)(Math.random()*2)>0){
            this.player = GameState.player1;}
        else{
            this.player = GameState.player2;
        }
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

