package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import controller.controllerDashboard;
import controller.controllerMusicPlayer;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import object.Album;
import object.Song;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

	private ImageView playView;
	private ImageView nextView;
	private ImageView prevView;
	private ImageView pauseView;
	private ImageView repeatView;
	private ImageView repeatClickedView;
	private ImageView shuffleView;
	private ImageView shuffleClickedView;
	private ImageView volUpView;
	private ImageView volDownView;

	public viewMusicPlayer(AnchorPane mainPane, controllerMusicPlayer controller, controllerDashboard controllerDashboard) {
		this.controller = controller;
		this.model = controllerDashboard.getModel();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/templateMusicPlayer.fxml"));
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
		volume = 1;

		Image play = new Image("resources/PlayBtn.png");
		Image next = new Image("resources/nextBtn.png");
		Image prev = new Image("resources/prevBtn.png");
		Image pause = new Image("resources/pauserBtn.png");
		Image repeat = new Image("resources/replay.png");
		Image repeatClicked = new Image("resources/replay2.png");
		Image shuffle = new Image("resources/shuffle.png");
		Image shuffleClicked = new Image("resources/shuffle2.png");
		Image volUp = new Image("resources/volUp.png");
		Image volDown = new Image("resources/volDown.png");

		playView = new ImageView(play);
		nextView = new ImageView(next);
		prevView = new ImageView(prev);
		pauseView = new ImageView(pause);
		repeatView = new ImageView(repeat);
		repeatClickedView = new ImageView(repeatClicked);
		shuffleView = new ImageView(shuffle);
		shuffleClickedView = new ImageView(shuffleClicked);
		volUpView = new ImageView(volUp);
		volDownView = new ImageView(volDown);

		playView.setFitWidth(44);
		playView.setFitHeight(44);
		nextView.setFitWidth(30);
		nextView.setFitHeight(30);
		prevView.setFitHeight(30);
		prevView.setFitWidth(30);
		pauseView.setFitWidth(44);
		pauseView.setFitHeight(44);
		repeatView.setFitWidth(24);
		repeatView.setFitHeight(24);
		repeatClickedView.setFitWidth(24);
		repeatClickedView.setFitHeight(24);
		shuffleView.setFitWidth(24);
		shuffleView.setFitHeight(24);
		shuffleClickedView.setFitWidth(24);
		shuffleClickedView.setFitHeight(24);
		volDownView.setFitWidth(18);
		volDownView.setFitHeight(18);
		volUpView.setFitHeight(18);
		volUpView.setFitWidth(18);

		playBtn.setGraphic(playView);
		rewindBtn.setGraphic(prevView);
		ffBtn.setGraphic(nextView);
		shuffleBtn.setGraphic(shuffleView);
		repeatBtn.setGraphic(repeatView);
		volumeUp.setGraphic(volUpView);
		volumeDown.setGraphic(volDownView);

		titleText.setMaxWidth(Double.MAX_VALUE);
		titleText.setAlignment(Pos.CENTER);
		artistText.setMaxWidth(Double.MAX_VALUE);
		artistText.setAlignment(Pos.CENTER);
		albumText.setMaxWidth(Double.MAX_VALUE);
		albumText.setAlignment(Pos.CENTER);
		genreText.setMaxWidth(Double.MAX_VALUE);
		genreText.setAlignment(Pos.CENTER);
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


	@Override
	public void Update(){

		if (mp3player != null) {
			mp3player.dispose();
			mp3player = null;
		}

		if (controller.checkSongExist(this.model.getPlayerModel().getCurrentSong().getSong_id())) {
			if (this.model.getPlayerModel().getCurrentSong() != null) {
				titleText.setText(this.model.getPlayerModel().getCurrentSong().getSong_name());
				artistText.setText("by " + this.model.getPlayerModel().getCurrentSong().getArtist_name());
				genreText.setText(this.model.getPlayerModel().getCurrentSong().getGenre());

				Image albpic = controller.getImageFromAlbum(this.model.getPlayerModel().getCurrentSong().getAlbum_id());
				songPic.setFill(new ImagePattern(albpic));

				Album album = controller.getAlbumOfSong(this.model.getPlayerModel().getCurrentSong().getAlbum_id());

				if (album != null) {
					albumText.setText("Album: " + album.getName());
				}
				else {
					albumText.setText("Album: None");
				}

				File check = new File(System.getProperty("user.home") + "/documents/Beatify/SongCache/" + this.model.getPlayerModel().getCurrentSong().getSong_id() +".mp3");
				if (check.exists()){
					System.out.println("FILE ALREADY EXISTS, PLAY THAT INSTEAD");
					currentSongMedia = new Media(check.toURI().toString());
				}
				else {
					currentSongMedia = controller.getSongFile(model.getPlayerModel().getCurrentSong());
				}
				mp3player = new MediaPlayer(currentSongMedia);
				toggleToPlay();
				setPlayerFunctionality();

			}
		}
		else {
			this.model.getPlayerModel().playNextSong();
		}


	}

	public void nextSong(ActionEvent actionEvent) {

		if (this.model.getPlayerModel().getCurrentSong() != null) {
			controller.playNextSong();
		}
	}

	public void prevSong(ActionEvent actionEvent) {
		if (this.model.getPlayerModel().getCurrentSong()!= null) {
			controller.playPrevSong();
		}
	}

	public void shuffle(ActionEvent actionEvent) {
		if(controller.toggleShuffle()) {
			shuffleBtn.setGraphic(shuffleClickedView);
		}
		else {
			shuffleBtn.setGraphic(shuffleView);
		}
	}

	public void repeat(ActionEvent actionEvent) {
		if(controller.toggleRepeat()) {
			repeatBtn.setGraphic(repeatClickedView);
		}
		else {
			repeatBtn.setGraphic(repeatView);
		}
	}

	public void endPlayer() {
		if (mp3player != null) {
			mp3player.stop();
		}
	}

	private void toggleToPlay() {
		mp3player.play();
		playBtn.setGraphic(pauseView);
	}

	private void toggleToPause() {
		mp3player.pause();
		playBtn.setGraphic(playView);
	}

	public void turnVolumeUp(ActionEvent actionEvent){
		if (mp3player!= null) {
			if (volume < 1) {
				volume += 0.1;
				mp3player.setVolume(volume);
			}
		}

	}

	public void turnVolumeDown(ActionEvent actionEvent){

		if (mp3player!=null) {
			if (volume > 0) {
				volume -= 0.1;
				mp3player.setVolume(volume);
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
				playBtn.setGraphic(playView);
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


	public void playPause(ActionEvent actionEvent) {

		if (this.model.getPlayerModel().getCurrentSong() != null ){
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
}
