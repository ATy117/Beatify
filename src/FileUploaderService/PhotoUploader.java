package FileUploaderService;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PhotoUploader extends FileUploader{

	public PhotoUploader (Stage stage) {
		super(stage);
	}

	@Override
	protected void showUploaderWindow() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select picture");

		File findDirectory = new File(System.getProperty("user.home")+"/Downloads");
		fileChooser.setInitialDirectory(findDirectory);
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JPEG / JPG / PNG Files", "*.jpg", "*.png", "*.jpeg"));

		this.file = fileChooser.showOpenDialog(stage);

		storeScaledImage();
	}

	private void storeScaledImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedImage resized = resize(image, 256, 256);

		this.file = new File(System.getProperty("user.home") + "/documents/Beatify/PictureCache/temp.png");

		try {
			ImageIO.write(resized, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private BufferedImage resize(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}
}
