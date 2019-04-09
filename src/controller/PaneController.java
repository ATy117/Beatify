package controller;

import Facade.MasterFacade;
import javafx.scene.layout.AnchorPane;
import view.View;

public abstract class PaneController extends Controller {

	protected controllerDashboard dashboardController;
	protected AnchorPane mainPane;

	protected  PaneController (AnchorPane mainPane, controllerDashboard dashboardController) {
		this.mainPane = mainPane;
		facade = MasterFacade.getInstance();
		this.dashboardController = dashboardController;
	}

	public View getPaneView() {
		return view;
	}
}
