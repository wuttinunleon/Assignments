package EntityManger;

import Enit.Enitity;
import Enit.Player;
import Game.GameEngine;

import java.awt.*;
import java.util.ArrayList;


public class EnitityManager {
    ArrayList<Enitity> enitities;

    Player player;
    public EnitityManager(){
        enitities = new ArrayList<Enitity>();
    }

    public  void  tick(){
        for (int i = 0; i <getEnitities().size() ; i++) {
            Enitity e = getEnitities().get(i);
            e.tick();
        }

    }
    public void  addEntities(Enitity e){
        enitities.add(e);
    }
    public void  render(Graphics graphics){
        for (int i = 0; i <getEnitities().size() ; i++) {
            if(getEnitities().get(i)!=null)
            getEnitities().get(i).render(graphics);
        }
    }

    public synchronized ArrayList<Enitity> getEnitities() {
        return enitities;
    }
}
