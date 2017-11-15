package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase ListaCompra. Creamos la estructura de la lista de la compra.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
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
	 * Método añadir. Añade productos a la lista de la compra.
	 * 
	 * @param producto
	 */
	private void añadir(Producto producto) {
		this.lista.add(producto);
	}
	
	/**
	 * Método eliminar. Elimina productos de la lista de la compra.
	 * 
	 * @param producto
	 */
	private void eliminar(Producto producto) {
		if(lista.size() != 0) {
			this.lista.remove(producto);
		}
	}
	
	private void marcarComprado(Producto producto) {
		this.lista.get(this.lista.indexOf(producto)).productoComprado();
	}
	
	/**
	 * Método marcarComprado. Utilizado para marcar un producto como comprado.
	 * 
	 * @param indice
	 */
	private void marcarComprado(int indice) {
		this.lista.get(indice).productoComprado();
	}

}
