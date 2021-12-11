package scene.controller;

import scene.manager.SceneManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import application.ThreadMain;
import entity.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameSceneController extends Controller {
	private static final Image background = new Image("/scene/controller/res/Background1.png");
	private static final Image ken = new Image("/scene/controller/res/ken_player.gif");
	private static final Image ryu = new Image("/scene/controller/res/ryu_player.gif");
	private final String FONT_PATH = "/scene/controller/res/PressStart2P-vaV7.ttf";
	private static final int HEIGHT = 576;
	private static final int WIDTH = 1024;
	private static int countPlayer1;
	private static int countPlayer2;
	private static PowerBall nextBallKen;
	private static PowerBall nextBallRyu; 
	private EarthBall eB = new EarthBall(100, 100, 5);
	private FireBall fb = new FireBall(100,100,5);
	private static AnchorPane mainPane ;
	private Scene mainScene;
	private Stage mainStage;
	private ThreadMain threadMain;
	private VBox mainRoot;
	
	Canvas canvas = new Canvas();
	GraphicsContext ctx = canvas.getGraphicsContext2D();
	private static Text txtCount1,txtCount2;
	boolean trigger = false;

	public GameSceneController() {
		// TODO Auto-generated constructor stub
		threadMain = new ThreadMain();
		randomBall();
		countPlayer1 = 0;
		countPlayer2 = 0;
		txtCount1 = new Text("0");
		txtCount2 = new Text("0");
		mainRoot = new VBox();
		mainPane = new AnchorPane();
		mainStage = new Stage();
		drawBackground();
		initializePlayer();
		initializeNextBallBar();
		setClickedCountedFont();
		mainRoot.getChildren().add(mainPane);
		mainScene = new Scene(mainRoot, WIDTH, HEIGHT);
		setOnCharged();
		mainStage.setScene(mainScene);
		mainStage.setTitle("Hadoz");
		

	}

	public GameSceneController(String fXMLPath, Controller controllerCaller) {
		super(fXMLPath, controllerCaller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setSceneManager(SceneManager scenemanager) {
		// TODO Auto-generated method stub

	}
	
	
	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	public Scene getMainScene() {
		return mainScene;
	}

	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}

	public void setOnCharged() {
		mainScene.setOnKeyPressed((KeyEvent e) -> {
			String new_code = e.getCode().toString();
			System.out.println(new_code);
			if(!trigger) {
				trigger = true;
				if (new_code.equals("SPACE")) {
					EarthBall fB = new EarthBall(100, 100, 5);
					threadMain.initalizeNewPlayer(fB);
					countPlayer1 = 0;
					threadMain.updatePlayerCount(countPlayer1, countPlayer2);
				}
				if(new_code.equals("ENTER")) {
					WaterBall fB = new WaterBall(950, 100, -5);
					threadMain.initalizeNewPlayer(fB);
					countPlayer2 = 0;
					threadMain.updatePlayerCount(countPlayer1, countPlayer2);
				}
				if(new_code.equals("A")) {
					countPlayer1++;	
					threadMain.updatePlayerCount(countPlayer1, countPlayer2);
				}
				if(new_code.equals("D")){
					countPlayer1++;
					threadMain.updatePlayerCount(countPlayer1, countPlayer2);
				}
				if(new_code.equals("RIGHT")) {
					countPlayer2++;
					threadMain.updatePlayerCount(countPlayer1, countPlayer2);
				}
				if(new_code.equals("LEFT")) {
					countPlayer2++;
					threadMain.updatePlayerCount(countPlayer1, countPlayer2);
				}
			}
		});
		mainScene.setOnKeyReleased(new EventHandler<KeyEvent>() { 
				@Override
				public void handle(KeyEvent event) {
					trigger = false;
				}	
		});
	}
	
	public void setClickedCountedFont() {
		try {
            txtCount1.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 14));
            txtCount2.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 14));
        }catch(FileNotFoundException e){
            txtCount1.setFont(Font.font("Verdana",14));
            txtCount2.setFont(Font.font("Verdana",14));
        }
		txtCount1.relocate(20, 10);
		txtCount2.relocate(990, 10);
		mainPane.getChildren().addAll(txtCount1,txtCount2);
	}

	protected void drawBackground() {
		ImageView backgroundImgView = new ImageView(background);
		mainPane.getChildren().add(backgroundImgView);
	}

	protected void initializePlayer() {
		ImageView kenn = new ImageView(ken);
//        removeFromPane(kenn);
		kenn.setFitHeight(0.3 * kenn.prefHeight(1));
		kenn.setFitWidth(0.3 * kenn.prefWidth(1));
		kenn.relocate((double) (70), (double) (340));
		mainPane.getChildren().add(kenn);

		ImageView ryuu = new ImageView(ryu);
		ryuu.setScaleX(-1);
		ryuu.setFitHeight(0.3 * ryuu.prefHeight(1));
		ryuu.setFitWidth(0.3 * ryuu.prefWidth(1));
		mainPane.getChildren().remove(ryuu);
		ryuu.relocate((double) (900), (double) (340));
		mainPane.getChildren().add(ryuu);

	}
	
	protected void initializeNextBallBar() {
		ImageView firePicRyu = new ImageView(entity.FireBall.getFireballl());
		ImageView EarthPicRyu = new ImageView(entity.EarthBall.getEarthball());
		ImageView WaterPicRyu = new ImageView(entity.WaterBall.getWaterballl());
		

		ImageView firePicKen = new ImageView(entity.FireBall.getFireballl());
		ImageView EarthPicKen = new ImageView(entity.EarthBall.getEarthball());
		ImageView WaterPicKen = new ImageView(entity.WaterBall.getWaterballl());
		
		firePicRyu.relocate((double) (900), (double) (500));
		firePicRyu.setFitHeight(0.1 * firePicRyu.prefHeight(1));
		firePicRyu.setFitWidth(0.1 * firePicRyu.prefWidth(1));
		EarthPicRyu.relocate((double) (900), (double) (500));
		EarthPicRyu.setFitHeight(0.1 * EarthPicRyu.prefHeight(1));
		EarthPicRyu.setFitWidth(0.1 * EarthPicRyu.prefWidth(1));
		WaterPicRyu.relocate((double) (900), (double) (500));
		WaterPicRyu.setFitHeight(0.1 * WaterPicRyu.prefHeight(1));
		WaterPicRyu.setFitWidth(0.1 * WaterPicRyu.prefWidth(1));
		mainPane.getChildren().add(firePicRyu);
		
	}
	
	public static void drawBall(PowerBall ball) {
		ImageView im = (ball).getImageView();
//		System.out.println(im);
		mainPane.getChildren().remove(im);
		mainPane.getChildren().remove(im);
		im.relocate((double) (ball.getX()), (double) (340));
		mainPane.getChildren().add(im);
	}
	
	public static void updateCount(int count1,int count2) {
		System.out.println(count1+" "+count2);
		txtCount1.setText(Integer.toString(count1));
		txtCount2.setText(Integer.toString(count2));
	}
	public void randomBall() {
		Random rand = new Random();
		int r = rand.nextInt(3);
		if(r==0) {
			ImageView FB = new ImageView(FireBall.getFireballl());
			
		}
		else if(r==1) {
			ImageView EB = new ImageView(EarthBall.getEarthball());
			
		}
		else if(r==2) {
			ImageView WB = new ImageView(WaterBall.getWaterballl());
			
		}
	}

	public static Image getBackground() {
		return background;
	}

	public static Image getKen() {
		return ken;
	}

	public static Image getRyu() {
		return ryu;
	}

	public String getFONT_PATH() {
		return FONT_PATH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getCountPlayer1() {
		return countPlayer1;
	}

	public static int getCountPlayer2() {
		return countPlayer2;
	}

	public static AnchorPane getMainPane() {
		return mainPane;
	}

	public ThreadMain getThreadMain() {
		return threadMain;
	}

	public VBox getMainRoot() {
		return mainRoot;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public GraphicsContext getCtx() {
		return ctx;
	}

	public static Text getTxtCount1() {
		return txtCount1;
	}

	public static Text getTxtCount2() {
		return txtCount2;
	}

	public boolean isTrigger() {
		return trigger;
	}
	

}