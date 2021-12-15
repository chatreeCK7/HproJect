package component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class EndingText extends Label{
	
	private final String FONT_PATH = "src/component/res/PressStart2P-vaV7.ttf";

	public EndingText(String text,Paint color) {
		// TODO Auto-generated constructor stub
		setPrefSize(900, 75);
		setPadding(new Insets(40));
		setText(text);
		setWrapText(true);
		setLabelfont(color);
	}
	
	private void setLabelfont(Paint color) {
		// TODO Auto-generated method stub
		try {
			setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)),42));
			setTextFill(color);
		}catch(FileNotFoundException e) {
			setFont(Font.font("Verdana",42));
		}
	}
}
