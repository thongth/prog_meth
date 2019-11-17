package view;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.Event;
import model.SpaceButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.DropShadow;
import model.SpaceSubScene;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
public class ViewManager {
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 750;
	private static final String BG_PATH = ClassLoader.getSystemResource("images/bg.png").toString();
	private final static int BTN_X = 100;
	private final static int BTN_Y = 150;
	
	
	
	
	private SpaceSubScene credit;
	private SpaceSubScene score;
	private SpaceSubScene exit;
	private SpaceSubScene play;

	private SpaceSubScene hideScene;
		
	List<SpaceButton> menuBtn;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	public ViewManager() {
		menuBtn = new ArrayList<SpaceButton>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createSubScenes();
		createBackground();
		createButtons();
		createLogo();
		/*SpaceSubScene sc = new SpaceSubScene();
		sc.setLayoutX(200);
		sc.setLayoutY(100);
		mainPane.getChildren().add(sc);*/
		
	}
	
	private void showSubScene(SpaceSubScene ss) {
		if(hideScene!=null) {
			hideScene.moveSubScene();
		}
		ss.moveSubScene();
		hideScene = ss;
	}
	
	private void createSubScenes() {
		credit = new SpaceSubScene();	
		score =  new SpaceSubScene();
		exit =  new SpaceSubScene();
		play =  new SpaceSubScene();
		mainPane.getChildren().addAll(credit,exit,score,play);
		
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	private void addBtn(SpaceButton btn) {
		btn.setLayoutX(BTN_X);
		btn.setLayoutY(BTN_Y + menuBtn.size()*100);
		menuBtn.add(btn);
		mainPane.getChildren().add(btn);
	}
	private void createButtons() {
		createStartBtn();
		createScoreBtn();
		createCreditBtn();
		createExitBtn();
	}
	private void createStartBtn() {
		SpaceButton startBtn = new SpaceButton("PLAY");
		addBtn(startBtn);
		startBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(play);
			}
		});
	}
	private void createScoreBtn() {
		SpaceButton scrBtn = new SpaceButton("SCORES");
		addBtn(scrBtn);
		scrBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(score);
			}
		});
	}
	private void createCreditBtn() {
		SpaceButton creditBtn = new SpaceButton("ABOUT US");
		addBtn(creditBtn);
		creditBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(credit);
			}
		});
	}
	private void createExitBtn() {
		SpaceButton exit = new SpaceButton("EXIT");
		addBtn(exit);
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainStage.close();
			}
		});
	}
	
	private void createBackground() {
		Image bgImage =new Image(BG_PATH,256,256,false,true); //Image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
		BackgroundImage background = new BackgroundImage(bgImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
	}
	private void createLogo() {
		ImageView logo = new ImageView(ClassLoader.getSystemResource("imgaes/LOGO.jpg").toString());
		logo.setLayoutX(400);
		logo.setLayoutY(50);
		logo.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());
			}
			
		});
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
			}
		});
		mainPane.getChildren().add(logo);
	}
}
