package view.Artist;

import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerListener_ArtistFollowedListeners;
import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import view.View;
import view_builders.*;

import java.io.IOException;

public class viewNotifs_ArtistNotifications extends View {

    public controllerNotifs_ArtistNotifications controller;

    @FXML JFXListView notificationsListView;


    public viewNotifs_ArtistNotifications(AnchorPane mainPane, controllerNotifs_ArtistNotifications controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateNotifications.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Update() {

        notificationsListView.getItems().clear();

        builderNotification builder = new builderNotifications_Users();
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            notificationsListView.getItems().add(anchorPane);
        }

    }
}
