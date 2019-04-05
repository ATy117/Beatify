package view;

import controller.controllerListener_ListenerFollowedListeners;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewListener_ListenerFollowedListeners extends View {

    public controllerListener_ListenerFollowedListeners controller;

    public viewListener_ListenerFollowedListeners(AnchorPane mainPane, ModelCentral model, controllerListener_ListenerFollowedListeners controller){
        this.controller = controller;
        this.model = model;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateListener.fxml"));
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
