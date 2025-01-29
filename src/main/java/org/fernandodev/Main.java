package org.fernandodev;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Menu menu = new Menu();
        Scanner scanner =  new Scanner(System.in);
        boolean exit = false;

        //Menu interactivo
        while(!exit) {
            System.out.println("\n === Menu Biblioteca ===");
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Agregar libro(s)");
            System.out.println("2. Buscar libros");
            System.out.println("3. Buscar autores");
            System.out.println("4. Eliminar libro(s)");
            System.out.println("5. Añadir usuario");
            System.out.println("6. Mostrar usuarios");
            System.out.println("7. Salir");
            int opcion=0;
            boolean camposVacios = false;

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

            switch(opcion) {
                case 1://Añadir libro
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    camposVacios = biblioteca.validarCamposObligatorios(List.of(titulo, autor, isbn));
                    if(!camposVacios) {
                        biblioteca.anadirLibro(new Libro(titulo, autor, isbn, true));
                        System.out.print("Libro agregado exitosamente.");
                    }else{
                        System.out.print("No puedes ingresar campos vacios");
                    }
                    break;
                case 2://Submenu Listar libros
                    menu.listarLibrosSubmenu(biblioteca);
                    break;
                case 3://Submenu Listar autores
                    menu.listarAutoresSubmenu(biblioteca);
                    break;
                case 4://Submenu eliminar libros
                    menu.eliminarLibroSubmenu(biblioteca);
                    break;
                case 5://Añadir usuario
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido Paterno: ");
                    String apellidoPaterno = scanner.nextLine();
                    System.out.print("Apellido Materno: ");
                    String apellidoMaterno = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    camposVacios = biblioteca.validarCamposObligatorios(List.of(nombre, apellidoPaterno, apellidoMaterno, direccion));
                    if(!camposVacios) {
                        biblioteca.anadirUsuario(new Usuario(nombre, apellidoPaterno, apellidoMaterno, direccion));
                        System.out.print("Usuario agregado exitosamente.");
                    }else{
                        System.out.print("No puedes ingresar campos vacíos");
                    }
                    break;
                case 6://Mostrar Usuarios
                    System.out.println("Lista de usuarios");
                    biblioteca.mostrarUsuarios();
                    break;
                case 7://Salir
                    exit = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intenta nuevamente.");
            }
        }


    }
}