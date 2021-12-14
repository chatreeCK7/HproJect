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
	private static PowerBall midBallKen;
	private static PowerBall bottomBallKen;
	private static int xTopLaneRyu;
	private static int xMidLaneRyu;
	private static int xBottomLaneRyu;
	private static PowerBall topBallRyu;
	private static PowerBall midBallRyu;
	private static PowerBall bottomBallRyu;
	
	public void intializeRespawnItem() {
			new Thread(()->{
				respawnItem(GameSceneController.getMainItem());
			}).start();

	}
	
	public void initalizeNewPlayer1(PowerBall ball) {
		new Thread(()->{
			xKenInit();
			xRyuInit();
			updatePlayerMovementKen(ball);
		}).start();
	}
	public void initalizeNewPlayer2(PowerBall ball) {
		new Thread(()->{
			xKenInit();
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
					
					if(ball.getX()>xTopLaneKen && ball.getY()==0) {	//	Top lane
						xTopLaneKen = ball.getX();
						topBallKen = ball;
					}
					else if(ball.getX()>xMidLaneKen && ball.getY()==170) {	//	Mid lane
						xMidLaneKen = ball.getX();
						midBallKen = ball;
					}
					else if(ball.getX()>xBottomLaneKen && ball.getY()==340) {	//	Bottom lane
						xBottomLaneKen = ball.getX();
						bottomBallKen = ball;
					}
					if(ball.isAttack()) {	// when ball attacked, deleted it and initialize
						ImageView im = (ball).getImageView();
						im.relocate((double) (-1), (double) -800);
						ball.setInMap(false);
						ImageView temp = new ImageView(Empty);
						ball.setImageView(temp);
						xKenInit();
					}
					
					if(xTopLaneKen == xTopLaneRyu || xTopLaneKen == xTopLaneRyu+5 ) {	//Check Boom Top
						BooMMM(topBallKen,topBallRyu);
					}
					if(xMidLaneKen == xMidLaneRyu || xMidLaneKen == xMidLaneRyu+5 ) {	//Check Boom Mid
						BooMMM(midBallKen,midBallRyu);
					}
					if(xBottomLaneKen == xBottomLaneRyu || xBottomLaneKen == xBottomLaneRyu+5 ) {	//Check Boom Bottom
						BooMMM(bottomBallKen,bottomBallRyu);
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
					else if(ball.getX()<xMidLaneRyu && ball.getY()==170) {	//	Mid lane
						xMidLaneRyu = ball.getX();
						midBallRyu = ball;
					}
					else if(ball.getX()<xBottomLaneRyu && ball.getY()==340) {	//	Bottom lane
						xBottomLaneRyu = ball.getX();
						bottomBallRyu = ball;
					}
					
					if(ball.isAttack()) {	// when ball attacked, deleted it and initialize
						ImageView im = (ball).getImageView();
						im.relocate((double) (-1), (double) -800);
						ball.setInMap(false);
						ImageView temp = new ImageView(Empty);
						ball.setImageView(temp);
						xRyuInit();
					}
					
					if(xTopLaneKen == xTopLaneRyu || xTopLaneKen == xTopLaneRyu+5 ) {
						BooMMM(topBallRyu,topBallKen);
					}
					else if(xMidLaneKen == xMidLaneRyu || xMidLaneKen == xMidLaneRyu+5 ) {	//Check Boom Mid
						BooMMM(midBallRyu,midBallKen);
					}
					else if(xBottomLaneKen == xBottomLaneRyu || xBottomLaneKen == xBottomLaneRyu+5 ) {	//Check Boom Bottom
						BooMMM(bottomBallRyu,bottomBallKen);
					}
//					System.out.println(xTopLaneKen+" = "+xTopLaneRyu+" "+ball.getX()+" "+ball.getY());
						
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
	public void BooMMM(PowerBall BallKen, PowerBall BallRyu) {
		if(BallKen.getElement().equals(PowerBallType.EARTH) && BallRyu.getElement().equals(PowerBallType.WATER)) {
			BallKen.setCount(BallKen.getCount()+5);
		}
		else if(BallKen.getElement().equals(PowerBallType.WATER) && BallRyu.getElement().equals(PowerBallType.EARTH)) {
			BallRyu.setCount(BallRyu.getCount()+5);
		}
		else if(BallKen.getElement().equals(PowerBallType.WATER) && BallRyu.getElement().equals(PowerBallType.FIRE)) {
			BallKen.setCount(BallKen.getCount()+5);
		}
		else if(BallKen.getElement().equals(PowerBallType.FIRE) && BallRyu.getElement().equals(PowerBallType.WATER)) {
			BallRyu.setCount(BallRyu.getCount()+5);
		}
		else if(BallKen.getElement().equals(PowerBallType.FIRE) && BallRyu.getElement().equals(PowerBallType.EARTH)) {
			BallKen.setCount(BallKen.getCount()+5);
		}
		else if(BallKen.getElement().equals(PowerBallType.EARTH) && BallRyu.getElement().equals(PowerBallType.FIRE)) {
			BallRyu.setCount(BallRyu.getCount()+5);
		}
		isBoomBoth(BallRyu,BallKen);
		isBoom(BallKen,BallRyu);
		isBoom(BallRyu,BallKen);
	}
	
	public void isBoom(PowerBall lossBall,PowerBall winBall) {
		if(lossBall.getCount() < winBall.getCount()) {
			winBall.setCount(winBall.getCount()-lossBall.getCount());
			ImageView im = (lossBall).getImageView();
			im.relocate((double) (-1), (double) -800);
			lossBall.setInMap(false);
			ImageView temp = new ImageView(Empty);
			lossBall.setImageView(temp);
			if(lossBall.getPlayerSide()<0) {
				xRyuInit();
				lossBall.setX(9999);
			}
			else if(lossBall.getPlayerSide()>0) {
				xKenInit();
				lossBall.setX(-9999);
			}
			winBall.createFirstPowerBall(winBall.getCount());
		}
	}
	
	public void isBoomBoth(PowerBall BallKen, PowerBall BallRyu) {
		if(BallKen.getCount()==BallRyu.getCount() && BallKen.getClass().equals(BallRyu.getClass())) {	//same Power & Element
			System.out.println(BallKen.getCount()+" "+BallRyu.getCount());
			ImageView im = (BallKen).getImageView();
			im.relocate((double) (-1), (double) -800);
			BallKen.setInMap(false);
			ImageView temp = new ImageView(Empty);
			BallKen.setImageView(temp);
			BallKen.setX(-9999);
			ImageView im2 = (BallRyu).getImageView();
			im2.relocate((double) (-1), (double) -800);
			BallRyu.setInMap(false);
			ImageView temp2 = new ImageView(Empty);
			BallRyu.setImageView(temp2);
			BallRyu.setX(9999);
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