package Tile;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[128];
    public static Tile grassTile = new GrassTile(0);
    public static Tile It = new It(1);
    public static Tile road = new RoadTile(2);
    public static Tile road2 = new RoadTile2(3);
    public static Tile road3 = new RoadTile3(4);
    public static Tile road4 = new RoadTile4(5);
    public static Tile road5 = new RoadTile5(6);
    public static Tile road6 = new RoadTile6(7);
    public static Tile road7 = new RoadTile7(8);
    static public final int width=64;
    static public final int height=64;
    public int id;
    public BufferedImage texture;

    Tile(BufferedImage texture, int id){
        this.id =id;
        this.texture = texture;
        tiles[id]=this;
    }
    public void tick(){

    }
    public void render(Graphics graphics,int x, int y){
        graphics.drawImage(texture,x,y,width,height,null);
    }
}
