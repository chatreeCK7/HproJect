package component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class CountLabel extends Label{
	
	private final String FONT_PATH = "src/component/res/PressStart2P-vaV7.ttf";

	public CountLabel(String text) {
		// TODO Auto-generated constructor stub
		setPrefSize(300, 50);
		setPadding(new Insets(40));
		setText("Power "+text);
		setWrapText(true);
		setLabelFont();
	}

	private void setLabelFont() {
		// TODO Auto-generated method stub
		try {
			setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)),23));
		}catch(FileNotFoundException e) {
			setFont(Font.font("Verdana",23));
		}
	}
	
}
