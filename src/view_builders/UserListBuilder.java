package view_builders;

import controller.Controller;
import object.User;

import java.util.List;

public abstract class UserListBuilder<T> implements ListBuilder<T, User> {
    protected Controller controller;
    protected List<User> listElements;
    protected List<T> listProducts;
}
