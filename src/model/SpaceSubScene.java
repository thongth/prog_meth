package model;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.animation.TranslateTransition;
public class SpaceSubScene extends SubScene{
	private final static String FONT =   ClassLoader.getSystemResource("fonts/joystix_monospace.tff").toString();
	private final static String BG_IMG =  ClassLoader.getSystemResource("images/yellow_panel.png").toString();
	public SpaceSubScene() {
		super(new AnchorPane(),600,400); //type,width,height
		prefWidth(600);
		prefHeight(400);
		BackgroundImage img = new BackgroundImage( new Image(BG_IMG,600,400,false,true),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,null    );
		AnchorPane SubPane = (AnchorPane) this.getRoot();
		SubPane.setBackground(new Background(img));
		setLayoutX(1024);
		setLayoutY(180);
		
	}
	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.5));
		transition.setNode(this); //which element should be moved
		transition.setToX(-676);
	}
}
