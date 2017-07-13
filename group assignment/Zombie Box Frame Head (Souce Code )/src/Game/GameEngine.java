package Game;


import Assets.Assets;
import Camera.Camera;
import Display.Display;
import State.*;

import Sound.Sound;

import java.awt.*;
import java.awt.image.BufferStrategy;
import Input.KeyManager;
import World.Map;

import javax.swing.*;

public class GameEngine implements Runnable {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final int SCALE = 2;
    public static boolean gameRunning=false;

    private KeyManager keyManager;
    private Display display;
    private Graphics graphics;
    private BufferStrategy bufferStrategy;
    public static final String NAME = "FRAME IDIOT";

    StateManager gameState;
    StateManager mainMenuState;

    private Map map;
    Camera camera;

    private Thread thread;

    public void run(){
      init();
      int fps =200;
      double timePerTick = 1000000000/fps;
      double delta =0;
      long now;
      long lastTime = System.nanoTime();
      long timer = 0;
      int ticks = 0;
      while (gameRunning){
          now = System.nanoTime();
          delta += (now -lastTime)/timePerTick;
          timer += now -lastTime;
          lastTime =now;
          if(delta >= 1) {
              ticks++;
              tick();
              render();
              delta--;
          }

          if(timer >= 1000000000){
              ticks =0;
              timer = 0;
          }
      }
    }



    public void init(){

        new Assets();
        display = new Display();
        display.createWindow(WIDTH,HEIGHT);
        keyManager = new KeyManager();
        camera = new Camera(this,0,0);
             //////State mainmenu,game,setting
        mainMenuState = new MainMenuState(this);



        display.getWindow().addKeyListener(keyManager);


        StateManager.setRunningState(mainMenuState);
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void render(){

        bufferStrategy = display.getCanvas().getBufferStrategy();

        if (bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0,0,WIDTH,HEIGHT);
        if(StateManager.getRunningState()!=null){
            StateManager.getRunningState().render(graphics);
        }

        bufferStrategy.show();


    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public Camera getCamera() {
        return camera;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public void tick(){
        keyManager.tick();
        if(StateManager.getRunningState()!=null){
            StateManager.getRunningState().tick();
        }
    }

    public  synchronized void start(){
        if(gameRunning)
            return;;
        gameRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        gameRunning = false;
    }
}
