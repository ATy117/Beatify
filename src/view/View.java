package view;

import controller.Controller;
import javafx.stage.Stage;
import model.ModelCentral;

public abstract class View {
	
	protected Stage primaryStage;
	protected StageManager sm;
	protected ModelCentral model;
	protected viewError errorPopup;

	public View() {

	}

	public abstract void Update();

}
