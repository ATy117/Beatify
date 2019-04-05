package view_builders;

import javafx.scene.layout.AnchorPane;
import object.User;

import java.util.ArrayList;
import java.util.List;

public class UserFollowedListBuilder extends UserListBuilder<AnchorPane> {

    public UserFollowedListBuilder(controllerAllSongs controller, List<User> listElements){
        this.controller = controller;
        this.listElements = listElements;
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
