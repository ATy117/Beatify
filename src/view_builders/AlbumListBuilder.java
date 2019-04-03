package view_builders;

import controller.Controller;
import object.Album;

import java.util.List;

public abstract class AlbumListBuilder<T> implements ListBuilder<T, Album> {
    protected Controller controller;
    protected List<Album> listElements;
    protected List<T> listProducts;
}
