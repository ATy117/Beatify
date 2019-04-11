package view.Listener;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import controller.Listener.controllerSong_ListenerShowArtistPlaylistSongs;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import object.Playlist;
import view.View;
import view_builders.Director;
import view_builders.Listener.builderSong_ListenerShowArtistPlaylistSongs;
import view_builders.builderSong;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class viewSong_ListenerShowArtistPlaylistSongs extends View {

    public controllerSong_ListenerShowArtistPlaylistSongs controller;
    @FXML AnchorPane mainPane;
    @FXML JFXListView contentListView;
    private Label headerLabel;
    private Label subheaderLabel;
    private Label sortLabel;
    JFXComboBox sortingCB;
    JFXComboBox arrangeCB;
    private Playlist selectedPlaylist;
    ArrayList<AnchorPane> sortArrayList; //used to tempoarily store the anchorpane for sorting

    public viewSong_ListenerShowArtistPlaylistSongs(AnchorPane mainPane, controllerSong_ListenerShowArtistPlaylistSongs controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSong.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedPlaylist = model.getPeopleModel().getSelectedPlaylist();
        initHeader();
        setSongs();
        initHeader();
        initSortComboBox();
        Update();

    }

    @Override
    public void Update() {
        setSongs();
        sortcontentListView();
    }

    private void initHeader () {
        mainPane.getStylesheets().add("view/theme.css");

        //INITIALIZES THE HEADER//
        String PLAYLISTNAME = selectedPlaylist.getName();
        String USERNAME = "Playlist by "+ selectedPlaylist.getOwner_name();
        headerLabel = new Label(PLAYLISTNAME);
        subheaderLabel = new Label(USERNAME);
        sortLabel = new Label("Sort by");
        headerLabel.setId("songHeader");
        subheaderLabel.setId("songHeaderDetails");
        sortLabel.setId("songHeaderDetails");
        mainPane.setLeftAnchor(headerLabel, 50.0);
        mainPane.setTopAnchor(headerLabel, 50.0);
        mainPane.setLeftAnchor(subheaderLabel, 50.0);
        mainPane.setTopAnchor(subheaderLabel, 70.0);
        mainPane.setLeftAnchor(sortLabel, 475.0);
        mainPane.setTopAnchor(sortLabel, 28.0);

        mainPane.getChildren().add(headerLabel);
        mainPane.getChildren().add(subheaderLabel);
        mainPane.getChildren().add(sortLabel);
    }
    //BUILDER//
    private void setSongs () {
        contentListView.getItems().clear();
        sortArrayList = new ArrayList<>();

        builderSong builder = new builderSong_ListenerShowArtistPlaylistSongs(controller);
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

        mainPane.setLeftAnchor(sortingCB, 375.0);
        mainPane.setTopAnchor(sortingCB, 50.0);
        mainPane.setLeftAnchor(arrangeCB, 500.0);
        mainPane.setTopAnchor(arrangeCB, 50.0);
        mainPane.getChildren().add(sortingCB);
        mainPane.getChildren().add(arrangeCB);

        sortingCB.setOnAction(event -> {
            sortcontentListView();
        });

        arrangeCB.setOnAction(event -> {
            sortcontentListView();
        });

        sortingCB.setValue("Date Added");
        arrangeCB.setValue("Descending");
        sortByDateAdded();

    }
    private void sortcontentListView (){
        String choice = (String) sortingCB.getValue();
        switch (choice){
            case "Title":
                sortByTitle();
                break;
            case "Artist":
                sortByArtist();
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
        contentListView.getItems().clear();
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
                contentListView.getItems().add(e);

            }
        }

    }
    private void sortByArtist() {
        contentListView.getItems().clear();
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
                contentListView.getItems().add(e);

            }
        }

    }
    private void sortByAlbum(){
        contentListView.getItems().clear();
        String arrange = (String) arrangeCB.getValue();
        {

            for (int i = 0; i < sortArrayList.size() - 1; i++) {
                for (int j = 0; j < sortArrayList.size() - i - 1; j++) {

                    Text t1 = (Text) sortArrayList.get(j).getChildren().get(2);
                    Text t2 = (Text) sortArrayList.get(j + 1).getChildren().get(2);
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
                contentListView.getItems().add(e);

            }
        }
    }
    private void sortByYear () {
        contentListView.getItems().clear();
        String arrange = (String) arrangeCB.getValue();


        for (int i = 0; i < sortArrayList.size() - 1; i++) {
            for (int j = 0; j < sortArrayList.size() - i - 1; j++) {

                Text t1 = (Text) sortArrayList.get(j).getChildren().get(3);
                Text t2 = (Text) sortArrayList.get(j + 1).getChildren().get(3);
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
            contentListView.getItems().add(e);

        }
    }
    private void sortByGenre(){
        contentListView.getItems().clear();
        String arrange = (String) arrangeCB.getValue();


        for (int i = 0; i < sortArrayList.size() - 1; i++) {
            for (int j = 0; j < sortArrayList.size() - i - 1; j++) {

                Text t1 = (Text) sortArrayList.get(j).getChildren().get(4);
                Text t2 = (Text) sortArrayList.get(j + 1).getChildren().get(4);
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
            contentListView.getItems().add(e);
        }

    }
    private void sortByDateAdded() {
        contentListView.getItems().clear();
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
            contentListView.getItems().add(e);
        }
    }

}
