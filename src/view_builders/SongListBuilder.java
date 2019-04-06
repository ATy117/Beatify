package view_builders;

import controller.Controller;
import object.Song;

import java.util.List;


public abstract class SongListBuilder<T> implements ListBuilder<T, Song> {
   protected Controller controller;
   protected List<Song> listElements;
   protected List<T> listProducts;
}
