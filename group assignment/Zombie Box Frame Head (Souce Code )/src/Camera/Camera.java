package Camera;

import Enit.Enitity;
import Game.GameEngine;

/**
 * Created by Jobkung3d on 3/24/2017.
 */
public class Camera {

    private GameEngine gameEngine;
    private float xOffset;
    private float yOffset;

    private Enitity player1;
    private Enitity player2;

    public Camera(GameEngine gameEngine,float xOffset , float yoffset){
        this.xOffset = xOffset;
        this.yOffset = yoffset;
        this.gameEngine = gameEngine;
    }

    public void centerOfPlayer(Enitity player){
        if(player.xPosition+gameEngine.getWIDTH()/2 < 3840 && player.xPosition-gameEngine.getWIDTH()/2 > 0){
        xOffset = player.xPosition-gameEngine.getWIDTH()/2;
        }
        if(player.yPosition+gameEngine.getHEIGHT()/2 < 3840 && player.yPosition-gameEngine.getHEIGHT()/2 > 0){
            yOffset = player.yPosition-gameEngine.getHEIGHT()/2;
        }
    }
    public void centerOf2Player(){
        if((this.player1.xPosition+this.player2.xPosition+gameEngine.getWIDTH())/2 < 3840 && (this.player1.xPosition+this.player2.xPosition-gameEngine.getWIDTH())/2 > 0){
            xOffset = (this.player1.xPosition+this.player2.xPosition-gameEngine.getWIDTH())/2;
        }

        if((this.player1.yPosition+this.player2.yPosition+gameEngine.getHEIGHT())/2 < 3840 && (this.player1.yPosition+this.player2.yPosition-gameEngine.getHEIGHT())/2 > 0){
            yOffset = (this.player1.yPosition+this.player2.yPosition-gameEngine.getHEIGHT())/2;
        }

    }
    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public void setPlayer1(Enitity player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Enitity player2) {
        this.player2 = player2;
    }
}
