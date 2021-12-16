package entity;

import entity.base.Entity;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;

public class Player extends Entity{
	
	private final int hp = 100;
	private int playerPosY;
	
	private KeyCode keyMove;
	private KeyCode keyCharge;
	private KeyCode keyRelease;
	
	private boolean isOut;
	private boolean isDead;
	private boolean ballStatus;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void moveY(KeyCode keymove) {
		String key = keymove.toString();
		switch(key) {
			case "W":	playerPosY += 200;
						break;
			case "S":	playerPosY -= 200;
						break;
		}
	}
	
	public void chargePower(KeyCode keycharge){
		
	}
	
	public void isDead() {
		isDead = hp > 0 ? false : true ;
	}
	
	public void isOut() {
		isOut = (playerPosY > 576 || playerPosY < 0) ? true:false;
	}
	
	
	
	
	
	

}