package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import object.User;

import java.util.ArrayList;
import java.util.List;

public class builderArtist_ArtistSearchArtist extends builderUser<AnchorPane> {

    private controllerSearchables_ArtistAllSearchResults controller;

    public builderArtist_ArtistSearchArtist(controllerSearchables_ArtistAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getArtistResults();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            User user = listElements.next();
            AnchorPane albumIndiv = new AnchorPane();
            Circle userPic = new Circle(45);
            Label text = new Label(user.getUsername());

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button followButton = new Button("Follow");
            followButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(followButton);
            popup.setPopupContent(content);

            albumIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                            popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                        }
                    }
                }
            });

            followButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.followUser(user.getUser_id())) {
                        popup.hide();
                    } else {
                        System.out.println("Already Following That Artist");
                    }
                }
            });

            albumIndiv.setLeftAnchor(userPic, 20.0);
            albumIndiv.setTopAnchor(userPic, 13.0);
            albumIndiv.setTopAnchor(text, 102.0);
            albumIndiv.setLeftAnchor(text, 24.0);

            albumIndiv.getChildren().add(userPic);
            albumIndiv.getChildren().add(text);

            userPic.setFill(new ImagePattern(new Image(user.getAvatarURL().toURI().toString())));

            listProducts.add(albumIndiv);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
