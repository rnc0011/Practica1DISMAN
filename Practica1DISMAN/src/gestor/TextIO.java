/**
 * 
 */
package gestor;

import java.util.Scanner;

/**
 * Clase TextIO. Se encarga de imprimir el menú.
 * 
 * @author Raúl Negro Carpintero
 * @author Mario Núñez Izquierdo
 * @version 1.0
 */
public class TextIO {

	/**
	 * Constructor de la clase.
	 */
	public TextIO() {
		
    }
	
	/**
	 * Método ejecutar. Pinta el menú y pide por teclado una opción.
	 */
	public void ejecutar() {
		pintarMenu();
		Scanner entrada = new Scanner(System.in);
		String opcion = entrada.nextLine();
		menu(opcion);
		entrada.close();
	}

	/**
	 * Método pintarMenu. Muestra las opciones iniciales al usuario.
	 */
    public void pintarMenu() {
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
    public void menu(String opcion) {
        String nombre = "";
        int cantidad = 0;
        float precio = 0;
        Scanner entrada = new Scanner(System.in);

        if(opcion.equals("1")) {
            System.out.println("Introduzca el nombre del producto");
            nombre = entrada.nextLine();
            System.out.println("Introduzca la cantidad del producto");
            cantidad = entrada.nextInt();
            System.out.println("Introduzca el precio del producto");
            precio = entrada.nextFloat();
            Gestion.anadirProducto(nombre, cantidad, precio);
            System.out.println("");
            ejecutar();
        }

        if(opcion.equals("2")) {
            System.out.println("Introduzca el nombre del producto a eliminar");
            Gestion.pintarLista();
            nombre = entrada.nextLine();
            Gestion.eliminarProducto(nombre);
            System.out.println("");
            ejecutar();
        }

        if(opcion.equals("3")) {
            System.out.println("Introduzca el nombre del producto del que quiere modificar la cantidad");
            Gestion.pintarLista();
            nombre = entrada.nextLine();
            System.out.println("Introduzca la nueva cantidad");
            cantidad = entrada.nextInt();
            Gestion.modificarCantidad(nombre, cantidad);
            System.out.println("");
            ejecutar();
        }

        if(opcion.equals("4")) {
            System.out.println("Introduzca el nombre del producto que quiere marcar como comprado");
            Gestion.pintarLista();
            nombre = entrada.nextLine();
            Gestion.marcarComprado(nombre);
            System.out.println("");
            ejecutar();
        }
        
        if(opcion.equals("5")) {
        		Gestion.pintarLista();
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
	
}