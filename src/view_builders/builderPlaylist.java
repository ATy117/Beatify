package view_builders;

import controller.Controller;
import object.Playlist;

import java.util.List;

public abstract class builderPlaylist<T> implements ListBuilder<T, Playlist> {
    protected Controller controller;
    protected List<Playlist> listElements;
    protected List<T> listProducts;
}
