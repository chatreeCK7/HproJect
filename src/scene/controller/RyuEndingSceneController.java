package scene.controller;

import component.EndingText;
import component.ExitText;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RyuEndingSceneController {

	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private AudioClip sound = new AudioClip(ClassLoader.getSystemResource("component/res/ryu-ending.wav").toString());
	private final String IMGPATH = "/scene/controller/res/ryu-sunset.gif";
	private EndingText winnerText;
	private ExitText exitText;

	public RyuEndingSceneController() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, 1024, 576);
		mainStage = new Stage();
		mainStage.setTitle("Ryu is Winner !");
		mainStage.setScene(mainScene);
		createBackground();
		createWinnerText("Winner!! is R Y U");
		createExitText("Press to exit.");
		exit();

		// TODO Auto-generated constructor stub
	}
	
	public void exit() {
		mainScene.setOnKeyPressed((KeyEvent) -> {
			System.exit(0);
		});
	}
	
	public void playSound() {
		sound.play();
	}
	
	public void createBackground() {
		Image ryuEnding = new Image(IMGPATH, 1024, 576, false, true);
		BackgroundImage background = new BackgroundImage(ryuEnding, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	public void createWinnerText(String text) {
		winnerText = new EndingText(text,Color.WHITESMOKE);
		mainPane.getChildren().add(winnerText);
		winnerText.relocate(120, 30);
	}
	
	public void createExitText(String text) {
		exitText = new ExitText(text,Color.WHITESMOKE);
		mainPane.getChildren().add(exitText);
		exitText.relocate(270, 450);
	}

	public AnchorPane getMainPane() {
		return mainPane;
	}

	public void setMainPane(AnchorPane mainPane) {
		this.mainPane = mainPane;
	}

	public Scene getMainScene() {
		return mainScene;
	}

	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}


}
