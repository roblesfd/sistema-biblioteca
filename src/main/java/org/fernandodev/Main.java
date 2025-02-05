package org.fernandodev;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionLibros gestorLibros = new GestionLibros();
        GestionUsuarios gestorUsuarios = new GestionUsuarios();
        UsuariosSubmenu usuariosSubmenu = new UsuariosSubmenu();
        LibrosSubmenu librosSubmenu = new LibrosSubmenu();

        Scanner scanner =  new Scanner(System.in);
        boolean exit = false;

        //Menu interactivo
        while(!exit) {
            System.out.println("\n === Menu Biblioteca ===");
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Gestión de libros");
            System.out.println("2. Gestión de usuarios");
//            System.out.println("3. Gestión de prestamos");
//            System.out.println("4. Gestión de multas");
            System.out.println("5. Salir");
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
                case 1://Submenu de libros
                    librosSubmenu.gestionLibrosSubmenu(gestorLibros);
                    break;
                case 2://Submenu gestion usuarios
                    usuariosSubmenu.gestionUsuariosSubmenu(gestorUsuarios);
                    break;
//                case 3://Submenu gestion prestamos
//                    menu.eliminarLibroSubmenu(biblioteca);
//                    break;
//                case 4://Submenu gestion multas
//                    menu.gestionUsuariosSubmenu(biblioteca);
//                    break;
                case 5://Salir
                    exit = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intenta nuevamente.");
            }
        }


    }
}