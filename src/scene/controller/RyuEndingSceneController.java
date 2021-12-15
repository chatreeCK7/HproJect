package scene.controller;

import component.HpBar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class RyuEndingSceneController {

	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	private final String IMGPATH = "/scene/controller/res/ryu-sunset.gif";
	private HpBar endingText;
	private HpBar winnerText;

	public RyuEndingSceneController() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, 1024, 576);
		mainStage = new Stage();
		mainStage.setTitle("Ryu is Winner !");
		mainStage.setScene(mainScene);
		createBackground();
		createText("K O!");
		createWinnerText("Winnerr !! is R Y U ");

		// TODO Auto-generated constructor stub
	}

//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		primaryStage = mainStage;
//		primaryStage.show();
//
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}

	public void createBackground() {
		Image ryuEnding = new Image(IMGPATH, 1024, 576, false, true);
		BackgroundImage background = new BackgroundImage(ryuEnding, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}

	public void createText(String text) {
		endingText = new HpBar(text);
		mainPane.getChildren().add(endingText);
		endingText.relocate(170, 30);
	}

	public void createWinnerText(String text) {
		winnerText = new HpBar(text);
		mainPane.getChildren().add(winnerText);
		endingText.relocate(270, 30);
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
