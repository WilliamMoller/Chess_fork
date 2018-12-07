package board;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class chess extends Application{

	public static Group root = new Group();
	public static int WIDTH = 800;
	public static int HEIGHT = 800;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ChessBoard board = new ChessBoard();
		root.getChildren().add(board);
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
