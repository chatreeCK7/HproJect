package entity;

import java.util.Random;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import scene.controller.GameSceneController;

public class Item {
	
	private String name;
	private int itemLabel;
	private final int posX = 480;
	private int posY;
	private ImageView itemImage;
	
	public Item() {
		setName("none");
		setItemLabel(-1);
	}
	
	public Item(String name,int Label) {
		setName(name);
		setItemLabel(Label);
		// TODO Auto-generated constructor stub
	}

	public ImageView getItemImage(int itemLabel) {
		switch (itemLabel){
		case 0: {
			itemImage = new  ImageView(new Image("/scene/controller/res/shield.png"));
			itemImage.setFitHeight(0.3 * itemImage.prefHeight(1));
			itemImage.setFitWidth(0.3 * itemImage.prefWidth(1));
			return itemImage;
		}
		case 1: {
			itemImage = new  ImageView(new Image("/scene/controller/res/hpPotion.png"));
			itemImage.setFitHeight(0.3 * itemImage.prefHeight(1));
			itemImage.setFitWidth(0.3 * itemImage.prefWidth(1));
			return itemImage;
		}
		case 2: {
			itemImage = new  ImageView(new Image("/scene/controller/res/dmPotion.png"));
			itemImage.setFitHeight(0.3 * itemImage.prefHeight(1));
			itemImage.setFitWidth(0.3 * itemImage.prefWidth(1));
			return itemImage;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + itemLabel);
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(!name.equals("shield") && !name.equals("hpPotion") && !name.equals("dmPotion"))
			this.name = "Uncompatable Name";
		else
			this.name = name;
	}

	public int getItemLabel() {
		return itemLabel;
	}

	public void setItemLabel(int itemLabel) {
		this.itemLabel = itemLabel;
	}
	
	public static Item randomItem() {
		Random rand = new Random();
		int textlabel = rand.nextInt(3);
		switch (textlabel) {
		case 0: {
			return new Shield("shield", 0);
		}
		case 1: {
			return new HpPotion("hpPotion", 1);
		}
		case 2: {
			return new DmPotion("dmPotion", 2);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + textlabel);
		}
	}
	
	public int randomPosY() {
		Random rand = new Random();
		int randPosY = rand.nextInt(3); //0: lane 0, 1: lane 1, 2: lane 2
		switch (randPosY) {
		case 0: {
			this.posY = 340;
			return getPosY();
		}
		case 1: {
			this.posY = 220;
			return getPosY();
		}
		case 2: {
			this.posY = 100;
			return getPosY();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + randPosY);
		}
	}
	
	public int getPosY() {
		return posY;
	}

	public ImageView getItemImage() {
		return itemImage;
	}

	public void setItemImage(ImageView itemImage) {
		this.itemImage = itemImage;
	}

	public int getPosX() {
		return posX;
	}
	
	public void respawnItem() {
		new Thread(()->{
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
						GameSceneController.randomItem();
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	
	
}
