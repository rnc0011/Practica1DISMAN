package modelo;

/**
 * Clase Producto. Creamos la estructura de un producto.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class Producto {
	
	//Declaración de variables
	private String nombre;
	private int cantidad;
	private float precio;
	private boolean comprado;
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public Producto(String nombre, int cantidad, float precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.comprado = false;
	}
	
	/**
	 * Método productoComprado. Utilizado para marcar un producto como comprado.
	 * 
	 */
	public void productoComprado() {
		this.comprado = true;
	}
	
	/**
	 * Metodo para modificar la cantidad del producto.
	 * 
	 * @param nuevaC Nueva cantidad
	 */
	
	public void modificarCantidad(int nuevaC) {
		this.cantidad = nuevaC;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
