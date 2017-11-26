package gestor;

import java.util.ArrayList;
import java.util.Iterator;
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
		TextIO text = new TextIO();
		text.ejecutar();
		Iterator<Producto> it = listaProductos.iterator();
		while(it.hasNext()) {
			nombresProducto.add(it.next().getNombre());
		}
	}
	
	/**
	 * Método anadirProducto. Aáde prodcutos a la lista de la compra.
	 * 
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	protected static void anadirProducto(String nombre, int cantidad, float precio) {
		if(!nombresProducto.contains(nombre)) {
			Producto miProducto = new Producto(nombre, cantidad, precio);	
			listaProductos.anadir(miProducto);
			System.out.println("El producto " + miProducto.getNombre() + " se ha añadido a su lista de la compra.");
		}else {
			System.out.println("El producto " + nombre + " ya está en su lista de la compra.");
		}
	}
	
	/**
	 * Método eliminarProducto. Elimina el producto elegido por el usuario.
	 * 
	 * @param nombre
	 */
	protected static void eliminarProducto(String nombre) {
		if(nombresProducto.contains(nombre)) {
			Producto producto = null;
			Iterator<Producto> it = listaProductos.iterator();
			while(it.hasNext()) {
				producto = it.next();
				if(producto.getNombre().equals(nombre)) {
					listaProductos.eliminar(producto);
				}
			}
			System.out.println("El producto " + nombre + " se ha eliminado de su lista de la compra.");
		} else {
			System.out.println("El producto " + nombre + " no existe.");
		}
	}
	
	/**
	 * Método modificarCantidad. Modifica la cantidad de un producto elegido por el usuario.
	 * 
	 * @param nombreProducto
	 * @param cantidad
	 */
	protected static void modificarCantidad(String nombreProducto, int cantidad) {
		if(nombresProducto.contains(nombreProducto)) {
			Iterator<Producto> it = listaProductos.iterator();
			Producto producto = null;
			while(it.hasNext()) {
				producto = it.next();
				if(producto.getNombre().equals(nombreProducto)) {
					producto.modificarCantidad(cantidad);
				}
			}
			System.out.println("La cantidad del producto " + nombreProducto + "se ha modificado correctamente.");
		} else {
			System.out.println("El producto " + nombreProducto + " no está en su lista de la compra.");
		}
	}
	
	/**
	 * Método marcarComprado. Marca como comprado el producto elegido por el usuario.
	 * 
	 * @param nombre
	 */
	protected static void marcarComprado(String nombre) {
		if(nombresProducto.contains(nombre)) {
			Producto producto = null;
			Iterator<Producto> it = listaProductos.iterator();
			while(it.hasNext()) {
				producto = it.next();
				if(producto.getNombre().equals(nombre)) {
					producto.productoComprado();
				}
			}
			System.out.println("El producto " + nombre + " está ahora marcado como comprado.");
		} else {
			System.out.println("El producto " + nombre + " no está en su lista de la compra.");
		}
	}

}
