package Facade;

import DAO.*;
import model.*;
import object.*;

import java.io.File;

public class MasterFacade {

	private static MasterFacade ourInstance;

	private MasterFacade(){}

	public static MasterFacade getInstance() {
		if (ourInstance == null) {
			ourInstance = new MasterFacade();
		}

		return ourInstance;
	}

	public boolean registerListener(String username, String password, String firstName, String lastName, File profilePic) {

		return true;
	}

	public boolean registerArtist(String username, String password, String firstName, String lastName, File profilePic) {

		return true;
	}

	public User loginUser (String username, String password) {

		User testuser = new User();

		// returns null if no user found
		if (username.equalsIgnoreCase("A")) {
			testuser.setIs_artist(true);
			testuser.setFirst_name("I'm Artist");

		}
		else {
			testuser.setIs_artist(false);
			testuser.setFirst_name("I'm Listener");
		}

		return testuser;
	}
}
