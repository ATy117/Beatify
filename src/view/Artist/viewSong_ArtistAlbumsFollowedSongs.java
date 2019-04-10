package view.Artist;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerSong_ArtistAlbumsFollowedSongs;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import object.Album;
import view.View;
import view_builders.Director;
import view_builders.builderSong;
import view_builders.Artist.builderSong_ArtistAlbumsFollowedSongs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class viewSong_ArtistAlbumsFollowedSongs extends View {

    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;
    private Label headerLabel;
    private Label subheaderLabel;
    private controllerSong_ArtistAlbumsFollowedSongs controller;
    private Label sortLabel;
    JFXComboBox sortingCB;
    JFXComboBox arrangeCB;
    private Album selectedAlbum;
    ArrayList<AnchorPane> sortArrayList; //used to tempoarily store the anchorpane for sorting
    //Songs inside the album I am Following

    public viewSong_ArtistAlbumsFollowedSongs(AnchorPane mainPane, controllerSong_ArtistAlbumsFollowedSongs controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSong.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        selectedAlbum = model.getLibraryModel().getSelectedAlbum();
        setSongs();
        initHeader();
        initSortComboBox();
        Update();
    }
    @Override
    public void Update() {
        setSongs();
        sortSongListView();
    }

    private void initHeader () {
        //INITIALIZES THE HEADER//
        String ALBUMNAME = selectedAlbum.getName();
        String ARTISTNAME = "Album by "+ selectedAlbum.getArtist_name();
        headerLabel = new Label(ALBUMNAME);
        subheaderLabel = new Label(ARTISTNAME);
        sortLabel = new Label("Sort by");
        Circle albumArt = new Circle();
        albumArt.setRadius(30);
        Image image = new Image(selectedAlbum.getCover_URL().toURI().toString());
        albumArt.setFill(new ImagePattern(image));
        headerLabel.setFont(Font.font("Comfortaa", 18));
        subheaderLabel.setFont(Font.font("Comfortaa",12));
        sortLabel.setFont(Font.font("Comfortaa", 18));
        songsHeader.setLeftAnchor(headerLabel, 100.0);
        songsHeader.setTopAnchor(headerLabel, 50.0);
        songsHeader.setLeftAnchor(subheaderLabel, 100.0);
        songsHeader.setTopAnchor(subheaderLabel, 70.0);
        songsHeader.setLeftAnchor(sortLabel, 475.0);
        songsHeader.setTopAnchor(sortLabel, 28.0);
        songsHeader.setLeftAnchor(albumArt, 30.0);
        songsHeader.setTopAnchor(albumArt,  30.0);

        songsHeader.getChildren().add(headerLabel);
        songsHeader.getChildren().add(subheaderLabel);
        songsHeader.getChildren().add(sortLabel);
        songsHeader.getChildren().add(albumArt);
    }

    //SET SONG IN THE LISTVIEW//
    private void setSongs () {
        songListView.getItems().clear();
        sortArrayList = new ArrayList<>();
        builderSong builder = new builderSong_ArtistAlbumsFollowedSongs(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();

        for (Object object : builder.getProduct()) {
            AnchorPane anchorPane = (AnchorPane) object;
            sortArrayList.add(anchorPane);
        }
    }

    private void initSortComboBox() {
        //CREATES SORTING AND ARRANGEMENT //
        sortingCB = new JFXComboBox();
        arrangeCB = new JFXComboBox();
        String[] categories = new String[]{"Title", "Artist", "Album", "Year", "Genre", "Date Added"};
        String[] arrangement = new String[]{"Ascending", "Descending"};

        for (String e : categories)
            sortingCB.getItems().add(e);

        for (String e : arrangement)
            arrangeCB.getItems().add(e);

        songsHeader.setLeftAnchor(sortingCB, 375.0);
        songsHeader.setTopAnchor(sortingCB, 50.0);
        songsHeader.setLeftAnchor(arrangeCB, 500.0);
        songsHeader.setTopAnchor(arrangeCB, 50.0);
        songsHeader.getChildren().add(sortingCB);
        songsHeader.getChildren().add(arrangeCB);

        sortingCB.setOnAction(event -> {
            sortSongListView();
        });

        arrangeCB.setOnAction(event -> {
            sortSongListView();
        });

        sortingCB.setValue("Date Added");
        arrangeCB.setValue("Descending");
        sortByDateAdded();

    }
    private void sortSongListView (){
        String choice = (String) sortingCB.getValue();
        switch (choice){
            case "Title":
                sortByTitle();
                break;
            case "Album":
                sortByAlbum();
                break;
            case "Year":
                sortByYear();
                break;
            case "Genre":
                sortByGenre();
                break;
            case "Date Added":
                sortByDateAdded();
                break;
            default:
                System.out.println("SORTING ERROR");

        }

    }



    private void sortByTitle() {
        songListView.getItems().clear();
        String arrange = (String) arrangeCB.getValue();
        {

            for (int i = 0; i < sortArrayList.size() - 1; i++) {
                for (int j = 0; j < sortArrayList.size() - i - 1; j++) {

                    Text t1 = (Text) sortArrayList.get(j).getChildren().get(0);
                    Text t2 = (Text) sortArrayList.get(j + 1).getChildren().get(0);
                    String s1 = t1.getText().toLowerCase();
                    String s2 = t2.getText().toLowerCase();
                    if (arrange.compareTo("Ascending") == 0){
                        if (s1.compareTo(s2) > 0) {
                            Collections.swap(sortArrayList, j, j + 1);
                        }
                    }
                    else{
                        if (s1.compareTo(s2) < 0) {
                            Collections.swap(sortArrayList, j, j + 1);
                        }
                    }


                }
            }
            for (AnchorPane e : sortArrayList) {
                System.out.println("Title Added Ascending");
                songListView.getItems().add(e);

            }
        }

    }
    private void sortByAlbum(){
        songListView.getItems().clear();
        String arrange = (String) arrangeCB.getValue();
        {

            for (int i = 0; i < sortArrayList.size() - 1; i++) {
                for (int j = 0; j < sortArrayList.size() - i - 1; j++) {

                    Text t1 = (Text) sortArrayList.get(j).getChildren().get(1);
                    Text t2 = (Text) sortArrayList.get(j + 1).getChildren().get(1);
                    String s1 = t1.getText().toLowerCase();
                    String s2 = t2.getText().toLowerCase();
                    if (arrange.compareTo("Ascending") == 0){
                        if (s1.compareTo(s2) > 0) {
                            Collections.swap(sortArrayList, j, j + 1);
                        }
                    }
                    else{
                        if (s1.compareTo(s2) < 0) {
                            Collections.swap(sortArrayList, j, j + 1);
                        }
                    }
                }
            }
            for (AnchorPane e : sortArrayList) {
                System.out.println("Title Added Ascending");
                songListView.getItems().add(e);

            }
        }
    }
    private void sortByYear () {
        songListView.getItems().clear();
        String arrange = (String) arrangeCB.getValue();


        for (int i = 0; i < sortArrayList.size() - 1; i++) {
            for (int j = 0; j < sortArrayList.size() - i - 1; j++) {

                Text t1 = (Text) sortArrayList.get(j).getChildren().get(2);
                Text t2 = (Text) sortArrayList.get(j + 1).getChildren().get(2);
                int s1 = Integer.parseInt(t1.getText());
                int s2 = Integer.parseInt(t2.getText());
                if (arrange.compareTo("Ascending") == 0) {
                    if (s1 > s2) {
                        Collections.swap(sortArrayList, j, j + 1);
                    }
                } else {
                    if (s1 < s2) {
                        Collections.swap(sortArrayList, j, j + 1);
                    }
                }
            }
        }
        for (AnchorPane e : sortArrayList) {
            System.out.println("Title Added Ascending");
            songListView.getItems().add(e);

        }
    }
    private void sortByGenre(){
        songListView.getItems().clear();
        String arrange = (String) arrangeCB.getValue();


        for (int i = 0; i < sortArrayList.size() - 1; i++) {
            for (int j = 0; j < sortArrayList.size() - i - 1; j++) {

                Text t1 = (Text) sortArrayList.get(j).getChildren().get(3);
                Text t2 = (Text) sortArrayList.get(j + 1).getChildren().get(3);
                String s1 = t1.getText().toLowerCase();
                String s2 = t2.getText().toLowerCase();
                if (arrange.compareTo("Ascending") == 0) {
                    if (s1.compareTo(s2) > 0) {
                        Collections.swap(sortArrayList, j, j + 1);
                    }
                } else {
                    if (s1.compareTo(s2) < 0) {
                        Collections.swap(sortArrayList, j, j + 1);
                    }
                }
            }
        }
        for (AnchorPane e : sortArrayList) {
            System.out.println("Title Added Ascending");
            songListView.getItems().add(e);
        }

    }
    private void sortByDateAdded() {
        songListView.getItems().clear();
        String arrange = (String) arrangeCB.getValue();
        if (arrange.compareTo("Ascending") == 0) {
            for (int i = 0; i < sortArrayList.size() - 1; i++){
                for (int j = 0; j < sortArrayList.size() - i - 1; j++){
                    Collections.swap(sortArrayList, j, j + 1);
                }
            }

        } else {
            setSongs();
        }
        for (AnchorPane e : sortArrayList) {
            System.out.println("Date Added Descending");
            songListView.getItems().add(e);
        }
    }




}
