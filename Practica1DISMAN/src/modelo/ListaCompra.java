package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase ListaCompra. Creamos la estructura de la lista de la compra.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class ListaCompra implements Iterable<Producto> {
	
	//Declaración de variables
	private List<Producto> miLista;
	
	/**
	 * Constructor de la clase.
	 */
	public ListaCompra() {
		this.miLista = new ArrayList<Producto>();
	}
	
	/**
	 * Método añadir. Añade productos a la lista de la compra.
	 * 
	 * @param producto
	 */
	public void anadir(Producto producto) {
		this.miLista.add(producto);
	}
	
	/**
	 * Método eliminar. Elimina productos de la lista de la compra.
	 * 
	 * @param producto
	 */
	public void eliminar(Producto producto) {
		if(miLista.size() != 0) {
			this.miLista.remove(producto);
		}
	}

	@Override
	public Iterator<Producto> iterator() {
		return this.miLista.iterator();
	}
	
	/**
	 * Método size. Devuelve el tamaño de la lista de la compra.
	 * 
	 * @return tamaño de la lista
	 */
	public int size() {
		return this.miLista.size();
	}
	
	/**
	 * Método pintarLista. Imprime los productos de la lista de la compra.
	 */
	public void pintarLista() {
		Iterator<Producto> it = this.miLista.iterator();
		Producto producto = null;
		while(it.hasNext()) {
			producto = it.next();
			System.out.println("Nombre: " + producto.getNombre() + "  Cantidad: " + producto.getCantidad() + "  Precio: " + producto.getPrecio());
		}
	}
	
}