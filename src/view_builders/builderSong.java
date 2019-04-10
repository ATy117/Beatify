package view_builders;

import controller.Controller;
import object.Song;
import view.viewError;

import java.util.Iterator;
import java.util.List;


public abstract class builderSong<T> implements ListBuilder<T, Song> {
   protected Iterator<Song> listElements;
   protected List<T> listProducts;
   protected viewError errorPopup;
}
