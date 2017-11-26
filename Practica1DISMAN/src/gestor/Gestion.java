package gestor;

import java.util.ArrayList;
import java.util.List;

import modelo.ListaCompra;
import modelo.Producto;

public class Gestion {
	
	//Declaración de variables
	private static List<String> nombresProducto = new ArrayList<String>();
	private static ListaCompra listaProductos = new ListaCompra();

	/**
	 * Método main. Programa principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	/**
	 * Método anadirProducto. Aáde prodcutos a la lista de la compra.
	 * 
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	protected static void anadirProducto(String nombre, int cantidad, float precio) {
		Producto miProducto = new Producto(nombre, cantidad, precio);	
		if(!nombresProducto.contains(miProducto)) {
			listaProductos.anadir(miProducto);
		}else {
			System.out.println("El producto " + miProducto.getNombre() + " ya está en tu lista de la compra.");
		}
	}
	
	/**
	 * Método eliminarProducto. Elimina el producto elegido por el usuario.
	 * 
	 * @param nombre
	 */
	protected static void eliminarProducto(String nombre) {
		
	}
	
	/**
	 * Método modificarCantidad. Modifica la cantidad de un producto elegido por el usuario.
	 * 
	 * @param nombreProducto
	 * @param cantidad
	 */
	protected static void modificarCantidad(String nombreProducto, int cantidad) {
		
	}
	
	/**
	 * Método marcarComprado. Marca como comprado el producto elegido por el usuario.
	 * 
	 * @param nombre
	 */
	protected static void marcarComprado(String nombre) {
		
	}

}
