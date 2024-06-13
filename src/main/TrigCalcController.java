package main;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class TrigCalcController {

    @FXML
    private CheckBox cosCheckBox;

    @FXML
    private CheckBox cosecCheckBox;

    @FXML
    private CheckBox cotCheckBox;

    @FXML
    private TextField enterAngleTextField;

    @FXML
    private LineChart<Number, Number> graphLineChart;

    @FXML
    private Label resultLabel;

    @FXML
    private CheckBox secCheckBox;

    @FXML
    private CheckBox sinCheckBox;

    @FXML
    private CheckBox tanCheckBox;

    @FXML
    private HBox graphLayout;


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

    @FXML
    void cosCheckBoxListener(ActionEvent event) {

        if (cosCheckBox.isSelected()) {
                 
                sinCheckBox.setDisable(true);
                tanCheckBox.setDisable(true);
                cotCheckBox.setDisable(true);
                secCheckBox.setDisable(true);
                cosecCheckBox.setDisable(true);
            } else {
                 
                sinCheckBox.setDisable(false);
                tanCheckBox.setDisable(false);
                cotCheckBox.setDisable(false);
                secCheckBox.setDisable(false);
                cosecCheckBox.setDisable(false);
            }
    }

    @FXML
    void cosecCheckBoxListener(ActionEvent event) {

        if (cosecCheckBox.isSelected()) {
                 
                cosCheckBox.setDisable(true);
                tanCheckBox.setDisable(true);
                cotCheckBox.setDisable(true);
                secCheckBox.setDisable(true);
                sinCheckBox.setDisable(true);
            } else {
                 
                cosCheckBox.setDisable(false);
                tanCheckBox.setDisable(false);
                cotCheckBox.setDisable(false);
                secCheckBox.setDisable(false);
                sinCheckBox.setDisable(false);
            }
    }

    @FXML
    void cotCheckBoxListener(ActionEvent event) {

        if (cotCheckBox.isSelected()) {
                 
                cosCheckBox.setDisable(true);
                tanCheckBox.setDisable(true);
                sinCheckBox.setDisable(true);
                secCheckBox.setDisable(true);
                cosecCheckBox.setDisable(true);
            } else {
                 
                cosCheckBox.setDisable(false);
                tanCheckBox.setDisable(false);
                sinCheckBox.setDisable(false);
                secCheckBox.setDisable(false);
                cosecCheckBox.setDisable(false);
            }
    }

    @FXML
    void secCheckBoxListener(ActionEvent event) {

        if (secCheckBox.isSelected()) {
                 
                cosCheckBox.setDisable(true);
                tanCheckBox.setDisable(true);
                cotCheckBox.setDisable(true);
                sinCheckBox.setDisable(true);
                cosecCheckBox.setDisable(true);
            } else {
                 
                cosCheckBox.setDisable(false);
                tanCheckBox.setDisable(false);
                cotCheckBox.setDisable(false);
                sinCheckBox.setDisable(false);
                cosecCheckBox.setDisable(false);
            }
    }

    @FXML
    void sinCheckBoxListener(ActionEvent event) {
        if (sinCheckBox.isSelected()) {
                 
                cosCheckBox.setDisable(true);
                tanCheckBox.setDisable(true);
                cotCheckBox.setDisable(true);
                secCheckBox.setDisable(true);
                cosecCheckBox.setDisable(true);
            } else {
                 
                cosCheckBox.setDisable(false);
                tanCheckBox.setDisable(false);
                cotCheckBox.setDisable(false);
                secCheckBox.setDisable(false);
                cosecCheckBox.setDisable(false);
            }
    }

    @FXML
    void tanCheckBoxListener(ActionEvent event) {

        if (tanCheckBox.isSelected()) {
                 
                cosCheckBox.setDisable(true);
                sinCheckBox.setDisable(true);
                cotCheckBox.setDisable(true);
                secCheckBox.setDisable(true);
                cosecCheckBox.setDisable(true);
            } else {
                 
                cosCheckBox.setDisable(false);
                sinCheckBox.setDisable(false);
                cotCheckBox.setDisable(false);
                secCheckBox.setDisable(false);
                cosecCheckBox.setDisable(false);
            }
    }

    @FXML
    void calculate(ActionEvent event) {
        try {
            double angle = Double.parseDouble(enterAngleTextField.getText());
            if(angle <= 360 && angle >= -360){
                String selectedFunction = "";
                double result = 0;

                if (sinCheckBox.isSelected()) {
                    selectedFunction = "sin";
                } else if (cosCheckBox.isSelected()) {
                    selectedFunction = "cos";
                } else if (tanCheckBox.isSelected()) {
                    selectedFunction = "tan";
                } else if (cotCheckBox.isSelected()) {
                    selectedFunction = "cot";
                } else if (secCheckBox.isSelected()) {
                    selectedFunction = "sec";
                } else if (cosecCheckBox.isSelected()) {
                    selectedFunction = "csc";
                } else {
                    resultLabel.setText("Please select a function.");
                    return;
                }

                updateGraph();
                XYChart.Series<Number, Number> series = new XYChart.Series<>();
                graphLineChart.getData().add(series);
                graphLineChart.setCreateSymbols(false);
                graphLineChart.setVerticalZeroLineVisible(true);
                graphLineChart.setHorizontalZeroLineVisible(true);
                

                series.getData().clear(); 

                double start, end, step = 1.0;
                if (angle < 0) {
                    start = angle;
                    end = 0;
                } else {
                    start = 0;
                    end = angle;
                }

                for (double x = start; x <= end; x += step) {
                    double radian = Math.toRadians(x);
                    double y = 0.0;

                    switch (selectedFunction) {
                        case "sin":
                            y = Math.sin(radian);
                            break;
                        case "cos":
                            y = Math.cos(radian);
                            break;
                        case "tan":
                            if (Math.abs(Math.cos(radian)) < 1e-10) {
                                
                                y = Double.NaN;
                            } else {
                                y = Math.tan(radian);
                            }
                            break;
                        case "cot":
                            if (Math.abs(Math.sin(radian)) < 1e-10) {
                                
                                y = Double.NaN;
                            } else {
                                y = 1.0 / Math.tan(radian);
                            }
                            break;
                        case "sec":
                            if (Math.abs(Math.cos(radian)) < 1e-10) {
                                
                                y = Double.NaN;
                            } else {
                                y = 1.0 / Math.cos(radian);
                            }
                            break;
                        case "csc":
                            if (Math.abs(Math.sin(radian)) < 1e-10) {
                                
                                y = Double.NaN;
                            } else {
                                y = 1.0 / Math.sin(radian);
                            }
                            break;
                    }

                    result = y;
                    series.getData().add(new XYChart.Data<>(x, y));
                }

                String formattedNumber = String.format("%.4f", result);
                resultLabel.setText("Answer: " + formattedNumber);

                graphLayout.getChildren().clear();
                graphLayout.getChildren().add(graphLineChart);
            }else{
                resultLabel.setText("Please enter value between -360 to 360");
            }

        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid angle.");
        }
    }

    void updateGraph(){
        NumberAxis xAxis = new NumberAxis(-360, 360, 45);
        NumberAxis yAxis = new NumberAxis(-2, 2, 0.1);
        graphLineChart = new LineChart<>(xAxis, yAxis);
    }

}
