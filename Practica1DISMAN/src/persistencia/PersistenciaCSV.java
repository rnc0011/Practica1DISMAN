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
import modelo.ListaFavoritos;
import modelo.Producto;

/**
 * Clase Persistencia. Guardamos el contenido de la lista de la compra en un fichero csv.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class PersistenciaCSV implements Persistencia{
	
	static String direccionCompra = "ListaCompra.csv";
	static String direccionFavoritos = "ListaFavoritos.csv";

	/**
	 * Método exportar. Guarda la lista de la compra en un archivo csv.
	 * 
	 * @param listaCompra
	 */
	public void exportar(ListaCompra listaCompra){
		
		boolean existe = new File(direccionCompra).exists();
		
		if(existe) {
			File Lista = new File(direccionCompra);
			Lista.delete();
		}
		
		try {
			
			CsvWriter csvWriter = new CsvWriter(new FileWriter(direccionCompra, true), ',');
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
	public void importar(ListaCompra listaCompra) {
	
		boolean existe = new File(direccionCompra).exists();

		if(existe) {
			
			try {
				
				CsvReader fichero = new CsvReader(direccionCompra);
				
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
	
	/**
	 * Método exportar. Guarda la lista de la compra en un archivo csv.
	 * 
	 * @param listaCompra
	 */
	public void exportar(ListaFavoritos listaFavoritos){
		
		boolean existe = new File(direccionFavoritos).exists();
		
		if(existe) {
			File Lista = new File(direccionFavoritos);
			Lista.delete();
		}
		
		try {
			
			CsvWriter csvWriter = new CsvWriter(new FileWriter(direccionFavoritos, true), ',');
			Iterator<String> it = listaFavoritos.iterator();
			
			while(it.hasNext()) {
				csvWriter.write(it.next());
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
	public void importar(ListaFavoritos listaFavoritos) {
	
		boolean existe = new File(direccionFavoritos).exists();

		if(existe) {
			
			try {
				
				CsvReader fichero = new CsvReader(direccionFavoritos);
				
				while(fichero.readRecord()) {
					String nombre = fichero.get(0);
					listaFavoritos.anadir(nombre);
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