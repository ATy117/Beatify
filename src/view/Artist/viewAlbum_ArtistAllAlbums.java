package view.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.controllerDashboard;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import view.View;
import view_builders.Director;
import view_builders.builderAlbum;
import view_builders.Artist.builderAlbum_ArtistAlbumFollowed;
import view_builders.Artist.builderAlbum_ArtistAlbumOwned;

import java.io.IOException;

public class viewAlbum_ArtistAllAlbums extends View {

    //All Albums of Artist
    //My Albums + Followed Albums

    public controllerAlbum_ArtistAllAlbums controller;
    public AnchorPane mainPane;
    public controllerDashboard dashboardController;


    @FXML AnchorPane albumsHeader;
    @FXML JFXListView contentListView;

    private Label headerLabel;
    private JFXButton uploadAlbumBtn;
    private TilePane followedAlbumTilePane;
    private TilePane myAlbumTilePane;
    private Label myAlbumsLbl;
    private Label followedAlbumsLbl;

    public viewAlbum_ArtistAllAlbums(AnchorPane mainPane, controllerAlbum_ArtistAllAlbums controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        this.mainPane = mainPane;
        this.dashboardController = dashboardController;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateAlbum.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        initHeader();
        Update();

    }

    @Override
    public void Update(){
        contentListView.getItems().clear();

        myAlbumTilePane = new TilePane();

        contentListView.getItems().add(myAlbumsLbl);
        builderAlbum builder = new builderAlbum_ArtistAlbumOwned(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            myAlbumTilePane.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(myAlbumTilePane);

        followedAlbumTilePane = new TilePane();
        contentListView.getItems().add(followedAlbumsLbl);
        builder = new builderAlbum_ArtistAlbumFollowed(controller);
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            followedAlbumTilePane.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(followedAlbumTilePane);
    }

    private void initHeader(){
        mainPane.getStylesheets().add("view/theme.css");
        headerLabel = new Label("All Albums");
        uploadAlbumBtn = new JFXButton("+ upload album");

        uploadAlbumBtn.setId("buttonStyle");
        headerLabel.setId("songHeader");

        albumsHeader.setLeftAnchor(headerLabel, 252.0);
        albumsHeader.setTopAnchor(headerLabel, 23.0);
        albumsHeader.setLeftAnchor(uploadAlbumBtn, 252.0);
        albumsHeader.setTopAnchor(uploadAlbumBtn, 63.0);

        albumsHeader.getChildren().add(headerLabel);
        albumsHeader.getChildren().add(uploadAlbumBtn);

        uploadAlbumBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                uploadAlbum();
            }
        });

        myAlbumsLbl = new Label("My Albums");
        followedAlbumsLbl = new Label("Followed Albums");
        myAlbumsLbl.setId("headerLabel");
        followedAlbumsLbl.setId("headerLabel");


    }

    public void uploadAlbum(){
        controller.uploadAlbum();
    }
}
