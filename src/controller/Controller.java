package controller;

import Facade.MasterFacade;
import javafx.stage.Stage;
import model.ModelCentral;
import view.View;

public abstract class Controller{
	protected View view;
	protected ModelCentral model;
	protected Stage primaryStage;
	protected MasterFacade facade;

	public ModelCentral getModel () {
		return model;
	}

}
