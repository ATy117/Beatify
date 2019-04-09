package view_builders;

import controller.controllerSong_MyQueue;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderSong_MyQueue extends builderSong<AnchorPane> {

    private controllerSong_MyQueue controller;

    public builderSong_MyQueue(controllerSong_MyQueue controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getPlayerModel().getCurrentList().iterator();
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
