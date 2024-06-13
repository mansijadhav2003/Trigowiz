package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TrigFormulaeController {

    @FXML
    private Button backButton;

    @FXML
    private Button cofunctionButton;

    @FXML
    private Button degToRadButton;

    @FXML
    private ImageView displayImageView;

    @FXML
    private Button doubleAngleButton;

    @FXML
    private Button evenOddButton;

    @FXML
    private Button halfAngleButton;

    @FXML
    private Button periodicFormulasButton;

    @FXML
    private Button productSumButton;

    @FXML
    private Button pythagoreanIdentitiesButton;

    @FXML
    private Button reciprocalIdentitiesButton;

    @FXML
    private Button sumDiffButton;

    @FXML
    private Button sumProductButton;

    @FXML
    private Button unitCircleButton;

    @FXML
    void cofunction(ActionEvent event) {

        String imagePath = "Images/Formulas/Cofunction .jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void degToRad(ActionEvent event) {

        String imagePath = "Images/Formulas/DegreeToRadians.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void doubleAngleButton(ActionEvent event) {

        String imagePath = "Images/Formulas/DoubleAngle.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void evenOddButton(ActionEvent event) {

        String imagePath = "Images/Formulas/EvenandOdd.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void halfAngle(ActionEvent event) {

        String imagePath = "Images/Formulas/HalfAngle.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void periodicFormulas(ActionEvent event) {

        String imagePath = "Images/Formulas/Periodic.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void productSum(ActionEvent event) {

        String imagePath = "Images/Formulas/ProducttoSum.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pythagoreanIdentities(ActionEvent event) {

        String imagePath = "Images/Formulas/PythagoreanIdentities.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void reciprocalIdentities(ActionEvent event) {

        String imagePath = "Images/Formulas/ReciprocalIdentities.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void sumDiff(ActionEvent event) {

        String imagePath = "Images/Formulas/SumandDifference.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void sumProduct(ActionEvent event) {

        String imagePath = "Images/Formulas/SumtoProduct.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void unitCircle(ActionEvent event) {

        String imagePath = "Images/Formulas/UnitCircleDef.jpg";
        try {
            FileInputStream imageStream = new FileInputStream(imagePath);
            Image image = new Image(imageStream);
            displayImageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
