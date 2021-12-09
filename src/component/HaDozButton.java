package component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class HaDozButton extends Button {
	
	private final String FONT_PATH = "src/component/res/PressStart2P-vaV7.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/component/res/green_button05_pressed.png');";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/component/res/green_button04_spacebar.png');";
	
	public HaDozButton(String text) {
		// TODO Auto-generated constructor stub
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListener();
		
	}
	
	public void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 14));
		}catch(FileNotFoundException e){
			setFont(Font.font("Verdana",14));
		}
		
	}
	
	public void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY()+4);
	
	}
	
	public void setButtonFreeStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY()-4);
	}
	
	public void initializeButtonListener() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// press the button
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}
			
			
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				// release the button
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					setButtonFreeStyle();
				}
			}
			
		});
		
//		setOnMouseEntered(new EventHandler<MouseEvent>(){
//
//			@Override
//			public void handle(MouseEvent e) {
//				// drop shadow
//				setEffect(new DropShadow());
//			}
//			
//		});
//		
//		setOnMouseExited(new EventHandler<MouseEvent>(){
//
//			@Override
//			public void handle(MouseEvent e) {
//				// set null effect
//				setEffect(null);
//				
//			}
//			
//		});
	}
}

