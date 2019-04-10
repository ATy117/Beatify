package controller;

import Facade.MasterFacade;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;
import object.User;
import view.View;
import view.viewDashboard;
import view.viewMusicPlayer;

public abstract class controllerDashboard extends Controller{

	protected View currentPane;
	protected PaneController currentController;
	protected AnchorPane paneFoundation;
	protected Thread notifications;
	protected boolean loggedIn = true;

	public controllerDashboard (Stage primaryStage, User user) {
		this.primaryStage = primaryStage;
		model = ModelCentral.getInstance();
		facade = MasterFacade.getInstance();
		model.resetModels();

		model.setProfileModel(new ProfileModel());
		model.setPlayerModel(new SongPlayerModel());
		model.setLibraryModel(new LibraryModel());
		model.setPeopleModel(new OtherPeopleModel());
		model.setSearchModel(new SearchModel());
		model.setNotificationModel(new NotificationModel());

		initThread();
	}

	public void setCurrentPane(PaneController currentController) {
		this.currentController = currentController;
		model.DetachToAll(currentPane);
		currentPane = currentController.getPaneView();
		model.AttachToAll(currentPane);
		System.out.println("Current Pane: " + currentPane.toString());
	}

	public void initThread () {
		notifications = new Thread() {
			public void run () {
				while (loggedIn) {

					System.out.println("Checking notifs");

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		notifications.setDaemon(true);
		notifications.start();
	}

	public void setLoggedIn (boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	public void setPaneFoundation(AnchorPane paneFoundation) {
		this.paneFoundation = paneFoundation;
	}
}
