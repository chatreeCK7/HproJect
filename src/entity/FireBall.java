package entity;

import scene.controller.GameSceneController;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class FireBall extends PowerBall {
	
	private static final ImageView FIREBALL = new ImageView(new Image("/entity/res/fireBall.png"));

	public FireBall(int x, int highLevel, int playerSide) {
		// TODO Auto-generated constructor stub
		super(x, highLevel, playerSide);
		createFirstPowerBall();
		
	}
	
	
	@Override
	public void createFirstPowerBall() {
		// TODO Auto-generated method stub
		imageView = FIREBALL; 
		imageView.setFitHeight(0.125*imageView.prefHeight(1));
		imageView.setFitWidth(0.125*imageView.prefWidth(1));
		
	}

	@Override
	public ImageView getImageView() {
		// TODO Auto-generated method stub
		return imageView;
	}
}
