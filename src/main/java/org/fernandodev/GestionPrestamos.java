package org.fernandodev;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionPrestamos extends Biblioteca {
    protected List<Prestamo> listaPrestamos;

    public GestionPrestamos() {
        super();
        listaPrestamos = new ArrayList<>();
    }

    //METODOS AÑADIR
    public void anadirPrestamo(Prestamo nuevoPrestamo){
        listaPrestamos.add(nuevoPrestamo);
    }

    //METODOS BUSCAR
    public Prestamo buscarPrestamoPorId(String idPrestamo){
        List<Prestamo> resultados =  listaPrestamos.stream()
                .filter(prestamo -> prestamo.getUsuarioID().equalsIgnoreCase((idPrestamo)))
                .toList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public List<Prestamo> buscarPrestamosPorIdUsuario(String idUsuario){
        List<Prestamo> resultados = new ArrayList<>();
        for(Prestamo prestamo: listaPrestamos) {
            if(prestamo.getUsuarioID().equals(idUsuario)) {
                resultados.add(prestamo);
            }
        }
        return resultados;
    }

    public List<Prestamo> buscarPrestamosPorFecha(String fechaInicio, String fechaFin){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("dd-MM-yyyy"));
        LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
        LocalDate fin = LocalDate.parse(fechaFin, formatter);

        return listaPrestamos.stream()
                .filter(prestamo -> {
                   LocalDateTime fecha = prestamo.getFechaDePrestamo();
                   return  (fecha.isEqual(inicio.atStartOfDay()) || fecha.isAfter(inicio.atStartOfDay())) &&
                           (fecha.isEqual(fin.atStartOfDay()) || fecha.isBefore(fin.atStartOfDay()));
                })
                .collect((Collectors.toList()));
    }

    //METODOS ELIMINAR
    public boolean eliminarPrestamoPorId(String idPrestamo){
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId().equals(idPrestamo)) {
                listaPrestamos.remove(prestamo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPrestamosPorIdUsuario(String idUsuario){
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuarioID().equals(idUsuario)) {
                listaPrestamos.remove(prestamo);
                return true;
            }
        }
        return false;
    }

    //Elimina todos los prestamos registrados
    public void eliminarPrestamos(){
        listaPrestamos.clear();
    }

    //METODOS MOSTRAR
    public List<Prestamo> obtenerPrestamosVigentes(){

        LocalDateTime fechaHoraActual = LocalDateTime.now();

        return listaPrestamos.stream()
                .filter(prestamo -> prestamo.getFechaDeEntrega().isAfter(fechaHoraActual))
                .collect(Collectors.toList());
    }

    //Obtiene los prestamos dentro de una ventana de tiempo de 1 semana
    public List<Prestamo> obtenerPrestamosRecientes(){
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaSemanaAnterior = fechaActual.minusWeeks(2);

        return listaPrestamos.stream()
                .filter(prestamo ->
                        prestamo.getFechaDePrestamo().isAfter(fechaSemanaAnterior) &&
                                prestamo.getFechaDePrestamo().isBefore(fechaActual)
                )
                .collect(Collectors.toList());
    }

    public List<Prestamo> obtenerPrestamos(){
        return listaPrestamos;
    }
}
