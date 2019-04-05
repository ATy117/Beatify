package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_MyQueue;

public class controllerSong_MyQueue extends Controller implements PaneController{

    public controllerSong_MyQueue(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewSong_MyQueue(mainPane, model, this);
    }
}
