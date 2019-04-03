package view;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class StageManager {

    Stage stage;

    public StageManager(Stage stage){
        this.stage = stage;
    }

    public boolean loadScene(FXMLLoader loader) {

        Parent root = null;

        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);

        return true;
    }

    public boolean setRightScene(BorderPane pane, FXMLLoader loader){
        Parent root = null;
        try{
            root = (Parent)loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        pane.setRight(root);

        return true;
    }

    public void setWindowName(String title) {
        stage.setTitle(title);
    }
}