package view;

import com.jfoenix.controls.JFXListView;
import controller.controllerDashboard;
import controller.controllerSong_MyQueue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.awt.*;
import java.io.IOException;

public class viewSong_MyQueue extends View{

    public controllerSong_MyQueue controller;

    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;

    public viewSong_MyQueue(AnchorPane mainPane, controllerSong_MyQueue controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/templateSong.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        initHeader();
        Update();
    }

    @Override
    public void Update(){
        songListView.getItems().clear();

    }

    public void initHeader(){
        Label headerLbl = new Label("Queue List");

        headerLbl.setFont(Font.font("Comfortaa", 22));

        songsHeader.setLeftAnchor(headerLbl, 250.0);
        songsHeader.setTopAnchor(headerLbl, 40.0);

        songsHeader.getChildren().add(headerLbl);
    }
}
