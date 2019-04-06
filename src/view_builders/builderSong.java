package view_builders;

import controller.Controller;
import object.Song;

import java.util.Iterator;
import java.util.List;


public abstract class builderSong<T> implements ListBuilder<T, Song> {
   protected Controller controller;
   protected Iterator<Song> listElements;
   protected List<T> listProducts;
}
