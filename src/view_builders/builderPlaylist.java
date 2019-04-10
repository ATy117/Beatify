package view_builders;

import controller.Controller;
import object.Playlist;
import view.viewError;

import java.util.Iterator;
import java.util.List;

public abstract class builderPlaylist<T> implements ListBuilder<T, Playlist> {
    protected Iterator<Playlist> listElements;
    protected List<T> listProducts;
    protected viewError errorPopup;
}
