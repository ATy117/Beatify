package controller;

import view.View;

public abstract class PaneController extends Controller {

	protected controllerDashboard dashboardController;

	public View getPaneView() {
		return view;
	}
}
