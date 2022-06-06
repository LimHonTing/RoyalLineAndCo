package com.example.royallineandco;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavigationController implements Initializable {
    private NavigationDatabase a = new NavigationDatabase();
    private String path ="";
    @FXML private TextArea Direction;
    @FXML private Button BackButton;
    @FXML private ComboBox<String> CurrentLocationButton;
    @FXML private ComboBox DestinationButton;
    @FXML private Button SearchButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        a.retrieve();
        ObservableList<String> places = FXCollections.observableArrayList();
        Vertex start = a.graph.head;
        while(start!=null){
            places.add((String) start.vertexInfo);
            start = start.nextVertex;
        }
        CurrentLocationButton.setItems(places);
        DestinationButton.setItems(places);
    }

    public void SearchButtonClicked(MouseEvent mouseEvent) throws IOException {
        String origin = CurrentLocationButton.getValue();
        String destination = DestinationButton.getValue().toString();
        a.retrieve();
        Direction.setText(a.graph.bfs(origin,destination));
    }

    public void goToHomePage(MouseEvent mouseEvent) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Home-Page.fxml"));
        Stage window = (Stage) BackButton.getScene().getWindow();
        window.setScene(new Scene(loader));
    }

}
