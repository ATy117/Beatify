package view_builders.Listener;

import com.jfoenix.controls.JFXButton;
import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.Listener.controllerNotifs_ListenerNotifications;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import object.Notification;
import view_builders.builderNotification;

import java.util.ArrayList;
import java.util.List;

public class builderNotification_ListenerNotification extends builderNotification<AnchorPane> {
    private controllerNotifs_ListenerNotifications controller;

    public builderNotification_ListenerNotification(controllerNotifs_ListenerNotifications controller){
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

            if (!notif.isViewed())
                notifLabel.getStyleClass().add("label_Notif_Unviewed");
            else
                notifLabel.getStyleClass().add("label_Notif_Viewed");

            notifLabel.setText(notif.getMessage());

            notifIndiv.setLeftAnchor(notifLabel, 15.0);

            notifIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.markAsViewed(notif.getNotif_id());
                }
            });

            notifIndiv.getChildren().add(notifLabel);

            listProducts.add(notifIndiv);
        }

    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
