/**
 * 
 */
package interfaz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gestor.Gestion;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.ListaFavoritos;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;

/**
 * Clase GraphicIO. Implementa la GUI de la aplicación.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class GraphicIO extends Application implements Interfaz {

	// Declaración de variables
	private Stage primaryStage = null;
	private static List<String> nombres = new ArrayList<String>();
	private static ListaFavoritos favoritos = new ListaFavoritos();

	/**
	 * Método ejecutar. Se encarga de inicializar las listas y ejecutar la GUI.
	 */
	public void ejecutar() {
		cogerNombres();
		cogerFavoritos();
		launch();
	}

	/**
	 * Método cogerNombres. Guarda la lista de los nombres.
	 */
	private void cogerNombres() {
		nombres = Gestion.devolverNombres();
	}
	
	/**
	 * Método cogerFavoritos. Guarda la lista de favoritos.
	 */
	private void cogerFavoritos() {
		favoritos = Gestion.devolverFavoritos();
	}

	/**
	 * Método start. Inicializa el stage.
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Lista de la compra");
		this.primaryStage.show();
		this.primaryStage.setScene(setupMainScene());
	}

	/**
	 * Método setupMainScene. Muestra el menú principal de la GUI.
	 * 
	 * @return scene
	 */
	private Scene setupMainScene() {

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
		RadioButton boton1 = new RadioButton("Añadir");
		boton1.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton1.setToggleGroup(group);
		boton1.setOnAction(e -> this.primaryStage.setScene(anadirScene()));

		RadioButton boton2 = new RadioButton("Eliminar");
		boton2.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton2.setToggleGroup(group);
		boton2.setOnAction(e -> this.primaryStage.setScene(eliminarScene()));

		RadioButton boton3 = new RadioButton("Modificar");
		boton3.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton3.setToggleGroup(group);
		boton3.setOnAction(e -> this.primaryStage.setScene(modificarScene()));

		RadioButton boton4 = new RadioButton("Comprar");
		boton4.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton4.setToggleGroup(group);
		boton4.setOnAction(e -> this.primaryStage.setScene(comprarScene()));
		
		RadioButton boton5 = new RadioButton("Añadir favorito");
		boton5.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton5.setToggleGroup(group);
		boton5.setOnAction(e -> this.primaryStage.setScene(marcarFavoritoScene()));

		RadioButton boton6 = new RadioButton("Salir");
		boton6.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		boton6.setToggleGroup(group);
		boton6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Gestion.guardarLista();
				primaryStage.close();
			}
		});

		HBox hbox = new HBox(boton1, boton2, boton3, boton4, boton5, boton6);

		root.getChildren().addAll(textForm);
		root.getChildren().addAll(hbox);

		Scene scene = new Scene(root, 820, 360);
		return scene;
	}

	/**
	 * Método anadirScene. Muestra el menú para añadir productos a la lista.
	 * 
	 * @return scene
	 */
	private Scene anadirScene() {
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		
		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		textForm.setAlignment(Pos.CENTER_LEFT);
		
		Label fieldLabel = new Label("Favoritos:");
		fieldLabel.setPrefWidth(150.0);
		textForm.getChildren().addAll(fieldLabel);
		
		if (favoritos.size() != 0) {
			Iterator<String> it = favoritos.iterator();
			while (it.hasNext()) {
				String nombre = it.next();
				RadioButton boton = new RadioButton(nombre);
				boton.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
				textForm.getChildren().add(boton);
				boton.setOnAction(e -> this.primaryStage.setScene(anadirProductoFavScene(boton.getText())));
			}
		} else {
			Label noFavoritos = new Label("No hay favoritos.");
			noFavoritos.setPrefWidth(150.0);
			textForm.getChildren().addAll(noFavoritos);
		}
			
		Label nombre = new Label("Nombre:");
		nombre.setPrefWidth(150.0);
		TextField campoNombre = new TextField("Nombre");
		campoNombre.setPrefWidth(150.0);
		
		Label cantidad = new Label("Cantidad:");
		cantidad.setPrefWidth(150.0);
		TextField campoCantidad = new TextField("Cantidad");
		campoCantidad.setPrefWidth(150.0);
		
		Label precio = new Label("Precio:");
		precio.setPrefWidth(150.0);
		TextField campoPrecio = new TextField("Precio");
		campoPrecio.setPrefWidth(150.0);
		
		Button aceptar = new Button("Aceptar");
		aceptar.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		aceptar.setAlignment(Pos.BOTTOM_LEFT);
		aceptar.setOnAction(e -> {
			Gestion.anadirProducto(campoNombre.getText(), Integer.parseInt(campoCantidad.getText()), Float.parseFloat(campoPrecio.getText()));
			this.primaryStage.setScene(setupMainScene());
		});
		root.getChildren().add(aceptar);

		textForm.getChildren().addAll(nombre, campoNombre);
		textForm.getChildren().addAll(cantidad, campoCantidad);
		textForm.getChildren().addAll(precio, campoPrecio);

		Button volver = new Button("Volver");
		volver.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		volver.setAlignment(Pos.BOTTOM_RIGHT);
		volver.setOnAction(e -> this.primaryStage.setScene(setupMainScene()));

		root.getChildren().addAll(textForm);
		root.getChildren().add(volver);

		Scene scene = new Scene(root, 820, 360);
		return scene;
	}
	
	/**
	 * Método anadirProductoScene. Muestra el menú para añadir productos desde los favoritos.
	 * 
	 * @param nombre
	 * @return scene
	 */
	private Scene anadirProductoFavScene(String nombre) {
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		
		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		textForm.setAlignment(Pos.CENTER_LEFT);
		
		if(!nombres.contains(nombre)) {
			Label cantidad = new Label("Cantidad:");
			cantidad.setPrefWidth(150.0);
			TextField campoCantidad = new TextField("Cantidad");
			campoCantidad.setPrefWidth(150.0);
			
			Label precio = new Label("Precio:");
			precio.setPrefWidth(150.0);
			TextField campoPrecio = new TextField("Precio");
			campoPrecio.setPrefWidth(150.0);
	
			textForm.getChildren().addAll(cantidad, campoCantidad);
			textForm.getChildren().addAll(precio, campoPrecio);
			root.getChildren().addAll(textForm);
			
			Button aceptar = new Button("Aceptar");
			aceptar.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
			aceptar.setAlignment(Pos.BOTTOM_LEFT);
			aceptar.setOnAction(e -> {
				Gestion.anadirProducto(nombre, Integer.parseInt(campoCantidad.getText()), Float.parseFloat(campoPrecio.getText()));
				this.primaryStage.setScene(setupMainScene());
			});
			root.getChildren().add(aceptar);
		} else {
			Label productoExistente = new Label("Producto existente");
			productoExistente.setPrefWidth(150.0);
			textForm.getChildren().addAll(productoExistente);
		}
		
		Button volver = new Button("Volver");
		volver.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		volver.setAlignment(Pos.BOTTOM_RIGHT);
		volver.setOnAction(e -> this.primaryStage.setScene(setupMainScene()));

		root.getChildren().add(volver);

		Scene scene = new Scene(root, 820, 360);
		return scene;
	}

	/**
	 * Método eliminarScene. Muestra el menú de eliminar productos de la lista.
	 * 
	 * @return scene
	 */
	private Scene eliminarScene() {
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

		if (nombres.size() != 0) {
			Iterator<String> it = nombres.iterator();
			while (it.hasNext()) {
				String nombre = it.next();
				RadioButton boton = new RadioButton(nombre);
				boton.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
				textForm.getChildren().add(boton);
				boton.setOnAction(e -> {
					Gestion.eliminarProducto(nombre);
					this.primaryStage.setScene(setupMainScene());
				});
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
		Scene scene = new Scene(root, 820, 360);
		return scene;
	}

	/**
	 * Método modificarScene. Muestra el menú de modificar la cantidad de un
	 * producto.
	 * 
	 * @return scene
	 */
	private Scene modificarScene() {
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		textForm.setAlignment(Pos.CENTER_LEFT);

		Label fieldLabel = new Label("Modificar:");
		fieldLabel.setPrefWidth(150.0);
		textForm.getChildren().addAll(fieldLabel);

		if (nombres.size() != 0) {
			Iterator<String> it = nombres.iterator();
			while (it.hasNext()) {
				String nombre = it.next();
				RadioButton boton = new RadioButton(nombre);
				boton.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
				textForm.getChildren().add(boton);
				boton.setOnAction(e -> this.primaryStage.setScene(modificarCantidadScene(nombre)));
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
		Scene scene = new Scene(root, 820, 360);
		return scene;
	}

	/**
	 * Método modificarCantidadScene. Muestra el menú para introducir la nueva cantidad del producto.
	 * 
	 * @param nombre
	 * @return scene
	 */
	private Scene modificarCantidadScene(String nombre) {
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		textForm.setAlignment(Pos.CENTER_LEFT);

		Label fieldLabel = new Label("Nueva cantidad:");
		fieldLabel.setPrefWidth(150.0);
		TextField fieldInput = new TextField("Cantidad");
		fieldInput.setPrefWidth(150.0);
		fieldInput.setOnAction(e -> {
			Gestion.modificarCantidad(nombre, Integer.parseInt(fieldInput.getText()));
			this.primaryStage.setScene(setupMainScene());
		});

		textForm.getChildren().addAll(fieldLabel, fieldInput);

		Button volver = new Button("Volver");
		volver.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		volver.setAlignment(Pos.BOTTOM_RIGHT);
		volver.setOnAction(e -> this.primaryStage.setScene(setupMainScene()));

		root.getChildren().addAll(textForm);
		root.getChildren().add(volver);

		Scene scene = new Scene(root, 820, 360);
		return scene;
	}

	/**
	 * Método comprarScene. Muestra el menú de marcar productos como comprados.
	 * 
	 * @return scene
	 */
	private Scene comprarScene() {
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

		if (nombres.size() != 0) {
			Iterator<String> it = nombres.iterator();
			while (it.hasNext()) {
				String nombre = it.next();
				RadioButton boton = new RadioButton(nombre);
				boton.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
				textForm.getChildren().add(boton);
				boton.setOnAction(e -> {
					Gestion.marcarComprado(nombre);
					this.primaryStage.setScene(setupMainScene());
				});
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
		Scene scene = new Scene(root, 820, 360);
		return scene;
	}
	
	/**
	 * Método marcarFavorito. Muestra el menú para poder marcar un producto como favorito.
	 * 
	 * @return scene
	 */
	private Scene marcarFavoritoScene() {
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

		HBox textForm = new HBox();
		textForm.setSpacing(10.0);
		textForm.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
		textForm.setAlignment(Pos.CENTER_LEFT);
		
		Label fieldLabel = new Label("Marcar:");
		fieldLabel.setPrefWidth(150.0);
		textForm.getChildren().addAll(fieldLabel);

		if (nombres.size() != 0) {
			Iterator<String> it = nombres.iterator();
			while (it.hasNext()) {
				String nombre = it.next();
				RadioButton boton = new RadioButton(nombre);
				boton.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
				textForm.getChildren().add(boton);
				boton.setOnAction(e -> {
					Gestion.marcarFavorito(nombre);
					this.primaryStage.setScene(setupMainScene());
				});
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
		Scene scene = new Scene(root, 820, 360);
		return scene;
	}

}
