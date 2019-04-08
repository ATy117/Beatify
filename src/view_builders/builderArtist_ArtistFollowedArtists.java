package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerArtist_ArtistFollowedArtists;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class builderArtist_ArtistFollowedArtists extends builderUser<AnchorPane> {

    public builderArtist_ArtistFollowedArtists(controllerArtist_ArtistFollowedArtists controller) {
        this.controller= controller;
        this.listElements = controller.getModel().getProfileModel().getFollowedArtists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {

            AnchorPane albumIndiv = new AnchorPane();
            Circle userPic = new Circle(45);
            Label text = new Label(listElements.next().getFirst_name() + " "+listElements.next().getLast_name());

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button unfollowButton = new Button("Unfollow");
            unfollowButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(unfollowButton);
            popup.setPopupContent(content);

            albumIndiv.setLeftAnchor(userPic, 20.0);
            albumIndiv.setTopAnchor(userPic, 13.0);
            albumIndiv.setTopAnchor(text, 102.0);
            albumIndiv.setLeftAnchor(text, 24.0);

            albumIndiv.getChildren().add(userPic);
            albumIndiv.getChildren().add(text);
            listProducts.add(albumIndiv);

        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
