package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerArtists_ListenerFollowedArtists;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderUser;

import java.util.ArrayList;
import java.util.List;

public class builderArtist_ListenerFollowedArtists extends builderUser<AnchorPane> {

    private controllerArtists_ListenerFollowedArtists controller;

    public builderArtist_ListenerFollowedArtists(controllerArtists_ListenerFollowedArtists controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getProfileModel().getFollowedArtists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button unfollowButton = new Button("Unfollow");
            unfollowButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(unfollowButton);
            popup.setPopupContent(content);

            unfollowButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
