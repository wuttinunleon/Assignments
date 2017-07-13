package Enit;

import Assets.*;
import Attack.*;
import Game.GameEngine;
import Loader.ImageLoader;
import Sound.Sound;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;


public class Player extends Status {

    Rectangle atkBox;
    protected Animation animationDown;
    protected Animation animationUp;
    protected Animation animationLeft;
    protected Animation animationRight;
    protected Animation animationNow;
    protected int cooldown = 200;
    private long timer, lastTime;
    protected int weapon = 1;
    protected int bulletType = 1;
    public int playerStatus = 1;
    protected int gunBullet = 8888;
    protected int akBullet = 200;
    protected int shotgunBullet = 20;
    protected boolean outOfAmmo = false;
    protected int gun = 1;
    protected boolean gun1 , gun2, gun3 ;
    protected int nowBullet;
    Font h = new Font("Helvetica", Font.PLAIN, 18);
    public static HashMap<String, Sound> sfx;

    public Player(GameEngine gameEngine, float x, float y, BufferedImage texture) {
        super(gameEngine, x, y, Status.DEFAULT_PLAYER_WIDTH, Status.DEFAULT_PLAYER_HEIGHT, texture);
        bound.x = width / 3;
        bound.y = 15;
        bound.width = width / 2-5;
        bound.height = height-20;
        lastTime = System.currentTimeMillis();
        setMovementSpeed(5);
        setHealth(200);
        animationDown = new Animation(180, Assets.playerAK_down);
        animationNow = new Animation(180, Assets.playerAK_down);
        animationUp = new Animation(180, Assets.playerAK_up);
        animationRight = new Animation(180, Assets.playerAK_right);
        animationLeft = new Animation(180, Assets.playerAK_left);
        sfx = new HashMap<String, Sound>();
        sfx.put("shoot", new Sound("/Gun+1.wav"));


    }

    public void atkCheck(int whichPlayer) {

        weaponChange(whichPlayer);
        boolean fired = false;
        if (gameEngine.getKeyManager().atk && side.equals("left") && active() && !outOfAmmo) {
            new BulletLeft(xPosition - 30, yPosition + height / 2, 20, gameEngine, bulletType);
            fired = true;
        } else if (gameEngine.getKeyManager().atk && side.equals("right") && active() & !outOfAmmo) {

            new BulletRight(xPosition + 80, yPosition + height / 2, 20, gameEngine, bulletType);
            fired = true;
        } else if (gameEngine.getKeyManager().atk && side.equals("up") && active() & !outOfAmmo) {

            new BulletUp(xPosition + width / 2, yPosition - height, 20, gameEngine, bulletType);
            fired = true;
        } else if (gameEngine.getKeyManager().atk && side.equals("down") && active() & !outOfAmmo) {

            new BulletDown(xPosition + width / 2, yPosition + height, 20, gameEngine, bulletType);
            fired = true;
        }


        if (bulletType == 1 && fired) {
            nowBullet = gunBullet;
            sfx.get("shoot").play();
        }
        if (bulletType == 2 && fired) {
            nowBullet = akBullet;
            sfx.get("shoot").play();
            akBullet--;
            if (akBullet == 0)
                outOfAmmo = true;
        }
        if (bulletType == 3 && fired) {
            nowBullet = shotgunBullet;
            sfx.get("shoot").play();
            shotgunBullet--;
            if (shotgunBullet == 0)
                outOfAmmo = true;
        }


    }


    @Override
    public void tick() {

    }

    public Rectangle getBoundleft() {
        return new Rectangle((int) (xPosition + bound.x - gameEngine.getCamera().getxOffset() - 10), (int) (yPosition + bound.y - gameEngine.getCamera().getyOffset()), bound.width, bound.height);
    }

    public Rectangle getBoundright() {
        return new Rectangle((int) (xPosition + bound.x - gameEngine.getCamera().getxOffset() + 10), (int) (yPosition + bound.y - gameEngine.getCamera().getyOffset()), bound.width, bound.height);
    }

    public Rectangle getBoundup() {
        return new Rectangle((int) (xPosition + bound.x - gameEngine.getCamera().getxOffset()), (int) (yPosition + bound.y - gameEngine.getCamera().getyOffset() - 10), bound.width, bound.height);
    }

