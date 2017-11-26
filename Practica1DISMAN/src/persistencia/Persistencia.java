/**
 * 
 */
package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import modelo.ListaCompra;
import modelo.Producto;

/**
 * Clase Persistencia. Guardamos el contenido de la lista de la compra en un fichero csv.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class Persistencia {
	
	static String direccion = "Lista.csv";

	/**
	 * Método exportar. Guarda la lista de la compra en un archivo csv.
	 * 
	 * @param listaCompra
	 */
	public static void exportar(ListaCompra listaCompra) {
		
		boolean existe = new File(direccion).exists();
		
		if(existe) {
			File Lista = new File(direccion);
			Lista.delete();
		}
		
		try {
			
			CsvWriter csvWriter = new CsvWriter(new FileWriter(direccion, true), ',');
			Iterator<Producto> it = listaCompra.iterator();
			Producto producto = null;
			
			while(it.hasNext()) {
				producto = it.next();
				csvWriter.write(producto.getNombre());
				csvWriter.write(String.valueOf(producto.getCantidad()));
				csvWriter.write(String.valueOf(producto.getPrecio()));
				csvWriter.endRecord();
			}
			
			csvWriter.close();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método importar. Guarda el contenido del fichero csv en la lista de la compra.
	 * 
	 * @param listaCompra
	 */
	public static void importar(ListaCompra listaCompra) {
	
		boolean existe = new File(direccion).exists();

		if(existe) {
			
			try {
				
				CsvReader fichero = new CsvReader(direccion);
				
				while(fichero.readRecord()) {
					String nombre = fichero.get(0);
					String cantidad = fichero.get(1);
					String precio = fichero.get(2);
					Producto producto = new Producto(nombre, Integer.parseInt(cantidad), Float.parseFloat(precio));
					listaCompra.anadir(producto);
				}
				
				fichero.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}
	
}