package gestor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.ListaCompra;
import modelo.Producto;
import persistencia.Persistencia;

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
		Persistencia.importar(listaProductos);
		Iterator<Producto> it = listaProductos.iterator();
		while(it.hasNext()) {
			nombresProducto.add(it.next().getNombre());
		}
		TextIO text = new TextIO();
		text.ejecutar();
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
			nombresProducto.add(nombre);
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
			Producto aux = null;
			Iterator<Producto> it = listaProductos.iterator();
			while(it.hasNext()) {
				aux = it.next();
				if(aux.getNombre().equals(nombre)) {
					producto = aux;
				}
			}
			listaProductos.eliminar(producto);
			nombresProducto.remove(nombre);
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
			Producto aux = null;
			while(it.hasNext()) {
				aux = it.next();
				if(aux.getNombre().equals(nombreProducto)) {
					producto = aux;
				}
			}
			if(cantidad == 0) {
				listaProductos.eliminar(producto);
				nombresProducto.remove(nombreProducto);
			} else {
				producto.modificarCantidad(cantidad);
			}
			System.out.println("La cantidad del producto " + nombreProducto + " se ha modificado correctamente.");
		} else {
			System.out.println("El producto " + nombreProducto + " no está en su lista de la compra.");
		}
	}
	
	/**
	 * Método marcarComprado. Elimina el producto elegido por el usuario.
	 * 
	 * @param nombre
	 */
	protected static void marcarComprado(String nombre) {
		if(nombresProducto.contains(nombre)) {
			Producto producto = null;
			Producto aux = null;
			Iterator<Producto> it = listaProductos.iterator();
			while(it.hasNext()) {
				aux = it.next();
				if(aux.getNombre().equals(nombre)) {
					producto = aux;
				}
			}
			listaProductos.eliminar(producto);
			nombresProducto.remove(nombre);
			System.out.println("El producto " + nombre + " está ahora marcado como comprado.");
		} else {
			System.out.println("El producto " + nombre + " no está en su lista de la compra.");
		}
	}
	
	/**
	 * Método pintarLista(). Imprime los productos de la lista de la compra.
	 */
	protected static void pintarLista() {
		if(listaProductos.size() == 0) {
			System.out.println("La lista de la compra está vacía");
		} else {
			listaProductos.pintarLista();
		}
	}
	
	/**
	 * Método guardarLista. Guarda la lista de la compra en un archivo csv.
	 */
	protected static void guardarLista() {
		Persistencia.exportar(listaProductos);
	}

}