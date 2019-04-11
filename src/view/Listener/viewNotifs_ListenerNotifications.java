package view.Listener;

import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.Listener.controllerNotifs_ListenerNotifications;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;
import view_builders.Artist.builderNotifications_ArtistNotification;
import view_builders.Director;
import view_builders.Listener.builderNotification_ListenerNotification;
import view_builders.builderNotification;

import java.io.IOException;

public class viewNotifs_ListenerNotifications extends View {

    public controllerNotifs_ListenerNotifications controller;

    @FXML JFXListView contentListView;
    @FXML AnchorPane mainPane;


    public viewNotifs_ListenerNotifications(AnchorPane mainPane, controllerNotifs_ListenerNotifications controller, controllerDashboard dashboardController){
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

    }

    @Override
    public void Update() {

        contentListView.getItems().clear();

        builderNotification builder = new builderNotification_ListenerNotification(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            contentListView.getItems().add(anchorPane);
        }

        controller.markAllAsViewed();
    }

    public void init(){
        mainPane.getStylesheets().add("view/theme.css");
    }
}
