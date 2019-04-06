package controller;

import view.View;

public abstract class PaneController extends Controller {

	protected controllerDashboard dashboardController;

	protected  PaneController (controllerDashboard dashboardController) {
		this.dashboardController = dashboardController;
	}

	public View getPaneView() {
		return view;
	}
}
