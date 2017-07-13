package Game;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import Display.Display;

import java.awt.*;

public class Main extends Application{
    MediaPlayer mediaplayer;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {

        new GameEngine().start();


    }
}
