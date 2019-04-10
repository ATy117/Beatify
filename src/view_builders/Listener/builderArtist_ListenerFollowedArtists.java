package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerArtists_ListenerFollowedArtists;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import object.User;
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
            User user = listElements.next();
            AnchorPane albumIndiv = new AnchorPane();
            Circle userPic = new Circle(45);
            Label text = new Label(user.getFirst_name() + " " + user.getLast_name());

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

            albumIndiv.setLeftAnchor(userPic, 20.0);
            albumIndiv.setTopAnchor(userPic, 13.0);
            albumIndiv.setTopAnchor(text, 102.0);
            albumIndiv.setLeftAnchor(text, 24.0);

            albumIndiv.getChildren().add(userPic);
            albumIndiv.getChildren().add(text);

            text.setMaxWidth(130.0);
            text.setAlignment(Pos.CENTER);
            text.setWrapText(true);
            text.setTextAlignment(TextAlignment.CENTER);

            if(user.getAvatarURL()!=null)
                userPic.setFill(new ImagePattern(new Image(user.getAvatarURL().toURI().toString())));
            else
                userPic.setFill(new ImagePattern(new Image("resources/useryellowbluedefaultpic.png")));

            listProducts.add(albumIndiv);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
