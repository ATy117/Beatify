package view.Artist;

import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.controllerDashboard;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;
import view_builders.*;
import view_builders.Artist.builderNotifications_ArtistNotification;

import java.io.IOException;

public class viewNotifs_ArtistNotifications extends View {

    public controllerNotifs_ArtistNotifications controller;

    @FXML JFXListView contentListView;
    @FXML AnchorPane mainPane;

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

        init();
        Update();
    }

    @Override
    public void Update() {

        Platform.runLater( () -> {
            contentListView.getItems().clear();

            builderNotification builder = new builderNotifications_ArtistNotification(controller);
            Director director = Director.getInstance();
            director.setBuilder(builder);
            director.construct();
            for (Object object: builder.getProduct()){
                AnchorPane anchorPane = (AnchorPane)object;
                contentListView.getItems().add(anchorPane);
            }

            controller.markAllAsViewed();
        });

    }

    public void init(){
        mainPane.getStylesheets().add("view/theme.css");
    }
}
