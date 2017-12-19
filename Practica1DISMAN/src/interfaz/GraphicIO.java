/**
 * 
 */
package interfaz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gestor.Gestion;
/**
 * @author Mario
 *
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import modelo.ListaCompra;
import modelo.Producto;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class GraphicIO extends Application implements Interfaz{
	
	private Stage primaryStage = null;
	private static ListaCompra lista = new ListaCompra();
	private static List<String> nombres = new ArrayList<String>();

	public void ejecutar() {
		cogerLista();
		cogerNombres();
		launch();
	}
	
	/**
	 * Método cogerLista. Guarda la lista de la compra para poder imprimirla
	 * después.
	 */
	private static void cogerLista() {
		lista = Gestion.devolverLista();
	}

	/**
	 * Método cogerNombres. Guarda la lista de los nombres.
	 */
	private static void cogerNombres() {
		nombres = Gestion.devolverNombres();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Lista de la compra");
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
		textForm.setAlignment(Pos.CENTER_LEFT);
		
		Label fieldLabel = new Label("Seleccione una opción:");
		fieldLabel.setPrefWidth(150.0);
		
		textForm.getChildren().addAll(fieldLabel);

		ToggleGroup group = new ToggleGroup();
		RadioButton boton1 = new RadioButton("Añadir producto");
		boton1.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton1.setToggleGroup(group);
		
		RadioButton boton2 = new RadioButton("Eliminar producto");
		boton2.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton2.setToggleGroup(group);
		boton2.setOnAction(e -> this.primaryStage.setScene(eliminarScene()));
		
		RadioButton boton3 = new RadioButton("Modificar producto");
		boton3.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton3.setToggleGroup(group);
		
		RadioButton boton4 = new RadioButton("Comprar producto");
		boton4.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton4.setToggleGroup(group);
		boton4.setOnAction(e -> this.primaryStage.setScene(comprarScene()));
		
		RadioButton boton5 = new RadioButton("Salir");
		boton5.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton5.setToggleGroup(group);
		boton5.setOnAction(e -> this.primaryStage.setScene(exitScene()));
		
		HBox hbox = new HBox(boton1, boton2, boton3, boton4, boton5);

		root.getChildren().addAll(textForm);
		root.getChildren().addAll(hbox);
		
		Scene scene = new Scene(root, 640, 360);
		return scene;
	}
	
	public Scene eliminarScene() {
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		
		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		textForm.setAlignment(Pos.CENTER_LEFT);
		
		Label fieldLabel = new Label("Eliminar:");
		fieldLabel.setPrefWidth(150.0);
		textForm.getChildren().addAll(fieldLabel);
		
		if(nombres.size() != 0) {
			Iterator<String> it = nombres.iterator();
			while(it.hasNext()) {
				RadioButton boton = new RadioButton(it.next());
				boton.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
				textForm.getChildren().add(boton);
				// si pinchas sobre el producto, tiene que eliminarse
			}
		} else {
			Label noProductos = new Label("No hay productos.");
			noProductos.setPrefWidth(150.0);
			textForm.getChildren().addAll(noProductos);
		}
		
		Button volver = new Button("Volver");
		volver.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		volver.setAlignment(Pos.BOTTOM_RIGHT);
		volver.setOnAction(e -> this.primaryStage.setScene(setupMainScene()));
		
		root.getChildren().addAll(textForm);
		root.getChildren().add(volver);
		Scene scene = new Scene(root, 640, 360);
		return scene;
	}
	
	public Scene comprarScene() {
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		
		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		textForm.setAlignment(Pos.CENTER_LEFT);
		
		Label fieldLabel = new Label("Comprar:");
		fieldLabel.setPrefWidth(150.0);
		textForm.getChildren().addAll(fieldLabel);
		
		if(nombres.size() != 0) {
			Iterator<String> it = nombres.iterator();
			while(it.hasNext()) {
				RadioButton boton = new RadioButton(it.next());
				boton.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
				textForm.getChildren().add(boton);
				// si pinchas sobre el producto, tiene que eliminarse
			}
		} else {
			Label noProductos = new Label("No hay productos.");
			noProductos.setPrefWidth(150.0);
			textForm.getChildren().addAll(noProductos);
		}
		
		Button volver = new Button("Volver");
		volver.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		volver.setAlignment(Pos.BOTTOM_RIGHT);
		volver.setOnAction(e -> this.primaryStage.setScene(setupMainScene()));
		
		root.getChildren().addAll(textForm);
		root.getChildren().add(volver);
		Scene scene = new Scene(root, 640, 360);
		return scene;
	}
	
	public Scene exitScene() {
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		
		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		textForm.setAlignment(Pos.CENTER_LEFT);
		
		Label fieldLabel = new Label("Saliendo...");
		fieldLabel.setPrefWidth(150.0);
		
		textForm.getChildren().addAll(fieldLabel);
		root.getChildren().addAll(textForm);
		
		Scene scene = new Scene(root, 640, 360);
		return scene;
	}
	
}
