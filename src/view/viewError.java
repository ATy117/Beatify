package view;

import com.jfoenix.controls.JFXPopup;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;

public class viewError extends JFXPopup {

    public AnchorPane errorPane;

    public viewError(String specifics, AnchorPane mainPane){
        errorPane = new AnchorPane();
        Label errorMessage = new Label("Error!");
        Label errorSpecifics = new Label(specifics);

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
        errorPane.setLeftAnchor(errorSpecifics, 20.0);
        errorPane.setLeftAnchor(errorMessage, 50.0);
        errorPane.setTopAnchor(errorMessage, 70.0);

        errorPane.getChildren().add(errorSpecifics);
        errorPane.getChildren().add(errorMessage);
        this.setPopupContent(errorPane);
        this.show(mainPane, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, 95.0, 70.0);
    }
}
