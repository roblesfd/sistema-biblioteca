package org.fernandodev;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class PrestamosSubmenu {
    public void gestionPrestamosSubmenu(GestionPrestamos gestor, GestionLibros gestorLibros) {
        Scanner scanner =  new Scanner(System.in);
        boolean camposVacios;
        boolean back = false;
        int opcion;

        while(!back) {
            String usuarioId;
            String isbnLibro;
            System.out.println("\n === Submenú gestión de Prestamos ===");
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Añadir un préstamo");
            System.out.println("2. Búsqueda de prestamos");
            System.out.println("3. Eliminar un préstamo");
            System.out.println("4. Listar prestamos");
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
                case 1: //Añadir un prestamo
                    System.out.print("ID del usuario: ");
                     usuarioId = scanner.nextLine();
                    System.out.print("ISBN de libro a prestar: ");
                    isbnLibro = scanner.nextLine();
                    Libro libroAPrestar = gestorLibros.buscarLibroPorISBN(isbnLibro);
                    camposVacios = gestor.validarCamposObligatorios(List.of(usuarioId,isbnLibro));

                    if(!camposVacios && !libroAPrestar.toString().isEmpty()) {
                        LocalDateTime fechaActual = LocalDateTime.now();
                        LocalDateTime fechaEntrega = fechaActual.plusWeeks(1);

                        gestor.anadirPrestamo(new Prestamo(usuarioId, libroAPrestar, fechaActual, fechaEntrega));
                        System.out.print("Préstamo registrado exitosamente.");
                    }else{
                        System.out.print("No puedes ingresar campos vacíos y/o no se encontró el libro a prestar");
                    }
                    break;
                case 2: //Submenu busqueda de prestamos
                    this.busquedaPrestamosSubmenu(gestor);
                    break;
                case 3: //Submenu eliminar un prestamo
                    this.eliminarPrestamoSubmenu(gestor);
                    break;
                case 4: //Submenu mostrar prestamos
                    this.listarPrestamoSubmenu(gestor);
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

    public void busquedaPrestamosSubmenu( GestionPrestamos gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion;
        List<Prestamo> prestamoLista;
        Prestamo prestamo;


        while(!back) {

            System.out.println("\n === Submenú búsqueda de prestamos ===");
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Buscar préstamo por ID de préstamo");
            System.out.println("2. Buscar préstamo por ID de usuario");
            System.out.println("3. Buscar préstamo por fecha");
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
                case 1: //Buscar por ID de prestamo
                    System.out.print("Ingrese el ID del préstamo a buscar: ");
                    String idPrestamo = scanner.nextLine();
                    prestamo = gestor.buscarPrestamoPorId(idPrestamo);
                    System.out.println(prestamo != null ? prestamo : "No se encontró ningún préstamo con ese ID.");
                    break;
                case 2://Buscar por ID de usuario
                    System.out.print("Ingrese el ID del usuario: ");
                    String usuarioId = scanner.nextLine();
                    prestamoLista = gestor.buscarPrestamosPorIdUsuario(usuarioId);
                    System.out.println(!prestamoLista.isEmpty() ? prestamoLista : "No se encontró ningún préstamo asociado a ese usuario.");
                    break;
                case 3://Buscar por fecha
                    System.out.print("Ingrese la fecha inicial en formato dd-mm-yyyy: ");
                    String fechaInicio = scanner.nextLine();
                    System.out.print("Ingrese la fecha final en formato dd-mm-yyyy: ");
                    String fechaFinal = scanner.nextLine();
                    prestamoLista = gestor.buscarPrestamosPorFecha(fechaInicio,fechaFinal);
                    System.out.println(!prestamoLista.isEmpty() ? prestamoLista : "No se encontró ningún préstamo dentro de ese periodo.");
                    break;
                case 4://Regresar a submenu de prestamos
                    back = true;
                    System.out.println("Regresando al submenú de prestamos");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void eliminarPrestamoSubmenu( GestionPrestamos gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion;

        while(!back) {

            while (true) {
                System.out.println("\n === Submenú eliminar prestamos ===");
                System.out.println("Selecciona una opción con el número:");
                System.out.println("1. Eliminar préstamo por ID");
                System.out.println("2. Eliminar préstamos de un usuario");
                System.out.println("3. Eliminar todos los prestamos");
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

            boolean removed;
            switch (opcion) {
                case 1: //Eliminar por ID de prestamo
                    System.out.print("Ingrese el ID del préstamo a eliminar: ");
                    String idPrestamo = scanner.nextLine();
                    removed = gestor.eliminarPrestamoPorId(idPrestamo);
                    System.out.println(removed ? "Préstamo eliminado exitosamente." : "No se encontró un préstamo con ese ID.");
                    break;
                case 2://Eliminar por ID de usuario
                    System.out.print("Ingrese el ID del usuario: ");
                    String idUsuario = scanner.nextLine();
                    removed = gestor.eliminarPrestamosPorIdUsuario(idUsuario);
                    System.out.println(removed ? "Se eliminaron todos prestamos de este usuario exitosamente." : "No se encontró un usuario con ese ID.");
                    break;
                case 3://Eliminar todos los prestamos
                    System.out.print( "Advertencia: Se borrarán todos los registros de prestamos.\n" +
                                    "¿Desea continuar? (S)i - (N)o: "
                            );
                    String op = scanner.nextLine();
                    if(op.equalsIgnoreCase("s")) {
                        gestor.eliminarPrestamos();
                        System.out.println( "Se eliminaron todos los registros de prestamos");
                    }
                    break;
                case 4://Regresar a submenu de prestamos
                    back = true;
                    System.out.println("Regresando al submenú de prestamos");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void listarPrestamoSubmenu(GestionPrestamos gestor) {
        Scanner scanner =  new Scanner(System.in);
        boolean back = false;
        int opcion;
        List<Prestamo> prestamoLista;

        while(!back) {
            System.out.println("\n === Submenú listado de Prestamos ===");
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Mostrar prestamos vigentes");
            System.out.println("2. Mostrar prestamos recientes");
            System.out.println("3. Mostrar todos los prestamos");
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
                case 1: //Mostrar prestamos vigentes
                    prestamoLista =  gestor.obtenerPrestamosVigentes();
                    System.out.println(!prestamoLista.isEmpty()  ? prestamoLista : "No hay prestamos vigentes");
                    break;
                case 2: //Mostrar prestamos recientes
                    prestamoLista = gestor.obtenerPrestamosRecientes();
                    System.out.println(!prestamoLista.isEmpty()  ? prestamoLista : "No hay prestamos recientes");
                    break;
                case 3: //Mostrar todos los prestamos
                    prestamoLista = gestor.obtenerPrestamos();
                    System.out.println(!prestamoLista.isEmpty()  ? prestamoLista : "No hay prestamos registrados");
                    break;
                case 4://Regresar a submenu prestamos
                    back = true;
                    System.out.println("Regresando al submenú de prestamos");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }
}
