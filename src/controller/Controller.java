package controller;

import model.ModelCentral;
import view.View;

public abstract class Controller{
	protected View view;
	protected View currentPane;
	protected ModelCentral model;
}
