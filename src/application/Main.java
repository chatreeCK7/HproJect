package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import scene.controller.GameSceneController;

import scene.controller.StartSceneController;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			StartSceneController start = new StartSceneController();
			primaryStage = start.getMainStage();
			primaryStage.setResizable(false);
			primaryStage.show();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	        	  GameSceneController.getSceneSound().stop();
	        	  System.exit(0);
//	        	  Environment.Exit(Environment.ExitCode);
//	              System.out.println("Stage is closing");
	          }
	      });        
//		primaryStage.close();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
