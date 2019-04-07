package view_builders;

import controller.Listener.controllerListener_ListenerFollowedListeners;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderListener_ListenerFollowedListeners extends builderUser<AnchorPane> {

    public builderListener_ListenerFollowedListeners(controllerListener_ListenerFollowedListeners controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getProfileModel().getFollowedListeners();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {

    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
