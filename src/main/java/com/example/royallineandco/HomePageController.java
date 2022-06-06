package com.example.royallineandco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    @FXML private Button BackButton;
    @FXML private Button HistogramButton;
    @FXML private Button NavigationButton;

    public void goToMainPage(MouseEvent mouseEvent) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Main-Page.fxml"));
        Stage window = (Stage) BackButton.getScene().getWindow();
        window.setScene(new Scene(loader));
    }

    public void goToNavigation(MouseEvent mouseEvent) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Navigation.fxml"));
        Stage window = (Stage) NavigationButton.getScene().getWindow();
        window.setScene(new Scene(loader));
    }

    public void goToHistogram(MouseEvent mouseEvent) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Histogram.fxml"));
        Stage window = (Stage) HistogramButton.getScene().getWindow();
        window.setScene(new Scene(loader));
    }
}
