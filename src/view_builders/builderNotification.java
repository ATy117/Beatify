package view_builders;

import controller.Controller;
import object.Notification;

import java.util.Iterator;
import java.util.List;

public abstract class builderNotification<T> implements ListBuilder<T, Notification> {
    protected Controller controller;
    protected Iterator<Notification> listElements;
    protected List<T> listProducts;
}
