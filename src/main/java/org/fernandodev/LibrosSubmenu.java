package org.fernandodev;

import java.util.List;
import java.util.Scanner;

public class LibrosSubmenu extends Menu{
    public void gestionLibrosSubmenu(GestionLibros gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean camposVacios = false;
        boolean back = false;
        int opcion = 0;

        while(!back) {
            String nombreUsuario;
            String apellidoPaterno;
            String apellidoMaterno;
            String direccion;
            String userId;
            List<Usuario> usuarioLista;
            System.out.println("\n === Submenú gestión de Libros ===");
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Añadir un libro");
            System.out.println("2. Búsqueda de libros");
            System.out.println("3. Eliminar un libro");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Regresar");

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
            switch (opcion) {
                case 1: //Añadir un libro
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    camposVacios = gestor.validarCamposObligatorios(List.of(titulo, autor, isbn));
                    if(!camposVacios) {
                        gestor.anadirLibro(new Libro(titulo, autor, isbn, true));
                        System.out.print("Libro agregado exitosamente.");
                    }else{
                        System.out.print("No puedes ingresar campos vacios");
                    }
                    break;
                case 2: //Submenu busqueda de libros
                    this.busquedaLibrosSubmenu(gestor);
                    break;
                case 3: //Submenu eliminar un libro
                    this.eliminarLibroSubmenu(gestor);
                    break;
                case 4: //Mostrar todos los libros
                    gestor.mostrarLibros();
                    break;
                case 5://Regresar a menu principal
                    back = true;
                    System.out.println("Regresando al menú principal");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void busquedaLibrosSubmenu( GestionLibros gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion;
        boolean camposVacios;
        List<Libro> libroLista;

        while(!back) {

            System.out.println("\n === Submenú búsqueda de libros ===");
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Buscar libro por Titulo");
            System.out.println("2. Buscar libro por Autor");
            System.out.println("3. Buscar libro(s) por ISBN");
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

            switch (opcion) {
                case 1: //Buscar por titulo
                    System.out.print("Ingrese el titulo del libro a buscar: ");
                    String titulo = scanner.nextLine();
                    libroLista = gestor.buscarLibrosPorTitulo(titulo);
                    System.out.println(!libroLista.isEmpty() ? libroLista : "No se encontró ningún libro con ese titulo.");
                    break;
                case 2://Buscar por Autor
                    System.out.print("Ingrese el nombre del autor: ");
                    String autor = scanner.nextLine();
                    libroLista = gestor.buscarLibrosPorAutor(autor);
                    System.out.println(!libroLista.isEmpty() ? libroLista : "No se encontró un libro con ese autor.");
                    break;
                case 3://Buscar por ISBN
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    String isbn = scanner.nextLine();
                    Libro libro = gestor.buscarLibroPorISBN(isbn);
                    System.out.println(libro != null ? libro.toString() : "No se encontró ningún libro con ese ISBN.");
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

    public void eliminarLibroSubmenu( GestionLibros gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion=0;

        while(!back) {

            while (true) {
                System.out.println("\n === Submenú eliminar libros ===");
                System.out.println("Selecciona una opción con el número:");
                System.out.println("1. Eliminar libro por ISBN");
                System.out.println("2. Eliminar libro por Titulo");
                System.out.println("3. Eliminar libro(s) por Autor");
                System.out.println("4. Regresar");
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

            boolean removed = false;
            switch (opcion) {
                case 1: //Eliminar por ISBN
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbn = scanner.nextLine();
                    removed = gestor.eliminarLibroPorIsbn(isbn);
                    System.out.println(removed ? "Libro eliminado exitosamente." : "No se encontró un libro con ese ISBN.");
                    break;
                case 2://Eliminar por titulo
                    System.out.print("Ingrese el Tìtulo del libro a eliminar: ");
                    String titulo = scanner.nextLine();
                    removed = gestor.eliminarLibroPorTitulo(titulo);
                    System.out.println(removed ? "Libro eliminado exitosamente." : "No se encontró un libro con ese titulo.");
                    break;
                case 3://Eliminar por autor
                    System.out.print("Ingrese el nombre del autor del libro a eliminar: ");
                    String autor = scanner.nextLine();
                    removed = gestor.eliminarLibrosPorAutor(autor);
                    System.out.println(removed ? "Libro(s) eliminado(s) exitosamente." : "No se encontró ningún libro de ese autor.");
                    break;
                case 4://Regresar a menu de libros
                    back = true;
                    System.out.println("Regresando al submenú de libros");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void listarLibrosSubmenu(GestionLibros gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion=0;

        while(!back) {

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

            boolean changed = false;

            switch (opcion) {
                case 1: //Mostrar libros por titulo
                    System.out.print("Ingresa el título del libro: ");
                    String titulo = scanner.nextLine();
                    gestor.mostrarLibrosPorTitulo(titulo);
                    break;
                case 2: //Mostrar libros por autor
                    System.out.print("Ingresa el título del libro: ");
                    String autor = scanner.nextLine();
                    gestor.mostrarLibrosPorAutor(autor);
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
