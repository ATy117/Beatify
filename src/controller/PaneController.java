package controller;

import view.View;

public abstract class PaneController extends Controller {

	protected controllerDashboard controller;

	public View getPaneView() {
		return view;
	}
}
