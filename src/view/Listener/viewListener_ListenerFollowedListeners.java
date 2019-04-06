package view.Listener;

import controller.controllerDashboard;
import controller.Listener.controllerListener_ListenerFollowedListeners;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewListener_ListenerFollowedListeners extends View {

    public controllerListener_ListenerFollowedListeners controller;

    public viewListener_ListenerFollowedListeners(AnchorPane mainPane, controllerListener_ListenerFollowedListeners controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateListeners.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(){

    }
}