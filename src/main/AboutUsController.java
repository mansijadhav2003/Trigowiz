package main;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutUsController {

    @FXML
    private Button backButton;

    @FXML
    void changeScene(ActionEvent event) {

        try{
            Parent parent = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Trigowiz");
            window.setScene(new Scene(parent, 1000, 700));
            window.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
