package view.Artist;

import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;
import view_builders.*;
import view_builders.Artist.builderNotifications_ArtistNotification;

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

        builderNotification builder = new builderNotifications_ArtistNotification(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            notificationsListView.getItems().add(anchorPane);
        }

        controller.markAllAsViewed();
    }
}
