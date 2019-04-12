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

            notifIndiv.getStylesheets().add("view/theme.css");

            if (!notif.isViewed()) {
                notifLabel.getStyleClass().add("label_Notif_Unviewed");
            }
            else {
                notifLabel.getStyleClass().add("label_Notif_Viewed");
            }

            notifLabel.setText(notif.getMessage());

            notifIndiv.setLeftAnchor(notifLabel, 15.0);


            notifIndiv.getChildren().add(notifLabel);

            listProducts.add(notifIndiv);
        }

    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
