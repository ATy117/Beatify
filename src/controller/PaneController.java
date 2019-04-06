package controller;

import Facade.MasterFacade;
import view.View;

public abstract class PaneController extends Controller {

	protected controllerDashboard dashboardController;

	protected  PaneController (controllerDashboard dashboardController) {
		facade = MasterFacade.getInstance();
		this.dashboardController = dashboardController;
	}

	public View getPaneView() {
		return view;
	}
}
