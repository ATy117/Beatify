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
}
