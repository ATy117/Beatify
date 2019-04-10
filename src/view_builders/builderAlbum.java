package view_builders;

import controller.Controller;
import object.Album;
import view.viewError;

import java.util.Iterator;
import java.util.List;

public abstract class builderAlbum<T> implements ListBuilder<T, Album> {
    protected Iterator<Album> listElements;
    protected List<T> listProducts;
    protected viewError errorPopup;
}
