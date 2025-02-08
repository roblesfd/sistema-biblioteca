package org.fernandodev;

import java.util.List;
import java.util.Scanner;

public class UsuariosSubmenu extends Menu{
    public void gestionUsuariosSubmenu(GestionUsuarios gestor) {
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
            System.out.println(ConsoleColors.BG_BLUE + "=== Submenú gestión de usuarios ===" + ConsoleColors.RESET);
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Añadir un usuario");
            System.out.println("2. Eliminar un usuario");
            System.out.println("3. Búsqueda de un usuario");
            System.out.println("4. Mostrar todos los usuarios");
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
                case 1: //Añadir usuario
                    System.out.print("Nombre: ");
                    nombreUsuario = scanner.nextLine();
                    System.out.print("Apellido Paterno: ");
                    apellidoPaterno = scanner.nextLine();
                    System.out.print("Apellido Materno: ");
                    apellidoMaterno = scanner.nextLine();
                    System.out.print("Dirección: ");
                    direccion = scanner.nextLine();
                    camposVacios = gestor.validarCamposObligatorios(List.of(nombreUsuario, apellidoPaterno, apellidoMaterno, direccion));
                    if(!camposVacios) {
                        gestor.anadirUsuario(new Usuario(nombreUsuario, apellidoPaterno, apellidoMaterno, direccion));
                        System.out.print("Usuario agregado exitosamente.");
                    }else{
                        System.out.print("No puedes ingresar campos vacíos");
                    }
                    break;
                case 2: //Submenu eliminar un usuario
                    this.eliminarUsuarioSubmenu(gestor);
                    break;
                case 3: //Submenu busqueda de usuarios
                    this.busquedaUsuariosSubmenu(gestor);
                    break;
                case 4://Mostrar todos los usuarios
                    gestor.mostrarUsuarios();
                    break;
                case 5://Regresar a menu
                    back = true;
                    System.out.println("Regresando al menú principal");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void busquedaUsuariosSubmenu(GestionUsuarios gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion = 0;
        List<Usuario> result;

        while(!back) {
            System.out.println(ConsoleColors.BG_BLUE + "=== Submenú búsqueda Autores ===" + ConsoleColors.RESET);
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Buscar un usuario por ID");
            System.out.println("2. Buscar un usuario por nombre");
            System.out.println("3. Buscar un usuario por apellido");
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
                case 1: //Buscar usuario por ID
                    System.out.print("Ingresa el ID del usuario: ");
                    String idUsuario = scanner.nextLine();
                    Usuario usuario =  gestor.buscarUsuarioPorId(idUsuario);
                    System.out.println(usuario != null ? usuario.toString() :  "No se encontró ningún usuario con ese ID.");
                    break;
                case 2: //Buscar un usuario por nombre
                    System.out.print("Ingresa el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    result =  gestor.buscarUsuariosPorNombre(nombre);
                    System.out.println(!result.isEmpty() ? result.toString() : "No se encontró ningún usuario con ese nombre.");
                    break;
                case 3: //Buscar un usuario por apellido
                    System.out.print("Ingresa el apellido paterno del usuario: ");
                    String apellido = scanner.nextLine();
                    result =  gestor.buscarUsuariosPorApellido(apellido);
                    System.out.println(!result.isEmpty() ? result.toString() : "No se encontró ningún usuario con ese apellido.");
                    break;
                case 4://Regresar a submenu gestion libros
                    back = true;
                    System.out.println("Regresando al submenú gestión de libros");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void eliminarUsuarioSubmenu( GestionUsuarios gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion=0;

        while(!back) {
            System.out.println(ConsoleColors.BG_BLUE + "=== Submenú eliminar usuarios ===" + ConsoleColors.RESET);
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Eliminar usuario por ID");
            System.out.println("2. Eliminar usuario por Nombre");
            System.out.println("3. Eliminar usuario(s) por Apellido");
            System.out.println("4. Regresar");
            System.out.print("Ingrese una opción: ");

            while (true) {

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
                case 1: //Eliminar por ID
                    System.out.print("Ingrese el ID del libro a eliminar: ");
                    String isbn = scanner.nextLine();
                    removed = gestor.eliminarUsuarioPorId(isbn);
                    System.out.println(removed ? "Usuario eliminado exitosamente." : "No se encontró un usuario con ese ID.");
                    break;
                case 2://Eliminar por nombre
                    System.out.print("Ingrese el nombre del usuario a eliminar: ");
                    String nombre = scanner.nextLine();
                    removed = gestor.eliminarUsuarioPorNombre(nombre);
                    System.out.println(removed ? "Usuario eliminado exitosamente." : "No se encontró un usuario con ese nombre.");
                    break;
                case 3://Eliminar por apellido
                    System.out.print("Ingrese el apellido del usuario a eliminar: ");
                    String apellido = scanner.nextLine();
                    removed = gestor.eliminarUsuarioPorApellido(apellido);
                    System.out.println(removed ? "Usuario eliminado exitosamente." : "No se encontró ningún usuario con ese apellido.");
                    break;
                case 4://Regresar a submenu de libros
                    back = true;
                    System.out.println("Regresando al submenú de libros");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }
}
