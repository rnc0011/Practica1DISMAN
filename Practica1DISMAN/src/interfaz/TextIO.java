/**
 * 
 */
package interfaz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import gestor.Gestion;
import modelo.ListaCompra;
import modelo.Producto;

/**
 * Clase TextIO. Se encarga de imprimir el menú.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class TextIO implements Interfaz {

	// Declaración de variables
	private static ListaCompra lista = new ListaCompra();
	private static List<String> nombres = new ArrayList<String>();

	/**
	 * Método ejecutar. Pinta el menú y pide por teclado una opción.
	 */
	public void ejecutar() {
		pintarMenu();
		cogerLista();
		cogerNombres();
		Scanner entrada = new Scanner(System.in);
		String opcion = entrada.nextLine();
		menu(opcion);
		entrada.close();
	}

	/**
	 * Método pintarMenu. Muestra las opciones iniciales al usuario.
	 */
	private void pintarMenu() {
		System.out.println("*******Lista de la compra*******");
		System.out.println("¿Qué quiere hacer? (Introduzca el número de la opción)");
		System.out.println("1.- Añadir productos a la lista");
		System.out.println("2.- Eliminar productos de la lista");
		System.out.println("3.- Cambiar la cantidad de un producto de la lista");
		System.out.println("4.- Marcar productos de la lista como comprados");
		System.out.println("5.- Ver lista de la compra");
		System.out.println("0.- Guardar la lista y salir");
	}

	/**
	 * Método menu. Muestra y realiza las subacciones del menú.
	 * 
	 * @param opcion
	 */
	private void menu(String opcion) {
		String nombre = "";
		int cantidad = 0;
		float precio = 0;
		Scanner entrada = new Scanner(System.in);

		switch (opcion) {
		case "1":
			anadirProductos(nombre, cantidad, precio, entrada);
			break;
		case "2":
			eliminarProductos(nombre, entrada);
			break;
		case "3":
			modificarCantidad(nombre, cantidad, entrada);
			break;
		case "4":
			marcarComprado(nombre, entrada);
			break;
		case "5":
			verLista();
			break;
		case "0":
			guardarSalir();
			break;
		}

		entrada.close();
	}

	/**
	 * Método cogerLista. Guarda la lista de la compra para poder imprimirla
	 * después.
	 */
	private void cogerLista() {
		lista = Gestion.devolverLista();
	}

	/**
	 * Método cogerNombres. Guarda la lista de los nombres.
	 */
	private void cogerNombres() {
		nombres = Gestion.devolverNombres();
	}

	/**
	 * Método pintarLista. Imprime los productos de la lista de la compra.
	 */
	private void pintarLista() {
		if (lista.size() != 0) {
			Iterator<Producto> it = lista.iterator();
			Producto producto = null;
			while (it.hasNext()) {
				producto = it.next();
				System.out.println("Nombre: " + producto.getNombre() + "  Cantidad: " + producto.getCantidad()
						+ "  Precio: " + producto.getPrecio());
			}
		} else {
			System.out.println("No hay productos en la lista de la compra.");
		}
	}

	/**
	 * Método anadirProductos. Añade productos a la lista de la compra.
	 * 
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 * @param entrada
	 */
	private void anadirProductos(String nombre, int cantidad, float precio, Scanner entrada) {
		try {

			System.out.println("Introduzca el nombre del producto");
			nombre = entrada.nextLine();
			if (!nombres.contains(nombre)) {
				System.out.println("Introduzca la cantidad del producto");
				cantidad = entrada.nextInt();
				System.out.println("Introduzca el precio del producto");
				precio = entrada.nextFloat();
				Gestion.anadirProducto(nombre, cantidad, precio);
				System.out.println("El producto " + nombre + " se ha añadido a su lista de la compra.");
			} else {
				System.out.println("El producto " + nombre + " ya está en su lista de la compra.");
			}
			System.out.println("");
			ejecutar();

		} catch (InputMismatchException e) {
			System.err.println("Error en el ultimo dato intruducido.");
			ejecutar();
		}
	}

	/**
	 * Método eliminarProductos. Elimina productos de la lista de la compra.
	 * 
	 * @param nombre
	 * @param entrada
	 */
	private void eliminarProductos(String nombre, Scanner entrada) {
		System.out.println("Introduzca el nombre del producto a eliminar");
		pintarLista();
		nombre = entrada.nextLine();
		if (nombres.contains(nombre)) {
			Gestion.eliminarProducto(nombre);
			System.out.println("El producto " + nombre + " se ha eliminado de su lista de la compra.");
		} else {
			System.out.println("El producto " + nombre + " no existe.");
		}
		System.out.println("");
		ejecutar();
	}

	/**
	 * Método modificarCantidad. Modifica la cantidad de productos.
	 * 
	 * @param nombre
	 * @param cantidad
	 * @param entrada
	 */
	private void modificarCantidad(String nombre, int cantidad, Scanner entrada) {
		System.out.println("Introduzca el nombre del producto del que quiere modificar la cantidad");
		pintarLista();
		nombre = entrada.nextLine();
		if (nombres.contains(nombre)) {
			System.out.println("Introduzca la nueva cantidad");
			cantidad = entrada.nextInt();
			Gestion.modificarCantidad(nombre, cantidad);
			System.out.println("La cantidad del producto " + nombre + " se ha modificado correctamente.");
		} else {
			System.out.println("El producto " + nombre + " no está en su lista de la compra.");
		}
		System.out.println("");
		ejecutar();
	}

	/**
	 * Método marcarComprado. Marca un productos como comprados.
	 * 
	 * @param nombre
	 * @param entrada
	 */
	private void marcarComprado(String nombre, Scanner entrada) {
		System.out.println("Introduzca el nombre del producto que quiere marcar como comprado");
		pintarLista();
		nombre = entrada.nextLine();
		if (nombres.contains(nombre)) {
			Gestion.marcarComprado(nombre);
			System.out.println("El producto " + nombre + " está ahora marcado como comprado.");
		} else {
			System.out.println("El producto " + nombre + " no está en su lista de la compra.");
		}
		System.out.println("");
		ejecutar();
	}

	/**
	 * Método verLista. Imprime la lista de la compra.
	 */
	private void verLista() {
		pintarLista();
		System.out.println("");
		ejecutar();
	}

	/**
	 * Método guardarSalir. Se encargar de guardar la lista de la compra y salir de
	 * la aplicación.
	 */
	public static void guardarSalir() {
		Gestion.guardarLista();
		System.out.println("La lista se ha guardado");
		System.out.println("Saliendo...");
	}

}