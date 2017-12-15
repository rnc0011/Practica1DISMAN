/**
 * 
 */
package gestor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import modelo.ListaCompra;
import modelo.Producto;

/**
 * Clase TextIO. Se encarga de imprimir el menú.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class TextIO {
	
	//Declaración de variables
	private static ListaCompra lista = new ListaCompra();
	private static List<String> nombres = new ArrayList<String>();
	
	/**
	 * Método ejecutar. Pinta el menú y pide por teclado una opción.
	 */
	static public void ejecutar() {
		pintarMenu();
		cogerLista();
		cogerNombres();
		Scanner entrada = new Scanner(System.in);
		String opcion = entrada.nextLine();
		menu(opcion);
		entrada.close();
	}

	/**
	 * Método pintarMenu. Muestra las opciones iniciales al usuario.
	 */
    static public void pintarMenu() {
        System.out.println("*******Lista de la compra*******");
        System.out.println("¿Qué quiere hacer? (Introduzca el número de la opción)");
        System.out.println("1.- Añadir productos a la lista");
        System.out.println("2.- Eliminar productos de la lista");
        System.out.println("3.- Cambiar la cantidad de un producto de la lista");
        System.out.println("4.- Marcar productos de la lista como comprados");
        System.out.println("5.- Ver lista de la compra");
        System.out.println("0.- Guardar la lista y salir");
    }

    /**
     * Método menu. Muestra y realiza las subacciones del menú.
     * 
     * @param opcion
     */
    static public void menu(String opcion) {
        String nombre = "";
        int cantidad = 0;
        float precio = 0;
        Scanner entrada = new Scanner(System.in);

        if(opcion.equals("1")) {
	        	try {
	        		
		            System.out.println("Introduzca el nombre del producto");
		            nombre = entrada.nextLine();
		            if(!nombres.contains(nombre)) {
		            		System.out.println("Introduzca la cantidad del producto");
			            cantidad = entrada.nextInt();
			            System.out.println("Introduzca el precio del producto");
			            precio = entrada.nextFloat();
			            Gestion.anadirProducto(nombre, cantidad, precio);
	            			System.out.println("El producto " + nombre + " se ha añadido a su lista de la compra.");
		            } else {
		            		System.out.println("El producto " + nombre + " ya está en su lista de la compra.");
		            }
		            System.out.println("");
		            ejecutar();
	         
	        	} catch (InputMismatchException e){
	        		System.err.println("Error en el ultimo dato intruducido.");
	        		ejecutar();
	        	}
        }

        if(opcion.equals("2")) {
            System.out.println("Introduzca el nombre del producto a eliminar");
            pintarLista();
            nombre = entrada.nextLine();
            if(nombres.contains(nombre)) {
            		Gestion.eliminarProducto(nombre);
            		System.out.println("El producto " + nombre + " se ha eliminado de su lista de la compra.");
            } else {
            		System.out.println("El producto " + nombre + " no existe.");
            }
            System.out.println("");
            ejecutar();
        }

        if(opcion.equals("3")) {
            System.out.println("Introduzca el nombre del producto del que quiere modificar la cantidad");
            pintarLista();
            nombre = entrada.nextLine();
            if(nombres.contains(nombre)) {
            		System.out.println("Introduzca la nueva cantidad");
                cantidad = entrada.nextInt();
                Gestion.modificarCantidad(nombre, cantidad);
                System.out.println("La cantidad del producto " + nombre + " se ha modificado correctamente.");
            } else {
            		System.out.println("El producto " + nombre + " no está en su lista de la compra.");
            }
            System.out.println("");
            ejecutar();
        }

        if(opcion.equals("4")) {
            System.out.println("Introduzca el nombre del producto que quiere marcar como comprado");
            pintarLista();
            nombre = entrada.nextLine();
            if(nombres.contains(nombre)) {
            		Gestion.marcarComprado(nombre);
            		System.out.println("El producto " + nombre + " está ahora marcado como comprado.");
            } else {
            		System.out.println("El producto " + nombre + " no está en su lista de la compra.");
            } 
            System.out.println("");
            ejecutar();
        }
        
        if(opcion.equals("5")) {
        		pintarLista();
        		System.out.println("");
        		ejecutar();
        }

        if(opcion.equals("0")) {
            Gestion.guardarLista();
            System.out.println("La lista se ha guardado");
            System.out.println("Saliendo...");
        }
        
        entrada.close();
    }
    
    /**
	 * Método cogerLista. Guarda la lista de la compra para poder imprimirla después.
	 */
	public static void cogerLista() {
		lista = Gestion.devolverLista();
	}
	
	/**
	 * Método cogerNombres. Guarda la lista de los nombres.
	 */
	public static void cogerNombres() {
		nombres = Gestion.devolverNombres();
	}
    
    /**
	 * Método pintarLista. Imprime los productos de la lista de la compra.
	 */
	public static void pintarLista() {
		Iterator<Producto> it = lista.iterator();
		Producto producto = null;
		while(it.hasNext()) {
			producto = it.next();
			System.out.println("Nombre: " + producto.getNombre() + "  Cantidad: " + producto.getCantidad() + "  Precio: " + producto.getPrecio());
		}
	}
	
}