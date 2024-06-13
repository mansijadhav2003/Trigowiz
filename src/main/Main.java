package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        try{
            primaryStage.setResizable(false);
            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(root, 989, 689);
            primaryStage.getIcons().add(new Image("https://i.pinimg.com/736x/60/7c/30/607c309e30b2578417c249c85c64e7c6.jpg"));
            
            primaryStage.setTitle("Trigowiz");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }    
    }

    public static void main(String[] args) {
        launch(args);
    }
}
