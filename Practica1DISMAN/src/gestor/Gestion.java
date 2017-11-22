package gestor;

import java.util.ArrayList;
import java.util.List;

import modelo.ListaCompra;
import modelo.Producto;

public class Gestion {
	
	private static List<String> nombresProducto = new ArrayList<String>();
	private static ListaCompra listaProductos = new ListaCompra();

	public static void main(String[] args) {
		

	}
	
	protected void anadirProducto(String nombre, int cantidad, float precio) {
		Producto miProducto = new Producto(nombre, cantidad, precio);	
		if(!this.nombresProducto.contains(miProducto)) {
			this.listaProductos.anadir(miProducto);
		}else {
			System.out.println("El producto " + miProducto.getNombre() + " ya esta en tu lista de la compra.");
		}
	}
	
	protected static void eliminarProducto(String nombre) {
		
	}
	
	protected static void modificarCantidad(String nombreProducto, int cantidad) {
		
	}
	
	protected static void marcarComprado(String nombre) {
		
	}

}
