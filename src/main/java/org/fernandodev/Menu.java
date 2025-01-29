package org.fernandodev;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public void eliminarLibroSubmenu( Biblioteca biblioteca) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion=0;
        boolean camposVacios = false;
        System.out.println("\n === Submenú eliminar libros ===");
        System.out.println("Selecciona una opción con el número:");
        System.out.println("1. Eliminar libro por ISBN");
        System.out.println("2. Eliminar libro por Titulo");
        System.out.println("3. Eliminar libro(s) por Autor");
        System.out.println("4. Regresar");

        while (true) {
            System.out.print("Ingrese una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine();
            }
        }

        while(!back) {
            boolean removed = false;
            switch (opcion) {
                case 1: //Eliminar por ISBN
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbn = scanner.nextLine();
                    removed = biblioteca.eliminarLibroPorIsbn(isbn);
                    System.out.println(removed ? "Libro eliminado exitosamente." : "No se encontró un libro con ese ISBN.");
                    break;
                case 2://Eliminar por Titulo
                    System.out.print("Ingrese el Tìtulo del libro a eliminar: ");
                    String titulo = scanner.nextLine();
                    removed = biblioteca.eliminarLibroPorTitulo(titulo);
                    System.out.println(removed ? "Libro eliminado exitosamente." : "No se encontró un libro con ese titulo.");
                    break;
                case 3://Eliminar por autor
                    System.out.print("Ingrese el nombre del autor del libro a eliminar: ");
                    String autor = scanner.nextLine();
                    removed = biblioteca.eliminarLibrosPorAutor(autor);
                    System.out.println(removed ? "Libro(s) eliminado(s) exitosamente." : "No se encontró ningún libro de ese autor.");
                    break;
                case 4://Regresar a menu
                    back = true;
                    System.out.println("Regresando al menú principal");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void listarLibrosSubmenu(Biblioteca biblioteca) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion=0;
        System.out.println("\n === Submenú listado de Libros ===");
        System.out.println("Selecciona una opción con el número:");
        System.out.println("1. Mostrar libros por Título");
        System.out.println("2. Mostrar libros por Autor");
        System.out.println("3. Regresar");

        while (true) {
            System.out.print("Ingrese una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine();
            }
        }

        while(!back) {
            boolean changed = false;

            switch (opcion) {
                case 1: //Mostrar libros por titulo
                    System.out.print("Ingresa el título del libro: ");
                    String titulo = scanner.nextLine();
                    biblioteca.mostrarLibrosPorTitulo(titulo);
                    break;
                case 2: //Mostrar libros por autor
                    System.out.print("Ingresa el título del libro: ");
                    String autor = scanner.nextLine();
                    biblioteca.mostrarLibrosPorAutor(autor);
                    break;
                case 3://Regresar a menu
                    back = true;
                    System.out.println("Regresando al menú principal");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void listarAutoresSubmenu(Biblioteca biblioteca) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion = 0;
        System.out.println("\n === Submenú listado Autores ===");
        System.out.println("Selecciona una opción con el número:");
        System.out.println("1. Buscar un Autor(es)");
        System.out.println("2. Mostrar todos los autores");
        System.out.println("3. Regresar");
        while (true) {
            System.out.print("Ingrese una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine();
            }
        }

        while(!back) {
            boolean changed = false;


            switch (opcion) {
                case 1: //Buscar autores
                    System.out.print("Ingresa el nombre del autor: ");
                    String autor = scanner.nextLine();
                    biblioteca.buscarAutores(autor);
                    break;
                case 2: //Mostrar todos los autores
                    biblioteca.mostrarAutores();
                    break;
                case 3://Regresar a menu
                    back = true;
                    System.out.println("Regresando al menú principal");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

}
