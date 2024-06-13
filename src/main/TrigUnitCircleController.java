package main;

import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TrigUnitCircleController {

    @FXML
    private Label angleLabel;

    @FXML
    private Label sinLabel;

    @FXML
    private Label cosLabel;

    @FXML
    private Label tanLabel;

    @FXML
    private Label cotLabel;

    @FXML
    private Label secLabel;

    @FXML
    private Label cosecLabel;

    @FXML
    private Slider angleSlider;

    @FXML
    private Circle circleShape;

    @FXML
    private Line angleMakerLineShape;

    private static final int radius = 200;

    @FXML
    void changeScene(javafx.event.ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Trigowiz");
            window.setScene(new Scene(parent, 1000, 700));
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        // Initialize your application here.
        angleSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double angle = Math.round(newValue.doubleValue() / 15) * 15; // Round to the nearest 15-degree interval
            angleSlider.setValue(angle); // Set the slider's value to the rounded angle
            updateTrigonometricValues(angle);
        });
    }

    private void updateTrigonometricValues(double angle) {
        // Round the angle to the nearest 15-degree interval
        double roundedAngle = Math.round(angle / 15) * 15;

        // Update the angle label with the rounded angle
        angleLabel.setText("Angle: " + String.format("%.2f°", roundedAngle));

        // Calculate trigonometric values using the rounded angle.
        double radianAngle = Math.toRadians(roundedAngle);
        double sinValue = Math.sin(radianAngle);
        double cosValue = Math.cos(radianAngle);
        double tanValue = Math.tan(radianAngle);

        // Update labels with calculated values.
        if(sinValue < 99999999 && sinValue > -99999999){
            sinLabel.setText("Sine : " + String.format("%.4f", sinValue));
        }else{
            sinLabel.setText("Sine : Infinity");
        }

        if(cosValue < 99999999 && cosValue > -99999999){
            cosLabel.setText("Cosine : " + String.format("%.4f", cosValue));
        }else{
            cosLabel.setText("Cosine : Infinity");
        }

        if(tanValue < 99999999 && tanValue > -99999999){
            tanLabel.setText("Tangent : " + String.format("%.4f", tanValue));
        }else{
            tanLabel.setText("Tangent : Infinity");
        }
        // Calculate cotangent, secant, and cosecant.
        double cotValue = 1.0 / tanValue;
        double secValue = 1.0 / cosValue;
        double cosecValue = 1.0 / sinValue;

        if(cotValue < 99999999 && cotValue > -999999999){
            cotLabel.setText("Cotangent : " + String.format("%.4f", cotValue));
        }else{
            cotLabel.setText("Cotangent : Infinity");
        }
        if(secValue < 99999999 && secValue > -999999999){
            secLabel.setText("Secant : " + String.format("%.4f", secValue));
        }else{
            secLabel.setText("Secant : Infinity");
        }
        
        if(cosecValue < 99999999 && cosecValue > -99999999){
            cosecLabel.setText("Cosecant : " + String.format("%.4f", cosecValue));
        }else{
            cosecLabel.setText("Cosecant : Infinity");
        }

        // Update the position and size of the angle maker line on the unit circle.
        double circleRadius = radius;
        double centerX = circleShape.getCenterX() - 100;
        double centerY = circleShape.getCenterY()+0.8;

        // Calculate the end coordinates of the line based on the circle's radius.
        double lineLength = circleRadius * 0.8; // Adjust the line length as needed.
        double endX = centerX + lineLength * Math.cos(radianAngle);
        double endY = centerY - lineLength * Math.sin(radianAngle);

        angleMakerLineShape.setStartX(centerX);
        angleMakerLineShape.setStartY(centerY);
        angleMakerLineShape.setEndX(endX);
        angleMakerLineShape.setEndY(endY);
    }
}
