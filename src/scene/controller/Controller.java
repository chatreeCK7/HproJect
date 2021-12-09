package scene.controller;

import javafx.scene.layout.Pane;
import scene.manager.SceneManager;

public abstract class Controller {
	protected String FXMLPath; //scene's fxml path
	protected Controller controllerCaller;//
	protected Pane backPane;
	protected SceneManager ourSceneManager;
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	public Controller(String fXMLPath, Controller controllerCaller) {
		super();
		setFXMLPath(fXMLPath);
		setControllerCaller(controllerCaller);
	}
	public abstract void setSceneManager(SceneManager scenemanager);
	
	public String getFXMLPath() {
		return FXMLPath;
	}
	public void setFXMLPath(String fXMLPath) {
		FXMLPath = fXMLPath;
	}
	public Controller getControllerCaller() {
		return controllerCaller;
	}
	public void setControllerCaller(Controller controllerCaller) {
		this.controllerCaller = controllerCaller;
	}
	public Pane getBackPane() {
		return backPane;
	}
	public void setBackPane(Pane backPane) {
		this.backPane = backPane;
	}
	public SceneManager getOurSceneManager() {
		return ourSceneManager;
	}
	public void setOurSceneManager(SceneManager ourSceneManager) {
		this.ourSceneManager = ourSceneManager;
	}
	
	
}
