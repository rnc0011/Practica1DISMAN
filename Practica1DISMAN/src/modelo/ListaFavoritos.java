/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase ListaFavoritos.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class ListaFavoritos implements Iterable<String> {

	// Declaración de variables
	private List<String> miLista;

	/**
	 * Constructor de la clase.
	 */
	public ListaFavoritos() {
		this.miLista = new ArrayList<String>();
	}

	/**
	 * Método anadir. Añade productos a la lista de la compra.
	 * 
	 * @param nombre
	 */
	public void anadir(String nombre) {
		if (!this.miLista.contains(nombre)) {
			this.miLista.add(nombre);
		} else {
			System.out.println("El producto ya estaba marcado como favorito");
		}
	}

	/**
	 * Método getProducto. Devuelve el producto con el índice introducido.
	 * 
	 * @param producto
	 */

	public String getProducto(int index) {
		return this.miLista.get(index);
	}

	/**
	 * Método contiene. Comprueba si la lista de favoritos contiene un producto
	 * determinado.
	 * 
	 * @param nombre
	 * @return true o false
	 */
	public boolean contiene(String nombre) {
		if (this.miLista.contains(nombre)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<String> iterator() {
		return this.miLista.iterator();
	}

	/**
	 * Método size. Devuelve el tamaño de la lista de favoritos.
	 * 
	 * @return tamaño
	 */
	public int size() {
		return this.miLista.size();
	}

}
