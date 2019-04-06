package view.Listener;

import controller.controllerDashboard;
import controller.Listener.controllerSearchables_ListenerAllSearchResults;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSearchables_ListenerAllSearchResults extends View {

    public controllerSearchables_ListenerAllSearchResults controller;

    public viewSearchables_ListenerAllSearchResults(AnchorPane mainPane, controllerSearchables_ListenerAllSearchResults controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSearchable.fxml"));
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
