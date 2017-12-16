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
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class GraphicIO extends Application {
	private Stage primaryStage = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Tutorial JavaFX");
		this.primaryStage.show();

		this.primaryStage.setScene(setupMainScene());
	}

	public Scene setupMainScene() {

		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

		Label fieldLabel = new Label("Texto para el botón");
		fieldLabel.setPrefWidth(150.0);
		TextField fieldInput = new TextField("Lorem ipsum");
		fieldInput.setPrefWidth(150.0);
		textForm.setAlignment(Pos.CENTER_LEFT);

		textForm.getChildren().addAll(fieldLabel, fieldInput);

		root.getChildren().addAll(textForm);

		Scene scene = new Scene(root, 640, 360);
		return scene;
	}
}