    public Rectangle getBounddown() {
        return new Rectangle((int) (xPosition + bound.x - gameEngine.getCamera().getxOffset()), (int) (yPosition + bound.y - gameEngine.getCamera().getyOffset() + 10), bound.width, bound.height);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(animationNow.getCurrentFrames(), (int) (xPosition - gameEngine.getCamera().getxOffset()), (int) (yPosition - gameEngine.getCamera().getyOffset()), width, height, null);
        graphics.setFont(h);
        graphics.drawString(String.valueOf(nowBullet),(int) (xPosition - gameEngine.getCamera().getxOffset()),(int) (yPosition - gameEngine.getCamera().getyOffset()));
        graphics.setColor(Color.red);
        graphics.fillRect((int) (xPosition - gameEngine.getCamera().getxOffset()), (int) (yPosition - gameEngine.getCamera().getyOffset()) - 20, (int) (0.3 * getHealth()), 3);

         //graphics.fillRect((int)(xPosition+bound.x-gameEngine.getCamera().getxOffset()),(int)(yPosition+bound.y-gameEngine.getCamera().getyOffset()),bound.width,bound.height);
    }

    @Override
    public String toString() {
        return "Player";
    }


    public boolean active() {
         timer+= System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (timer > cooldown) {
            timer = 0;
            return true;
        } else
            return false;

    }


    public void weaponChange(int whichPlayer) {
        if (whichPlayer == 1) {
                if (gameEngine.getKeyManager().weapon_p1_back && gun >= 0) {
                    gun--;
                    gameEngine.getKeyManager().weapon_p1_back = false;
                }
                if (gameEngine.getKeyManager().weapon_p1_next && gun <= 20 ) {
                    gun++;
                    gameEngine.getKeyManager().weapon_p1_next = false;
                }

        } else {
            if (gameEngine.getKeyManager().weapon_p2_back && gun >= 0) {
                gun--;
                gameEngine.getKeyManager().weapon_p2_back =false;
            }
            if (gameEngine.getKeyManager().weapon_p2_next && gun <= 20) {
                gun++;
                gameEngine.getKeyManager().weapon_p2_back =false;
            }
        }
        if (gun < 6&& !gun1) {
            nowBullet = gunBullet;
            cooldown = 500;
            bulletType = 1;
            animationDown = new Animation(180, Assets.player_down);
            animationNow = new Animation(180, Assets.player_down);
            animationUp = new Animation(180, Assets.player_up);
            animationRight = new Animation(180, Assets.player_right);
            animationLeft = new Animation(180, Assets.player_left);
            if (side.equals("left"))
                animationNow = new Animation(180, Assets.player_left);
            else if (side.equals("right"))
                animationNow = new Animation(180, Assets.player_right);
            else if (side.equals("up"))
                animationNow = new Animation(180, Assets.player_up);
            else if (side.equals("down"))
                animationNow = new Animation(180, Assets.player_down);
            gun1 = true;
            gun2 = false;
            gun3 = false;

        }
        if (gun >=6  && gun <= 13 && !gun2) {
            nowBullet = akBullet;
            if (akBullet == 0) {
                outOfAmmo = true;
            } else if (akBullet > 0) {
                outOfAmmo = false;
            }
            cooldown = 100;
            bulletType = 2;
            animationDown = new Animation(180, Assets.playerAK_down);
            animationNow = new Animation(180, Assets.playerAK_down);
            animationUp = new Animation(180, Assets.playerAK_up);
            animationRight = new Animation(180, Assets.playerAK_right);
            animationLeft = new Animation(180, Assets.playerAK_left);
            if (side.equals("left"))
                animationNow = new Animation(180, Assets.playerAK_left);
            else if (side.equals("right"))
                animationNow = new Animation(180, Assets.playerAK_right);
            else if (side.equals("up"))
                animationNow = new Animation(180, Assets.playerAK_up);
            else if (side.equals("down"))
                animationNow = new Animation(180, Assets.playerAK_down);
            gun1 = false;
            gun2 = true;
            gun3 = false;

        }
        if (gun > 13  && gun <=20 && !gun3 ) {
            nowBullet = shotgunBullet;
            if (shotgunBullet == 0) {
                outOfAmmo = true;
            } else if (shotgunBullet > 0) {
                outOfAmmo = false;
            }
            cooldown = 400;
            bulletType = 3;
            animationDown = new Animation(180, Assets.playerShotgun_down);
            animationUp = new Animation(180, Assets.playerShotgun_up);
            animationRight = new Animation(180, Assets.playerShotgun_right);
            animationLeft = new Animation(180, Assets.playerShotgun_left);

            if (side.equals("left"))
                animationNow = new Animation(180, Assets.playerShotgun_left);
            else if (side.equals("right"))
                animationNow = new Animation(180, Assets.playerShotgun_right);
            else if (side.equals("up"))
                animationNow = new Animation(180, Assets.playerShotgun_up);
            else if (side.equals("down"))
                animationNow = new Animation(180, Assets.playerShotgun_down);

            gun1 = false;
            gun2 = false;
            gun3 = true;
        }

    }


}


