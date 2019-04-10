package view.Listener;

import controller.controllerDashboard;
import controller.Listener.controllerListener_ListenerFollowedListeners;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import view.View;
import view_builders.Artist.builderListener_ArtistFollowedListeners;
import view_builders.Director;
import view_builders.Listener.builderListener_ListenerFollowedListeners;
import view_builders.builderUser;

import java.io.IOException;

public class viewListener_ListenerFollowedListeners extends View {

    public controllerListener_ListenerFollowedListeners controller;

    @FXML AnchorPane listenerHeader;
    @FXML AnchorPane listenerContent;

    private Label headerLabel;
    private TilePane listenerList;

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

        initHeader();
        Update();
    }

    @Override
    public void Update(){

        listenerContent.getChildren().clear();

        listenerList = new TilePane();

        builderUser builder = new builderListener_ListenerFollowedListeners(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            listenerList.getChildren().add(anchorPane);
        }

        listenerContent.getChildren().add(listenerList);

    }

    public void initHeader(){
        headerLabel = new Label("All Followed Listeners");

        headerLabel.setFont(Font.font("Comfortaa", 18));

        listenerHeader.setLeftAnchor(headerLabel, 252.0);
        listenerHeader.setTopAnchor(headerLabel, 23.0);

        listenerHeader.getChildren().add(headerLabel);

    }
}
