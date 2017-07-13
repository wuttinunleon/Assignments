package Enit;

import Assets.Animation;
import Game.GameEngine;
import Item.ControllerItem;
import State.GameState;
import State.MainMenuState;

import java.awt.image.BufferedImage;

/**
 * Created by duckk on 9/4/2560.
 */
public class Player1  extends Player{
    public Player1(GameEngine gameEngine, float x, float y, BufferedImage texture) {
        super(gameEngine, x, y, texture);


    }

    @Override
    public void tick() {
        {
            atkCheck(1);

            for (int i = 0; i < ControllerItem.items.size(); i++) {

                if (this.getBound().intersects(ControllerItem.items.get(i).getBound())) {
                    if (!ControllerItem.items.get(i).heal) {
                        if ((int) (Math.random() * 3) > 1) {
                            akBullet += ControllerItem.items.get(i).getNumOfBullet() * 3;
                            nowBullet = akBullet;
                        } else
                            shotgunBullet += ControllerItem.items.get(i).getNumOfBullet();
                            nowBullet =shotgunBullet;
                        ControllerItem.items.remove(i);
                    } else {
                        setHealth(200);
                        ControllerItem.items.remove(i);

                    }

                }
            }

            if(MainMenuState.game==2) {

                if (gameEngine.getKeyManager().up && !check(getBoundup()) &&yPosition>0 && (Math.abs(this.yPosition - GameState.player2.yPosition - 5) < gameEngine.HEIGHT - 100 || GameState.player2.status == 0)) {
                    animationUp.tick();
                    animationNow = animationUp;
                    yPosition -= movementSpeed;
                    side = "up";
                }
                if (gameEngine.getKeyManager().down && !check(getBounddown()) &&yPosition<3880&& (Math.abs(this.yPosition - GameState.player2.yPosition + 5) < gameEngine.HEIGHT - 100 || GameState.player2.status == 0)) {
                    animationDown.tick();
                    animationNow = animationDown;
                    yPosition += movementSpeed;
                    side = "down";
                }
                if (gameEngine.getKeyManager().left && !check(getBoundleft()) &&xPosition>0&& ((Math.abs(this.xPosition - GameState.player2.xPosition - 5) < gameEngine.WIDTH - 100) || (GameState.player2.status == 0))) {
                    animationLeft.tick();
                    animationNow = animationLeft;
                    xPosition -= movementSpeed;
                    side = "left";
                }
                if (gameEngine.getKeyManager().right && !check(getBoundright()) &&xPosition<3880&& ((Math.abs(this.xPosition - GameState.player2.xPosition + 5) < gameEngine.WIDTH - 100) || (GameState.player2.status == 0))) {
                    animationRight.tick();
                    animationNow = animationRight;
                    xPosition += movementSpeed;
                    side = "right";
                }
            }else
                { if (gameEngine.getKeyManager().up && !check(getBoundup()) &&yPosition>0 ) {
                animationUp.tick();
                animationNow = animationUp;
                yPosition -= movementSpeed;
                side = "up";
            }
                if (gameEngine.getKeyManager().down && !check(getBounddown())&&yPosition<3880 ) {
                    animationDown.tick();
                    animationNow = animationDown;
                    yPosition += movementSpeed;
                    side = "down";
                }
                if (gameEngine.getKeyManager().left && !check(getBoundleft()) &&xPosition>0) {
                    animationLeft.tick();
                    animationNow = animationLeft;
                    xPosition -= movementSpeed;
                    side = "left";
                }
                if (gameEngine.getKeyManager().right && !check(getBoundright())&&xPosition<3880) {
                    animationRight.tick();
                    animationNow = animationRight;
                    xPosition += movementSpeed;
                    side = "right";
                }}
            if(MainMenuState.game==2){
                if(GameState.player2.status == 1)
                gameEngine.getCamera().centerOf2Player();
                else
                gameEngine.getCamera().centerOfPlayer(this);
            }else gameEngine.getCamera().centerOfPlayer(this);
        }
    }

    @Override
    public String toString() {
        return "Player1";
    }
}
