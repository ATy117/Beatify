package view;

import com.jfoenix.controls.JFXPopup;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;

public class viewError extends JFXPopup {

    public AnchorPane errorPane;

    public viewError(String specifics, AnchorPane mainPane){
        errorPane = new AnchorPane();
        Label errorMessage = new Label("ERROR!");
        Label errorSpecifics = new Label(specifics);
        Image errorImg = new Image("resources/error.png");
        ImageView errorView = new ImageView(errorImg);

        errorView.setFitWidth(70);
        errorView.setFitHeight(190);

        errorSpecifics.setMaxWidth(180.0);
        errorSpecifics.setWrapText(true);
        errorSpecifics.setAlignment(Pos.CENTER);
        errorSpecifics.setTextAlignment(TextAlignment.CENTER);

        errorMessage.setMaxWidth(180.0);
        errorMessage.setWrapText(true);
        errorMessage.setAlignment(Pos.CENTER);
        errorSpecifics.setTextAlignment(TextAlignment.CENTER);

        errorPane.setMinSize(300,300);
        errorPane.setMaxSize(300, 300);

        errorPane.setTopAnchor(errorSpecifics, 150.0);
        errorPane.setLeftAnchor(errorSpecifics, 60.0);
        errorPane.setLeftAnchor(errorMessage, 110.0);
        errorPane.setTopAnchor(errorMessage, 90.0);
        errorPane.setLeftAnchor(errorView, 220.0);

        errorPane.getStylesheets().add("view/theme.css");
        errorPane.setId("errorPane");
        errorMessage.setId("errorMessage");
        errorSpecifics.setId("errorSpecifics");

        errorPane.getChildren().add(errorView);
        errorPane.getChildren().add(errorSpecifics);
        errorPane.getChildren().add(errorMessage);
        this.setPopupContent(errorPane);
        this.show(mainPane, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, 95.0, 70.0);

    }
}
