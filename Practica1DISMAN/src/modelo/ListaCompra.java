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
	
	/**
	 * Método getProducto, devuelve un producto igual al introducido por parametro.
	 * 
	 * @param producto
	 */
	
	public Producto getProducto(Producto producto) {
		return this.miLista.get(this.miLista.indexOf(producto));
	}

	/**
	 * Método getProducto, devuelve el producto con el indice introducido.
	 * 
	 * @param producto
	 */
	
	public Producto getProducto(int index) {
		return this.miLista.get(index);
	}

	@Override
	public Iterator<Producto> iterator() {
		return this.miLista.iterator();
	}
}
