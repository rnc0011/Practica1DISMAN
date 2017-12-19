package gestor;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import interfaz.Interfaz;
import interfaz.TextIO;
import modelo.ListaCompra;
import modelo.Producto;
import persistencia.Persistencia;
import persistencia.PersistenciaCSV;

/**
 * Clase Gestion. Se encarga de gestionar la logica interna de la aplicacion.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class Gestion {

	// Declaración de variables
	private static List<String> nombresProducto = new ArrayList<String>();
	private static ListaCompra listaProductos = new ListaCompra();
	private static Persistencia persistencia = new PersistenciaCSV();
	private static Interfaz interfaz;

	/**
	 * Método main. Programa principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		persistencia.importar(listaProductos);
		Iterator<Producto> it = listaProductos.iterator();

		while (it.hasNext()) {
			nombresProducto.add(it.next().getNombre());
		}
		
		System.out.println("Elije el tipo de interfaz que quieres utilizar:");
		System.out.println("1.- Interfaz modo texto.");
		System.out.println("2.- Interfaz modo grafico.");
		
		//To-Do Recojer el imput del teclado e instanciar la variable "interfaz" segun la eleccion del usuario

		interfaz.ejecutar();
	}

	/**
	 * Método anadirProducto. Añade prodcutos a la lista de la compra.
	 * 
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public static void anadirProducto(String nombre, int cantidad, float precio) {
		Producto miProducto = new Producto(nombre, cantidad, precio);
		listaProductos.anadir(miProducto);
		nombresProducto.add(nombre);
	}

	/**
	 * Método eliminarProducto. Elimina el producto elegido por el usuario.
	 * 
	 * @param nombre
	 */
	public static void eliminarProducto(String nombre) {
		Producto producto = null;
		Producto aux = null;
		Iterator<Producto> it = listaProductos.iterator();

		while (it.hasNext()) {
			aux = it.next();
			if (aux.getNombre().equals(nombre)) {
				producto = aux;
			}
		}

		listaProductos.eliminar(producto);
		nombresProducto.remove(nombre);
	}

	/**
	 * Método modificarCantidad. Modifica la cantidad de un producto elegido por
	 * el usuario.
	 * 
	 * @param nombreProducto
	 * @param cantidad
	 */
	public static void modificarCantidad(String nombreProducto, int cantidad) {
		Iterator<Producto> it = listaProductos.iterator();
		Producto producto = null;
		Producto aux = null;
		while (it.hasNext()) {
			aux = it.next();
			if (aux.getNombre().equals(nombreProducto)) {
				producto = aux;
			}
		}
		if (cantidad == 0) {
			listaProductos.eliminar(producto);
			nombresProducto.remove(nombreProducto);
		} else {
			producto.modificarCantidad(cantidad);
		}
	}

	/**
	 * Método marcarComprado. Elimina el producto elegido por el usuario.
	 * 
	 * @param nombre
	 */
	public static void marcarComprado(String nombre) {
		Producto producto = null;
		Producto aux = null;
		Iterator<Producto> it = listaProductos.iterator();
		while (it.hasNext()) {
			aux = it.next();
			if (aux.getNombre().equals(nombre)) {
				producto = aux;
			}
		}
		listaProductos.eliminar(producto);
		nombresProducto.remove(nombre);
	}

	/**
	 * Método devolverLista(). Devuelve la lista de la compra.
	 * 
	 * @return listaProductos
	 */
	public static ListaCompra devolverLista() {
		return listaProductos;
	}
	
	/**
	 * Método devolverNombres(). Devuelve la lista con los nombres de los productos.
	 * 
	 * @return nombresProducto
	 */
	public static List<String> devolverNombres() {
		return nombresProducto;
	}

	/**
	 * Método guardarLista. Guarda la lista de la compra en un archivo csv.
	 */
	public static void guardarLista() {
		persistencia.exportar(listaProductos);
	}

}