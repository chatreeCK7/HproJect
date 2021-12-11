package scene.controller;

import component.HpBar;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class KenEndingSceneController {
	
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private HpBar endingText;
	private HpBar winnerText;
	

	public KenEndingSceneController() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,1024,576);
		mainStage = new Stage();
		mainStage.setTitle("Ken is Winner !");
		mainStage.setScene(mainScene);
		createText("K O!");
		createWinnerText("Winnerr !! is K E N ");
		
		// TODO Auto-generated constructor stub
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
