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
	
	private List<String> miLista;
	
	/**
	 * Constructor de la clase.
	 */
	public ListaFavoritos() {
		this.miLista = new ArrayList<String>();
	}
	
	/**
	 * Método añadir. Añade productos a la lista de la compra.
	 * 
	 * @param producto
	 */
	public void anadir(Producto producto) {
		if (this.miLista.contains(producto.getNombre())) {
			this.miLista.add(producto.getNombre());
		}else {
			System.out.println("El producto ya estaba marcado como favorito");
		}
		
	}
	
	/**
	 * Método eliminar. Elimina productos de la lista de la compra.
	 * 
	 * @param producto
	 */
	public void eliminar(Producto producto) {
		if(miLista.size() != 0) {
			this.miLista.remove(producto.getNombre());
		}
	}

	/**
	 * Método getProducto, devuelve el producto con el indice introducido.
	 * 
	 * @param producto
	 */
	
	public String getProducto(int index) {
		return this.miLista.get(index);
	}

	@Override
	public Iterator iterator() {
		return this.miLista.iterator();
	}
	
	

}