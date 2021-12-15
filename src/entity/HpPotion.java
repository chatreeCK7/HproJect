package entity;

import entity.base.Interactable;
import scene.controller.GameSceneController;

public class HpPotion extends Item implements Interactable {

	public HpPotion() {
		// TODO Auto-generated constructor stub
	}

	public HpPotion(String name, int Label) {
		super("hpPotion", 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean interact(char side) {
		// TODO Auto-generated method stub
		if(side == 'l') {
			GameSceneController.setKenHp(GameSceneController.getKenHp()+15);
			return true;
		}else  if(side == 'r') {
			GameSceneController.setRyuHp(GameSceneController.getRyuHp()+15);
			return true;
		}
		return false;
	}

}
