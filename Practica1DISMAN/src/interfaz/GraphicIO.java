/**
 * 
 */
package interfaz;

/**
 * @author Mario
 *
 */
import javafx.application.Application;
import javafx.stage.Stage;

public class GraphicIO extends Application {
	private Stage primaryStage = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
