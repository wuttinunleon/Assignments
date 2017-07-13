package Enit;

import Assets.*;
import Attack.BulletDown;
import Attack.BulletLeft;
import Attack.BulletRight;
import Attack.BulletUp;
import Game.GameEngine;
import Item.ControllerItem;
import State.GameState;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player2 extends Player {
    public Player2(GameEngine gameEngine, float x, float y, BufferedImage texture) {
        super(gameEngine, x, y, texture);
    }

    @Override
    public void tick() {
        {
            atkCheck(2);
            for (int i = 0; i < ControllerItem.items.size(); i++) {

                if (this.getBound().intersects(ControllerItem.items.get(i).getBound())) {
                    if (!ControllerItem.items.get(i).heal) {
                        if ((int) (Math.random() * 3) > 1) {
                            akBullet += ControllerItem.items.get(i).getNumOfBullet() * 3;
                            nowBullet = akBullet;
                        } else
                            shotgunBullet += ControllerItem.items.get(i).getNumOfBullet();
                        ControllerItem.items.remove(i);
                            nowBullet = shotgunBullet;
                    } else {
                        setHealth(200);
                        ControllerItem.items.remove(i);

                    }

                }
            }
            {
                if (gameEngine.getKeyManager().up2 && !check(getBoundup())&&yPosition>0 &&((Math.abs(this.yPosition-GameState.player1.yPosition-5)<gameEngine.HEIGHT-100)|| (GameState.player1.status==0))) {
                    animationUp.tick();
                    animationNow = animationUp;
                    yPosition -= movementSpeed;

                    side = "up";
                }
                if (gameEngine.getKeyManager().down2 && !check(getBounddown()) &&yPosition<3880&&((Math.abs(this.yPosition-GameState.player1.yPosition+5)<gameEngine.HEIGHT-100)|| (GameState.player1.status==0))) {
                    animationDown.tick();
                    animationNow = animationDown;
                    yPosition += movementSpeed;
                    side = "down";
                }
                if (gameEngine.getKeyManager().left2 && !check(getBoundleft()) &&xPosition>0&&((Math.abs(this.xPosition-GameState.player1.xPosition-5)<gameEngine.WIDTH-100)|| (GameState.player1.status==0))) {
                    animationLeft.tick();
                    animationNow = animationLeft;
                    xPosition -= movementSpeed;
                    side = "left";
                }
                if (gameEngine.getKeyManager().right2 && !check(getBoundright()) &&xPosition<3880&&((Math.abs(this.xPosition-GameState.player1.xPosition+5)<gameEngine.WIDTH-100)|| (GameState.player1.status==0))) {
                    animationRight.tick();
                    animationNow = animationRight;
                    xPosition += movementSpeed;
                    side = "right";
                }
                if(GameState.player1.status==1){
                    gameEngine.getCamera().centerOf2Player();
                }else {
                    gameEngine.getCamera().centerOfPlayer(this);
                }
            }
        }
    }

    @Override
    public void atkCheck(int whichPlayer) {
        weaponChange(whichPlayer);
        boolean fired =false;
        if (gameEngine.getKeyManager().atk2 && side.equals("left") && active() && !outOfAmmo) {
            sfx.get("shoot").play();
            new BulletLeft(xPosition - 20, yPosition + height / 2, 20, gameEngine,bulletType);
            fired =true;
        } else if (gameEngine.getKeyManager().atk2 && side.equals("right") && active()& !outOfAmmo) {
            sfx.get("shoot").play();
            new BulletRight(xPosition + 50, yPosition + height / 2, 20, gameEngine,bulletType);
            fired =true;
        } else if (gameEngine.getKeyManager().atk2 && side.equals("up") && active()& !outOfAmmo) {
            sfx.get("shoot").play();
            new BulletUp(xPosition + width / 2, yPosition - height, 20, gameEngine,bulletType);
            fired =true;
        } else if (gameEngine.getKeyManager().atk2 && side.equals("down") && active()& !outOfAmmo) {
            sfx.get("shoot").play();
            new BulletDown(xPosition + width / 2, yPosition + height, 20, gameEngine,bulletType);
            fired =true;
        }
        if (bulletType == 1 && fired) {
            nowBullet = gunBullet;
            gunBullet--;
            if (gunBullet == 0)
                outOfAmmo = true;
        }
        if (bulletType == 2 && fired) {
            nowBullet = akBullet;
            akBullet--;
            if (akBullet == 0)
                outOfAmmo = true;
        }
        if (bulletType == 3 && fired) {
            nowBullet = shotgunBullet;
            shotgunBullet--;
            if (shotgunBullet == 0)
                outOfAmmo = true;
        }

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
            animationDown = new Animation(180, Assets.player2_down);
            animationNow = new Animation(180, Assets.player2_down);
            animationUp = new Animation(180, Assets.player2_up);
            animationRight = new Animation(180, Assets.player2_right);
            animationLeft = new Animation(180, Assets.player2_left);
            if (side.equals("left"))
                animationNow = new Animation(180, Assets.player2_left);
            else if (side.equals("right"))
                animationNow = new Animation(180, Assets.player2_right);
            else if (side.equals("up"))
                animationNow = new Animation(180, Assets.player2_up);
            else if (side.equals("down"))
                animationNow = new Animation(180, Assets.player2_down);
            gun1 = true;
            gun2 = false;
            gun3 = false;

        }
        if (gun >=6  && gun <= 13 && !gun2) {
            nowBullet =akBullet;
            if (akBullet == 0) {
                outOfAmmo = true;
            } else if (akBullet > 0) {
                outOfAmmo = false;
            }
            cooldown = 100;
            bulletType = 2;
            animationDown = new Animation(180, Assets.player2AK_down);
            animationNow = new Animation(180, Assets.player2AK_down);
            animationUp = new Animation(180, Assets.player2AK_up);
            animationRight = new Animation(180, Assets.player2AK_right);
            animationLeft = new Animation(180, Assets.player2AK_left);
            if (side.equals("left"))
                animationNow = new Animation(180, Assets.player2AK_left);
            else if (side.equals("right"))
                animationNow = new Animation(180, Assets.player2AK_right);
            else if (side.equals("up"))
                animationNow = new Animation(180, Assets.player2AK_up);
            else if (side.equals("down"))
                animationNow = new Animation(180, Assets.player2AK_down);
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
            animationDown = new Animation(180, Assets.player2Shotgun_down);
            animationUp = new Animation(180, Assets.player2Shotgun_up);
            animationRight = new Animation(180, Assets.player2Shotgun_right);
            animationLeft = new Animation(180, Assets.player2Shotgun_left);

            if (side.equals("left"))
                animationNow = new Animation(180, Assets.player2Shotgun_left);
            else if (side.equals("right"))
                animationNow = new Animation(180, Assets.player2Shotgun_right);
            else if (side.equals("up"))
                animationNow = new Animation(180, Assets.player2Shotgun_up);
            else if (side.equals("down"))
                animationNow = new Animation(180, Assets.player2Shotgun_down);

            gun1 = false;
            gun2 = false;
            gun3 = true;
        }


    }
    @Override
    public String toString() {
        return "Player2";
    }
}
