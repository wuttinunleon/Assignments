
package World;


import Assets.Assets;
import Enit.*;
import EntityManger.EnitityManager;
import Game.GameEngine;
import Tile.Tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Map {

    private int tiles[][];
    private GameEngine gameEngine;
    private EnitityManager enitityManager;


    public Map(GameEngine gameEngine){
        this.gameEngine = gameEngine;
         loadMap();
         enitityManager = new EnitityManager();
        gameEngine.setMap(this);
        getEnitityManager().addEntities(new House(gameEngine,1280,320,Assets.house));
        getEnitityManager().addEntities(new House(gameEngine,2200,320,Assets.house));
        getEnitityManager().addEntities(new House(gameEngine,3200,320,Assets.house));
        getEnitityManager().addEntities(new Car(gameEngine,3000,960,Assets.car));
        getEnitityManager().addEntities(new Car(gameEngine,1500,1280,Assets.car));
        getEnitityManager().addEntities(new Car(gameEngine,2500,1500,Assets.car));
        getEnitityManager().addEntities(new Car(gameEngine,700,1400,Assets.car));

    }

    public void tick(){
        enitityManager.tick();

    }

    public EnitityManager getEnitityManager() {
        return enitityManager;
    }

    public void render(Graphics graphics){
            for (int i = 0; i < 60; i++) {
                for (int j = 0; j < 60; j++) {
                    Tile.tiles[tiles[i][j]].render(graphics, (int) (j * Tile.width - gameEngine.getCamera().getxOffset()), (int) (i * Tile.height - gameEngine.getCamera().getyOffset()));

                }
            }
        enitityManager.render(graphics);
    }


    public void loadMap(){

        Scanner input=null;
        tiles = new int[60][60];

        InputStream in = getClass().getResourceAsStream("/map.txt");
        BufferedReader inputA = new BufferedReader(new InputStreamReader(in));
        int i=0,j=0,k=0;
        try {
            input = new Scanner(inputA);
            while (input.hasNext()){
                if(k==60) {
                k=0;
                j=0;
                i++;
                }
                tiles[i][j]=Integer.parseInt(input.next());
                k++;
                j++;
            }
        }catch (Exception e){

            e.printStackTrace();
        }


    }
}