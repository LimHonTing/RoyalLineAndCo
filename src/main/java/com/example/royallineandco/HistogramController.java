package com.example.royallineandco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

public class HistogramController implements Initializable {
    @FXML private Button BackButton;
    @FXML private BarChart Histogram;
    private HistogramDatabase a = new HistogramDatabase();


    public void goToHomePage(MouseEvent mouseEvent) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Home-Page.fxml"));
        Stage window = (Stage) BackButton.getScene().getWindow();
        window.setScene(new Scene(loader));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        a.retrieveNumberOfData();
        a.retrieveData();
        double[] data = a.getData();
        int bin = a.getBin();

        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Passenger",data,bin);
        JFreeChart histogram = ChartFactory.createHistogram("Passenger Flow Histogram","Number of Passenger", "Frequency", dataset, PlotOrientation.VERTICAL, true, true, false);

        try {
            ChartUtilities.saveChartAsPNG(new File("C:/Users/Hon TIng/IdeaProjects/RoyalLineAndCo/src/main/resources/com/example/royallineandco/fxml-image/histogram.png"), histogram, 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
