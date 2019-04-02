package view;

import controller.Controller;
import javafx.stage.Stage;

public abstract class View {
	
	protected Stage primaryStage;
	protected Controller controller;
	protected StageManager sm;

	public View() {

	}

	public abstract void Update();
}
