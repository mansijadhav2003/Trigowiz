package main;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {

    @FXML
    private Button aboutUsButton;

    @FXML
    private Button trigCalculatorButton;

    @FXML
    private Button trigFormulaeButton;

    @FXML
    private Button trigFuncGrapherButton;

    @FXML
    private Button trigUnitCircleButton;

    @FXML
    void changeScene1(ActionEvent event) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("TrigFormulaeScene.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Trignometric Formulae");
            window.setScene(new Scene(parent, 1000, 700));
            window.show();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeScene2(ActionEvent event) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("TrigCalcScene.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Trigonometric Calculator");
            window.setScene(new Scene(parent, 1000, 700));
            window.show();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeScene3(ActionEvent event) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("TrigFuncGrapherScene.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Trigonometric Function Grapher");
            window.setScene(new Scene(parent, 1000, 700));
            window.show();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeScene4(ActionEvent event) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("TrigUnitCircleScene.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Trigonometric Unit Circle");
            window.setScene(new Scene(parent, 1000, 700));
            window.show();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeScene5(ActionEvent event) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("aboutUsScene.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("About Us");
            window.setScene(new Scene(parent, 1000, 700));
            window.show();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
