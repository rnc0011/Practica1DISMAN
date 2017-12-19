/**
 * 
 */
package persistencia;

import modelo.ListaCompra;

/**
 * Clase Persistencia. Interfaz que hace la tarea de una "fachada" para utilizar los diferentes modelos de persistencia.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public interface Persistencia {
	
	/**
	 * Método importar. Este metodo, comprobara si ya hay un fichero de datos 
	 * y en caso de haberlo, recuperara los datos y los volcara en la lista de la compra pasada por parametro.
	 * 
	 * @param listaCompra
	 */
	public void importar(ListaCompra listaCompra);
	
	/**
	 * Método exportar. Este metodo debera guardar la lista de la compra en un archivo csv.
	 * 
	 * @param listaCompra
	 */
	public void exportar(ListaCompra listaCompra);
	
}
