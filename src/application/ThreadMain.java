package application;
import entity.*;
import javafx.application.Platform;
import scene.controller.GameSceneController;

public class ThreadMain {
	
	public void initalizeNewPlayer(PowerBall ball) {
		new Thread(()->{
			updatePlayerMovement(ball);
		}).start();
	}
	
	protected void updatePlayerMovement(PowerBall ball) {
		try {
			while(ball.isInMap()) {
				Thread.sleep(50);
				Platform.runLater(()->{
					((PowerBall)ball).update();
					GameSceneController.drawBall(ball);
				});
			}
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public void updatePlayerCount(int count1,int count2) {
		new Thread(()->{
			Platform.runLater(()->{
				GameSceneController.updateCount(count1,count2);
			});
		}).start();
	}
}