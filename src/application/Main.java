package application;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scene.controller.GameSceneController;

import scene.controller.StartSceneController;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			StartSceneController start = new StartSceneController();
			primaryStage = start.getMainStage();
			primaryStage.show();
			
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
