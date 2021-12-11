package entity;

import scene.controller.*;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
public class EarthBall extends PowerBall{
	private static final Image EarthBall = new Image("/entity/res/earthBall.gif");

	public EarthBall(int x, int highLevel, int playerSide, int power) {
		super(x, highLevel, playerSide, power);
		if(playerSide > 0)
			createFirstPowerBall(GameSceneController.getCountPlayer1());
		else 
			createFirstPowerBall(GameSceneController.getCountPlayer2());
		// TODO Auto-generated constructor stub
	}
	@Override
	public void createFirstPowerBall(int count) {
		// TODO Auto-generated method stub
		double size = 0.06+0.004*count;
		imageView = new ImageView(EarthBall);
		imageView.setFitHeight(size*imageView.prefHeight(1));
		imageView.setFitWidth(size*imageView.prefWidth(1));
	}
	@Override
	public ImageView getImageView() {
		// TODO Auto-generated method stub
		return imageView;
	}
	public static Image getEarthball() {
		return EarthBall;
	}
	
}
