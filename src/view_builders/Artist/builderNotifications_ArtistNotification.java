package view_builders.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerNotifs_ArtistNotifications;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import object.Notification;
import object.Playlist;
import view_builders.builderNotification;

import java.util.ArrayList;
import java.util.List;

public class builderNotifications_ArtistNotification extends builderNotification<AnchorPane> {

    private controllerNotifs_ArtistNotifications controller;

    public builderNotifications_ArtistNotification(controllerNotifs_ArtistNotifications controller){
        this.controller = controller;
        this.listElements = controller.getModel().getNotificationModel().getNotifications();
        this.listProducts = new ArrayList<>();

    }
    @Override
    public void build() {
        while(listElements.hasNext()) {
            Notification notif = listElements.next();
            AnchorPane notifIndiv = new AnchorPane();
            Label notifLabel = new Label();
            JFXButton ex = new JFXButton("X");
            if (!notif.isViewed())
                notifLabel.setFont(Font.font("Times New Roman", 18));
            else
                notifLabel.setFont(Font.font("Comic Sans", 18));

            notifLabel.setText(notif.getMessage());
            ex.setFont(Font.font("Confortaa", 14));

            ex.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.removeNotification(notif.getNotif_id());
                }
            });

            notifIndiv.setLeftAnchor(ex, 600.0);
            notifIndiv.setLeftAnchor(notifLabel, 15.0);

            notifIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.markAsViewed(notif.getNotif_id());
                }
            });

            notifIndiv.getChildren().add(notifLabel);
            notifIndiv.getChildren().add(ex);

            listProducts.add(notifIndiv);
        }

    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
