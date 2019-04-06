package controller;

import Facade.MasterFacade;
import javafx.stage.Stage;
import view.viewRegister;

public class controllerRegister extends Controller{

	public controllerRegister (Stage primaryStage) {
		facade = MasterFacade.getInstance();
		view = new viewRegister(primaryStage, this);
	}
}
