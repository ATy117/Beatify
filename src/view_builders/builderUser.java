package view_builders;

import controller.Controller;
import object.User;
import view.viewError;

import java.util.Iterator;
import java.util.List;

public abstract class builderUser<T> implements ListBuilder<T, User> {
    protected Iterator<User> listElements;
    protected List<T> listProducts;
    protected viewError errorPopup;
}
