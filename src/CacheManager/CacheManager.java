package CacheManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CacheManager {

	private static final String mainFolder = System.getProperty("user.home") + "/documents/Beatify/";
	private static final String songFolder = System.getProperty("user.home") + "/documents/Beatify/SongCache";
	private static final String pictureFolder = System.getProperty("user.home") + "/documents/Beatify/PictureCache";

	public void generateCacheFolder () {
		try {
			Files.createDirectories(Paths.get(mainFolder));
			Files.createDirectories(Paths.get(songFolder));
			Files.createDirectories(Paths.get(pictureFolder));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
