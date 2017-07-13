package Item;

import Game.GameEngine;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by duckk on 14/4/2560.
 */
public class ControllerItem {
    public static ArrayList<Item> items = new ArrayList<>();


    public void tick(){

    }
    public void render(Graphics graphics){
        for (Item i:items) {

            i.render(graphics);

        }
    }
}
