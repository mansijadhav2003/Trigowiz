package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TrigFuncGrapherController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button cosButton;

    @FXML
    private Button cosecButton;

    @FXML
    private Button cotButton;

    @FXML
    private HBox graphLayout;

    @FXML
    private LineChart<Number, Number> graphLineChart;

    private XYChart.Series<Number, Number> series;
    private int numberOfPoints = 720;

    @FXML
    private Button secButton;

    @FXML
    private Button sinButton;

    @FXML
    private Button tanButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NumberAxis xAxis = new NumberAxis(-300, 300, 30);
        NumberAxis yAxis = new NumberAxis(-2, 2, 0.5);
        xAxis.setLabel("X (degrees)");
        yAxis.setLabel("Y");
        graphLineChart.setCreateSymbols(true); // Disable symbol creation
        graphLineChart.setAlternativeRowFillVisible(false); // Disable row fill
        series = new XYChart.Series<>();
        graphLineChart.getData().add(series); // Add the series

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

    @FXML
    void cosWave(ActionEvent event) {

        plotFunction(Math::cos);
    }

    @FXML
    void cosecWave(ActionEvent event) {

        plotFunction(x -> {
            double result = 1.0 / Math.sin(x);
            return (result < -10 || result > 10) ? Double.NaN : result;
        });
    }

    @FXML
    void cotWave(ActionEvent event) {

        plotFunction(x -> {
            double result = 1.0 / Math.tan(x);
            return (result < -10 || result > 10) ? Double.NaN : result;
        });
    }

    @FXML
    void secWave(ActionEvent event) {

        plotFunction(x -> {
            double result = 1.0 / Math.cos(x);
            return (result < -10 || result > 10) ? Double.NaN : result;
        });
    }

    @FXML
    void sinWave(ActionEvent event) {

        plotFunction(Math::sin);
    }

    @FXML
    void tanWave(ActionEvent event) {

        plotFunction(x -> {
            double result = Math.tan(x);
            return (result < -10 || result > 10) ? Double.NaN : result;
        });
    }

    private void plotFunction(java.util.function.Function<Double, Double> function) {
        series.getData().clear();
        for (int i = 0; i <= numberOfPoints; i++) {
            double x = -360 + i * (720.0 / numberOfPoints);
            double y = function.apply(Math.toRadians(x));
            if (!Double.isNaN(y)) {
                series.getData().add(new XYChart.Data<>(x, y));
            }
        }
    }
}
