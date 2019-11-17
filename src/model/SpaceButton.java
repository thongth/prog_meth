package model;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.effect.DropShadow;

public class SpaceButton extends Button{
	private final String FONT = ClassLoader.getSystemResource("fonts/joystix_monospace.tff").toString();
	private final String PATH_BTN = ClassLoader.getSystemResource("images/").toString();
	private final String BTN_PRESSED =  "-fx-background-color: transparent; -fx-background-image: url("+PATH_BTN+"pressed_btn.png);";
	private final String BTN_NORMAL =  "-fx-background-color: transparent; -fx-background-image: url("+PATH_BTN+"normal_btn.png);";
	public SpaceButton(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BTN_NORMAL);
		initializeButtonListeners();
	}
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT), 23));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23));
		}
	}
	private void setButtonPressedStyle() { // examine
		setStyle(BTN_PRESSED);
		setPrefHeight(45); //What???
		setLayoutY(getLayoutY()+4);
	}
	private void setButtonReleasedStyle() {
		setStyle(BTN_NORMAL);
		setPrefHeight(49);
		setLayoutY(getLayoutY()-4);
	}
	private void initializeButtonListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
					
				}
			}
			
		});
		
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
					
				}
			}
			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());
			}
		});
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
			}
		});
	}
}
