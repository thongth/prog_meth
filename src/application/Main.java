package application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.ViewManager;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		ViewManager manager = new ViewManager();
		primaryStage = manager.getMainStage();
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
