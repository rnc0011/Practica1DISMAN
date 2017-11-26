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
	}
	
	/**
	 * Metodo para modificar la cantidad del producto.
	 * 
	 * @param nuevaC Nueva cantidad
	 */
	
	public void modificarCantidad(int nuevaC) {
		this.cantidad = nuevaC;
	}
	
	/**
	 * Método getNombre. Devuelve el nombre del producto.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Método getCantidad. Devuelve la cantidad del producto.
	 * 
	 * @return cantidad
	 */
	public int getCantidad() {
		return this.cantidad;
	}
	
	/**
	 * Método getPrecio. Devuelve el precio del producto.
	 * 
	 * @return precio
	 */
	public float getPrecio() {
		return this.precio;
	}
	
}