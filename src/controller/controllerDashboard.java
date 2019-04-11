package controller;

import Facade.MasterFacade;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;
import object.Notification;
import object.User;
import view.Artist.viewNotifs_ArtistNotifications;
import view.Listener.viewNotifs_ListenerNotifications;
import view.View;
import view.viewDashboard;
import view.viewMusicPlayer;

import java.util.Iterator;

public abstract class controllerDashboard extends Controller{

	protected View currentPane;
	protected viewDashboard view;
	protected PaneController currentController;
	protected AnchorPane paneFoundation;
	protected Thread notifications;
	protected Iterator<Notification> listElements;
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
					checkNotifs();



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

	public void checkNotifs() {

		model.getNotificationModel().setNotifications(facade.getAllNotifications(this.model.getProfileModel().getUser().getUser_id()));
		listElements = this.model.getNotificationModel().getNotifications();

		while (listElements.hasNext()) {
			Notification notif = listElements.next();
			if (!notif.isViewed()) {

				System.out.println("NEW NOTIF");

				if (currentPane instanceof viewNotifs_ArtistNotifications ||
						currentPane instanceof viewNotifs_ListenerNotifications) {
					view.unshowNotifCue();
					currentPane.Update();
					break;
				}

				view.showNotifCue();
				break;
			}
		}

	}
}
