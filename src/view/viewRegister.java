package view;

import controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class viewRegister  extends  View{

	public viewRegister(Stage primaryStage, Controller controller) {
		this.primaryStage = primaryStage;
		this.controller = controller;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateRegister.fxml"));
		loader.setController(this);

		sm = new StageManager(primaryStage);
		sm.loadScene(loader);
		sm.setWindowName("Register");
	}

	@Override
	public void Update() {

	}
}
