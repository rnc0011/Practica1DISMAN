package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase ListaCompra. Creamos la estructura de la lista de la compra.
 * 
 * @author RaÃºl Negro Carpintero
 * @author Mario NÃºÃ±ez Izquierdo
 * @version 1.0
 *
 */
public class ListaCompra {
	
	private List<Producto> lista;
	
	/**
	 * Constructor de la clase.
	 */
	public ListaCompra() {
		this.lista = new ArrayList<Producto>();
	}
	
	/**
	 * MÃ©todo aÃ±adir. AÃ±ade productos a la lista de la compra.
	 * 
	 * @param producto
	 */
	private void añadir(Producto producto) {
		this.lista.add(producto);
	}
	
	/**
	 * MÃ©todo eliminar. Elimina productos de la lista de la compra.
	 * 
	 * @param producto
	 */
	private void eliminar(Producto producto) {
		if(lista.size() != 0) {
			this.lista.remove(producto);
		}
	}
	
	/**
	 * Metodo getProducto, devuelve un producto igual al introducido por parametro.
	 * 
	 * @param producto
	 */
	
	private Producto getProducto(Producto producto) {
		return this.lista.get(this.lista.indexOf(producto));
	}

	/**
	 * Metodo getProducto, devuelve el producto con el indice introducido.
	 * 
	 * @param producto
	 */
	
	private Producto getProducto(int index) {
		return this.lista.get(index);
	}
}
