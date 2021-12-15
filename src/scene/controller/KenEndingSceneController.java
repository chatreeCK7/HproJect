package scene.controller;

import component.HpBar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class KenEndingSceneController  {

	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	private final String IMGPATH = "/scene/controller/res/ken-ending.gif";
	private HpBar endingText;
	private HpBar winnerText;

	public KenEndingSceneController() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, 1024, 576);
		mainStage = new Stage();
		mainStage.setTitle("Ken is Winner !");
		mainStage.setScene(mainScene);
		createBackground();
		createText("K O!");
		createWinnerText("Winnerr !! is K E N ");

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
		Image kenEnding = new Image(IMGPATH, 1024, 576, false, true);
		BackgroundImage background = new BackgroundImage(kenEnding, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
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
