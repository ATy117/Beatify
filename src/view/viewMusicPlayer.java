package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import controller.controllerMusicPlayer;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.LibraryModel;
import model.ModelCentral;
import model.ProfileModel;
import model.SongPlayerModel;
import object.Album;
import object.Song;

import java.io.File;
import java.io.IOException;

public class viewMusicPlayer extends View {

	private controllerMusicPlayer controller;

	private MediaPlayer mp3player;
	private Duration duration;
	private Media currentSongMedia;

	public Circle songPic;
	public Label titleText;
	public Label artistText;
	public Label albumText;
	public Label genreText;
	public JFXButton playBtn;
	public JFXButton rewindBtn;
	public JFXButton ffBtn;
	public JFXButton shuffleBtn;
	public JFXButton repeatBtn;
	public JFXButton volumeUp;
	public JFXButton volumeDown;
	public JFXSlider slider;
	public Label timestamp;

	private final boolean repeat = false;
	private boolean stopRequested = false;
	private boolean atEndOfMedia = false;
	private double volume;

	public viewMusicPlayer(AnchorPane mainPane, ModelCentral model, controllerMusicPlayer controller) {
		this.controller = controller;
		this.model = model;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateMusicPlayer.fxml"));
		loader.setController(this);

		try {
			mainPane.getChildren().setAll((AnchorPane) loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		init();
	}

	private void init() {
		titleText.setText("No Song Playing");
		artistText.setText("");
		albumText.setText("");
		genreText.setText("");
		timestamp.setText("");
		volume = 0.5;

	}

	@Override
	public void Update() {

		if (mp3player != null) {
			mp3player.dispose();
			mp3player = null;
		}

		if (model.getPlayerModel().getCurrentSong() != null) {
			titleText.setText(model.getPlayerModel().getCurrentSong().getSong_name());
			artistText.setText("by " + model.getPlayerModel().getCurrentSong().getArtist_name());
			genreText.setText(model.getPlayerModel().getCurrentSong().getGenre());

			/*
			Image albpic = controller.getImageFromAlbum(model.getPlayerModel().getCurrentSong().getAlbum_id());
			songPic.setFill(new ImagePattern(albpic));

			 */

			Album album = controller.getAlbumOfSong(model.getPlayerModel().getCurrentSong().getAlbum_id());

			if (album != null) {
				albumText.setText("Album: " + album.getName());
			}
			else {
				albumText.setText("Album: None");
			}

			currentSongMedia = new Media(model.getPlayerModel().getCurrentSong().getSong_URL().toURI().toString());
			mp3player = new MediaPlayer(currentSongMedia);
			toggleToPlay();
			setPlayerFunctionality();
		}
	}

	public void playPause(ActionEvent actionEvent) {
		if (model.getPlayerModel().getCurrentSong() != null ){


			MediaPlayer.Status status = mp3player.getStatus();

			if (status == MediaPlayer.Status.UNKNOWN  || status == MediaPlayer.Status.HALTED)
			{
				// don't do anything in these states
				return;
			}

			if ( status == MediaPlayer.Status.PAUSED
					|| status == MediaPlayer.Status.READY
					|| status == MediaPlayer.Status.STOPPED)
			{
				// rewind the movie if we're sitting at the end
				if (atEndOfMedia) {
					mp3player.seek(mp3player.getStartTime());
					atEndOfMedia = false;
				}
				toggleToPlay();
			} else {
				toggleToPause();
			}


		}
	}

	public void prevSong(ActionEvent actionEvent) {
		if (model.getPlayerModel().getCurrentSong()!= null) {
			controller.playPrevSong();
		}
	}

	public void nextSong(ActionEvent actionEvent) {
		if (model.getPlayerModel().getCurrentSong() != null) {
			controller.playNextSong();
		}
	}

	public void shuffle(ActionEvent actionEvent) {
		if(controller.toggleShuffle()) {
			//shuffleBtn.setGraphic(shuffleClickedView);
		}
		else {
			//shuffleBtn.setGraphic(shuffleView);
		}
	}

	public void repeat(ActionEvent actionEvent) {
		if(controller.toggleRepeat()) {
			//repeatBtn.setGraphic(replayClickedView);
		}
		else {
			//repeatBtn.setGraphic(replayView);
		}
	}

	public void turnVolumeUp(ActionEvent actionEvent) {

		if (mp3player!= null) {
			if (volume < 1) {
				volume += 0.1;
				mp3player.setVolume(volume);
			}
		}
	}

	public void turnVolumeDown(ActionEvent actionEvent) {

		if (mp3player!=null) {
			if (volume > 0) {
				volume -= 0.1;
				mp3player.setVolume(volume);
			}
		}
	}

	public void endPlayer() {
		if (mp3player != null) {
			mp3player.stop();
		}
	}

	private void toggleToPlay() {
		mp3player.play();
		//playBtn.setGraphic(pauseView);
	}

	private void toggleToPause() {
		mp3player.pause();
		//playBtn.setGraphic(playView);
	}

	protected void updateValues() {
		if (timestamp != null && slider != null) {
			Platform.runLater(new Runnable() {
				public void run() {
					Duration currentTime = mp3player.getCurrentTime();
					timestamp.setText(formatTime(currentTime, duration));
					slider.setDisable(duration.isUnknown());
					if (!slider.isDisabled()
							&& duration.greaterThan(Duration.ZERO)
							&& !slider.isValueChanging()) {
						slider.setValue(currentTime.divide(duration).toMillis()
								* 100.0);
					}
				}
			});
		}
	}

	private static String formatTime(Duration elapsed, Duration duration) {
		int intElapsed = (int)Math.floor(elapsed.toSeconds());
		int elapsedHours = intElapsed / (60 * 60);
		if (elapsedHours > 0) {
			intElapsed -= elapsedHours * 60 * 60;
		}
		int elapsedMinutes = intElapsed / 60;
		int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
				- elapsedMinutes * 60;

		if (duration.greaterThan(Duration.ZERO)) {
			int intDuration = (int)Math.floor(duration.toSeconds());
			int durationHours = intDuration / (60 * 60);
			if (durationHours > 0) {
				intDuration -= durationHours * 60 * 60;
			}
			int durationMinutes = intDuration / 60;
			int durationSeconds = intDuration - durationHours * 60 * 60 -
					durationMinutes * 60;
			if (durationHours > 0) {
				return String.format("%d:%02d:%02d/%d:%02d:%02d",
						elapsedHours, elapsedMinutes, elapsedSeconds,
						durationHours, durationMinutes, durationSeconds);
			} else {
				return String.format("%02d:%02d/%02d:%02d",
						elapsedMinutes, elapsedSeconds,durationMinutes,
						durationSeconds);
			}
		} else {
			if (elapsedHours > 0) {
				return String.format("%d:%02d:%02d", elapsedHours,
						elapsedMinutes, elapsedSeconds);
			} else {
				return String.format("%02d:%02d",elapsedMinutes,
						elapsedSeconds);
			}
		}

	}

	private void setPlayerFunctionality() {
		mp3player.currentTimeProperty().addListener(new InvalidationListener()
		{
			public void invalidated(Observable ov) {
				updateValues();
			}
		});

		mp3player.setOnPlaying(new Runnable() {
			public void run() {
				if (stopRequested) {
					toggleToPause();
					stopRequested = false;
				} else {

				}
			}
		});

		mp3player.setOnPaused(new Runnable() {
			public void run() {

			}
		});

		mp3player.setOnReady(new Runnable() {
			public void run() {
				duration = mp3player.getMedia().getDuration();
				updateValues();
			}
		});

		mp3player.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
		mp3player.setOnEndOfMedia(new Runnable() {
			public void run() {
				//playBtn.setGraphic(playView);
				controller.playNextSong();
			}
		});

		slider.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (slider.isValueChanging()) {
					// multiply duration by percentage calculated by slider position
					mp3player.seek(duration.multiply(slider.getValue() / 100.0));
				}
			}
		});
	}
}
