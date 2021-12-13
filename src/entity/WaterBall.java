package entity;

import scene.controller.*;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class WaterBall extends PowerBall{
	private static final Image waterBalll = new Image("/entity/res/waterBall.gif");
	private double Height;
	private double Width;
	public WaterBall(int x, int highLevel, int playerSide) {
		super(x, highLevel, playerSide);
		imageView = new ImageView(waterBalll);
		Height = imageView.prefHeight(1);
		Width = imageView.prefWidth(1);
	}

	@Override
	public void createFirstPowerBall(int count) {
		// TODO Auto-generated method stub
		System.out.println(count);
		double size = 0.13+0.006*count;
		imageView.setFitHeight(size*Height);
		imageView.setFitWidth(size*Width);
	}

	@Override
	public ImageView getImageView() {
		// TODO Auto-generated method stub
//		imageView = new ImageView(waterBall);
		return imageView;
	}

	public static Image getWaterballl() {
		return waterBalll;
	}

	@Override
	public PowerBallType getElement() {
		// TODO Auto-generated method stub
		return PowerBallType.WATER;
	}
	

}
