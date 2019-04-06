package view.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.controllerDashboard;
import controller.controller_AddEditAlbum;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import view.View;

import java.io.IOException;

public class viewAlbum_ArtistAllAlbums extends View {

    //All Albums of Artist
    //My Albums + Followed Albums

    public controllerAlbum_ArtistAllAlbums controller;
    public AnchorPane mainPane;
    public controllerDashboard dashboardController;


    @FXML AnchorPane albumsHeader;
    @FXML JFXListView albumListView;

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

    }

    private void initHeader(){
        headerLabel = new Label("All Albums");
        uploadAlbumBtn = new JFXButton("+ upload album");

        uploadAlbumBtn.setFont(Font.font("Comfortaa", 12));
        headerLabel.setFont(Font.font("Comfortaa", 18));

        albumsHeader.setLeftAnchor(headerLabel, 252.0);
        albumsHeader.setTopAnchor(headerLabel, 23.0);
        albumsHeader.setLeftAnchor(uploadAlbumBtn, 246.0);
        albumsHeader.setTopAnchor(uploadAlbumBtn, 53.0);

        albumsHeader.getChildren().add(headerLabel);
        albumsHeader.getChildren().add(uploadAlbumBtn);

        uploadAlbumBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                uploadAlbum();
            }
        });

        /*FOR BUILDER*/
        myAlbumTilePane = new TilePane();
        myAlbumsLbl = new Label("My Albums");
        followedAlbumsLbl = new Label("Followed Albums");

        myAlbumsLbl.setFont(Font.font("Poppins", 14));
        followedAlbumsLbl.setFont(Font.font("Poppins", 14));


        for(int i = 0; i<9; i++) {
            AnchorPane albumIndiv = new AnchorPane();
            Circle albumCover = new Circle(45);
            Text text = new Text("AlbumName");

            albumIndiv.setLeftAnchor(albumCover, 20.0);
            albumIndiv.setTopAnchor(albumCover, 13.0);
            albumIndiv.setTopAnchor(text, 102.0);
            albumIndiv.setLeftAnchor(text, 24.0);

            albumIndiv.getChildren().add(albumCover);
            albumIndiv.getChildren().add(text);
            myAlbumTilePane.getChildren().add(albumIndiv);

        }


        albumListView.getItems().add(myAlbumsLbl);
        albumListView.getItems().add(myAlbumTilePane);
        albumListView.getItems().add(followedAlbumsLbl);


    }

    public void uploadAlbum(){
         controller_AddEditAlbum controller = new controller_AddEditAlbum(mainPane, dashboardController);
    }
}
