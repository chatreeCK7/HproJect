package entity;

import scene.controller.*;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class FireBall extends PowerBall{
	private static final Image fireBalll = new Image("/entity/res/fireBall.png");

	public FireBall(int x, int highLevel, int playerSide) {
		super(x, highLevel, playerSide);
	}

	@Override
	public void createFirstPowerBall(int count) {
		System.out.println(count);
		// TODO Auto-generated method stub
		double size = 0.04+0.004*count;
		imageView = new ImageView(fireBalll);
		imageView.setFitHeight(size*imageView.prefHeight(1));
		imageView.setFitWidth(size*imageView.prefWidth(1));
	}

	@Override
	public ImageView getImageView() {
		// TODO Auto-generated method stub
//		imageView = new ImageView(fireBall);
		return imageView;
	}

	public static Image getFireballl() {
		return fireBalll;
	}
	

}
