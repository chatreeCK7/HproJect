package component;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class BackButton extends Button{
	
	private final String BACK_BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/component/res/grey_boxCross.png');";
	
	public BackButton() {
		// TODO Auto-generated constructor stub
		setPrefSize(37, 37);
		setStyle(BACK_BUTTON_STYLE);
	}

}
