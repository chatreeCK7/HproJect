package entity;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import scene.controller.GameSceneController;

public abstract class PowerBall {
	
	int x, y, highLevel, speedX, speedY, playerSide;
	boolean isInMap;
	ImageView imageView;

	public PowerBall(int x,int highLevel,int playerSide) {
		this.x = x;
		this.y = 10 + highLevel*80;
		speedX = playerSide;
		speedY = 0;
		isInMap=true;
		// TODO Auto-generated constructor stub
	}
	
	abstract public void createFirstPowerBall();
	abstract public ImageView getImageView();
	
	public void update() {
		System.out.println(this.x);
		if(this.x<1000)
			this.x +=speedX;
		else {
//			GameSceneController.removeFromPane(imageView);
			isInMap=false;
		}
	}
	public boolean isInMap() {
		return isInMap;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHighLevel() {
		return highLevel;
	}
	public int getSpeedX() {
		return speedX;
	}
	public int getSpeedY() {
		return speedY;
	}
	public int getPlayerSide() {
		return playerSide;
	}
}
