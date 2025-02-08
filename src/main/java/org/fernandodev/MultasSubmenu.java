package org.fernandodev;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MultasSubmenu extends Menu {
    private final Scanner scanner =  new Scanner(System.in);
    boolean back = false;

    public void gestionMultasSubmenu(GestionMultas gestor) {
        boolean camposVacios;
        int opcion;

        while(!back) {
            String idUsuario;
            String idPrestamo;
            System.out.println(ConsoleColors.BG_BLUE + "=== Submenú gestión de multas ===" + ConsoleColors.RESET);
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Añadir una multa");
            System.out.println("2. Búsqueda de multas");
            System.out.println("3. Eliminar una multa");
            System.out.println("4. Listar multas");
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
                case 1: //Añadir una multa
                    System.out.print("ID del usuario: ");
                    idUsuario = scanner.nextLine();
                    System.out.print("ID del prestamo: ");
                    idPrestamo = scanner.nextLine();
                    System.out.print("""
                            Motivo:\s
                            1- Retraso\s
                            2- Libro dañado\s
                            3- Perdida""");
                    int opcionMotivo = scanner.nextInt();
                    MotivoMulta motivo = switch(opcionMotivo) {
                        case 1:  yield MotivoMulta.RETRASO;
                        case 2:  yield MotivoMulta.LIBRO_DANADO;
                        case 3:  yield MotivoMulta.PERDIDA;
                        default:
                            System.out.println("Opción inválida. Se asignará RETRASO por defecto.");
                            yield MotivoMulta.RETRASO;
                    };

                    camposVacios = gestor.validarCamposObligatorios(List.of(idUsuario, idPrestamo));

                    if(!camposVacios) {
                        LocalDateTime fechaActual = LocalDateTime.now();

                        gestor.anadirMulta(new Multa(
                                idUsuario,
                                idPrestamo,
                                motivo,
                                0
                        ));
                        System.out.print("Multa registrada exitosamente.");
                    }else{
                        System.out.print("No puedes ingresar campos vacíos");
                    }
                    break;
                case 2: //Submenu busqueda de multas
                    this.busquedaMultasSubmenu(gestor);
                    break;
                case 3: //Submenu eliminar una multa
                    this.eliminarMultaSubmenu(gestor);
                    break;
                case 4: //Submenu mostrar multas
                    this.listarMultaSubmenu(gestor);
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

    public void busquedaMultasSubmenu( GestionMultas gestor) {
        int opcion;
        List<Multa> multaLista;
        Multa multa;

        while(!back) {
            System.out.println(ConsoleColors.BG_BLUE + "=== Submenú búsqueda de prestamos ===" + ConsoleColors.RESET);
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Buscar multa por su ID");
            System.out.println("2. Buscar multa por ID de usuario");
            System.out.println("3. Buscar multa por fecha");
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
                    System.out.print("Ingrese el ID de la multa a buscar: ");
                    String idMulta = scanner.nextLine();
                    multa = gestor.buscarMultaPorId(idMulta);
                    System.out.println(multa != null ? multa : "No se encontró ninguna multa con ese ID.");
                    break;
                case 2://Buscar por ID de usuario
                    System.out.print("Ingrese el ID del usuario: ");
                    String idUsuario = scanner.nextLine();
                    multaLista = gestor.buscarMultasPorIdUsuario(idUsuario);
                    System.out.println(!multaLista.isEmpty() ? multaLista : "No se encontró ninguna multa asociado a ese usuario.");
                    break;
                case 3://Buscar por fecha
                    System.out.print("Ingrese la fecha inicial en formato dd-mm-yyyy: ");
                    String fecha = scanner.nextLine();
                    multaLista = gestor.buscarMultasPorFecha(fecha);
                    System.out.println(!multaLista.isEmpty() ? multaLista : "No se encontró ninguna multa en esa fecha.");
                    break;
                case 4://Regresar a submenu de multas
                    back = true;
                    System.out.println("Regresando al submenú de multas");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void eliminarMultaSubmenu( GestionMultas gestor) {
        int opcion;

        while(!back) {

            while (true) {
                System.out.println(ConsoleColors.BG_BLUE + "=== Submenú eliminar multas ===" + ConsoleColors.RESET);
                System.out.println("Selecciona una opción con el número:");
                System.out.println("1. Eliminar multa por ID");
                System.out.println("2. Eliminar multas de un usuario");
                System.out.println("3. Eliminar todos las multas");
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
                    System.out.print("Ingrese el ID del multa a eliminar: ");
                    String idMulta = scanner.nextLine();
                    removed = gestor.eliminarMultaPorId(idMulta);
                    System.out.println(removed ? "Multa eliminada exitosamente." : "No se encontró una multa con ese ID.");
                    break;
                case 2://Eliminar por ID de usuario
                    System.out.print("Ingrese el ID del usuario: ");
                    String idUsuario = scanner.nextLine();
                    removed = gestor.eliminarMultasPorIdUsuario(idUsuario);
                    System.out.println(removed ? "Se eliminaron todas las multas de este usuario exitosamente." : "No se encontró un usuario con ese ID.");
                    break;
                case 3://Eliminar todos los prestamos
                    System.out.print( "Advertencia: Se borrarán todos los registros de multas.\n" +
                            "¿Desea continuar? (S)i - (N)o: "
                    );
                    String op = scanner.nextLine();
                    if(op.equalsIgnoreCase("s")) {
                        gestor.eliminarMultas();
                        System.out.println( "Se eliminaron todas los registros de multas");
                    }
                    break;
                case 4://Regresar a submenu de multas
                    back = true;
                    System.out.println("Regresando al submenú de multas");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

    public void listarMultaSubmenu(GestionMultas gestor) {
        int opcion;
        List<Multa> multaLista;

        while(!back) {
            System.out.println(ConsoleColors.BG_BLUE + "=== Submenú listado de Multas ===" + ConsoleColors.RESET);
            System.out.println("Selecciona una opción con el número:");
            System.out.println("1. Mostrar multas vigentes");
            System.out.println("2. Mostrar multas recientes");
            System.out.println("3. Mostrar todos las multas");
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
                    multaLista =  gestor.obtenerMultasVigentes();
                    System.out.println(!multaLista.isEmpty()  ? multaLista : "No hay multas vigentes");
                    break;
                case 2: //Mostrar multas recientes
                    multaLista = gestor.obtenerMultasRecientes();
                    System.out.println(!multaLista.isEmpty()  ? multaLista : "No hay multas recientes");
                    break;
                case 3: //Mostrar todos los multas
                    multaLista = gestor.obtenerMultas();
                    System.out.println(!multaLista.isEmpty()  ? multaLista : "No hay multas registradas");
                    break;
                case 4://Regresar a submenu multas
                    back = true;
                    System.out.println("Regresando al submenú de multas");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }
}
