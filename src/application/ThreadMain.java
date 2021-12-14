package application;

import entity.*;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import scene.controller.GameSceneController;

public class ThreadMain {
	private static final Image Empty = new Image("/scene/controller/res/Empty Sprite.png");
	private static int xTopLaneKen;
	private static int xMidLaneKen;
	private static int xBottomLaneKen;
	private static PowerBall topBallKen;
	private static int xTopLaneRyu;
	private static int xMidLaneRyu;
	private static int xBottomLaneRyu;
	private static PowerBall topBallRyu;
	
	public void intializeRespawnItem() {
			new Thread(()->{
				respawnItem(GameSceneController.getMainItem());
			}).start();

	}
	
	public void initalizeNewPlayer1(PowerBall ball) {
		new Thread(()->{
			xKenInit();
			updatePlayerMovementKen(ball);
		}).start();
	}
	public void initalizeNewPlayer2(PowerBall ball) {
		new Thread(()->{
			xRyuInit();
			updatePlayerMovementRyu(ball);
		}).start();
	}
	
	protected void updatePlayerMovementKen(PowerBall ball) {
		try {
			while(ball.isInMap()) {
				Thread.sleep(50);
				Platform.runLater(()->{
					((PowerBall)ball).update();
					GameSceneController.drawBall(ball);
					
					if(ball.getX()>xTopLaneKen && ball.getY()==0) {
						xTopLaneKen = ball.getX();
						topBallKen = ball;
					}
					if(xTopLaneKen == xTopLaneRyu || xTopLaneKen == xTopLaneRyu+5 ) {
						isBoom(topBallKen,topBallRyu);
					}
//					System.out.println(xTopLaneKen+" "+ball.getX());
				});
			}
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	protected void updatePlayerMovementRyu(PowerBall ball) {
		try {
			while(ball.isInMap()) {
				Thread.sleep(50);
				Platform.runLater(()->{
					((PowerBall)ball).update();
					GameSceneController.drawBall(ball);
					if(ball.getX()<xTopLaneRyu && ball.getY()==0) {
						xTopLaneRyu = ball.getX();
						topBallRyu = ball;
					}
					if(xTopLaneKen == xTopLaneRyu || xTopLaneKen == xTopLaneRyu+5 ) {
						isBoom(topBallRyu,topBallKen);
					}
//					System.out.println(xTopLaneKen+" = "+xTopLaneRyu+" "+ball.getX());
						
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
	public void isBoom(PowerBall lossBall,PowerBall winBall) {
		if(lossBall.getCount() < winBall.getCount()) {
			ImageView im = (lossBall).getImageView();
			im.relocate((double) (0), (double) -800);
			lossBall.setInMap(false);
			ImageView temp = new ImageView(Empty);
			lossBall.setImageView(temp);
			lossBall.setX(9999);
			if(lossBall.getPlayerSide()<0)
				xRyuInit();
			else if(lossBall.getPlayerSide()>0) {
				xKenInit();
			}
		}
	}
	
	public void respawnItem(Item item) {
		GameSceneController.setMainItem(Item.randomItem());
		while(true) {
			try {
				int min = 4000;  
				int max = 7000;  
				int t = (int)(Math.random()*(max-min+1)+min);
				Thread.sleep(t);
				Platform.runLater(()->{
					GameSceneController.getMainPane().getChildren().remove(GameSceneController.getMainItem().getItemImage());
					System.out.println("setEmpty completed ");
					GameSceneController.initializeItem();
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void xKenInit() {
		xTopLaneKen=0;
		xMidLaneKen=0;
		xBottomLaneKen=0;
	}
	public void xRyuInit() {
		xTopLaneRyu = 9999;
		xMidLaneRyu = 9999;
		xBottomLaneRyu =9999;
	}
}