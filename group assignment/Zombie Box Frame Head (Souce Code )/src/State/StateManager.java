package State;

import Game.GameEngine;

import java.awt.*;

public abstract class StateManager {

    private static StateManager runningState=null;

    public GameEngine gameEngine;

    public StateManager() {

    }

    public static void setRunningState(StateManager runningState) {
        StateManager.runningState = runningState;
    }

    public static StateManager getRunningState() {
        return runningState;
    }

    public abstract void render(Graphics graphics);

    public abstract void tick();

    public abstract void init();

    public StateManager(GameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
    }
}
