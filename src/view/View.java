package view;

import controller.Controller;
import javafx.stage.Stage;

public abstract class View {

	public abstract void Update();
	public Stage primaryStage;
	public Controller controller;
	public StageManager sm;

	public View() {

	}
}
