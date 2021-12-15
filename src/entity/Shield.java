package entity;

import entity.base.Interactable;
import scene.controller.GameSceneController;

public class Shield extends Item implements Interactable {

	public Shield() {
		// TODO Auto-generated constructor stub
	}

	public Shield(String name, int Label) {
		super("shield", 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean interact(char side) {
		// TODO Auto-generated method stub
		if(side == 'l') {
			GameSceneController.setKenShielded(true);
			return true;
		}else  if(side == 'r') {
			GameSceneController.setRyuShielded(true);
			return true;
		}
		
		return false;
	}

}
