package org.fernandodev;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionMultas extends Biblioteca{
    private List<Multa> listaMultas;

    public GestionMultas() {
        super();
        listaMultas = new ArrayList<>();
    }

    //METODOS AÑADIR
    public void anadirMulta(Multa nuevaMulta){
        listaMultas.add(nuevaMulta);
    }

    //METODOS BUSCAR
    public Multa buscarMultaPorId(String id){
        List<Multa> resultados =  listaMultas.stream()
                .filter(multa -> multa.getId().equalsIgnoreCase((id)))
                .toList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public List<Multa> buscarMultasPorIdUsuario(String idUsuario){
        List<Multa> resultados = new ArrayList<>();
        for(Multa multa: listaMultas) {
            if(multa.getIdUsuario().equals(idUsuario)) {
                resultados.add(multa);
            }
        }
        return resultados;
    }

    public List<Multa> buscarMultasPorFecha(String fechaABuscar){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("dd-MM-yyyy"));
        LocalDate inicio = LocalDate.parse(fechaABuscar, formatter);

        return listaMultas.stream()
                .filter(multa ->
                        multa.getFechaDeGeneracion().toLocalDate().isEqual(inicio))
                .collect((Collectors.toList()));
    }

    //METODOS ELIMINAR
    public boolean eliminarMultaPorId(String idMulta){
        for (Multa multa : listaMultas) {
            if (multa.getId().equals(idMulta)) {
                listaMultas.remove(multa);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarMultasPorIdUsuario(String idUsuario){
        boolean alMenosUnoEliminado=false;
        for (Multa prestamo : listaMultas) {
            if (prestamo.getIdUsuario().equals(idUsuario)) {
                listaMultas.remove(prestamo);
                alMenosUnoEliminado =  true;
            }
        }
        return alMenosUnoEliminado;
    }

    //Elimina todas las multas registradas
    public void eliminarMultas(){
        listaMultas.clear();
    }

    //METODOS MOSTRAR
    public List<Multa> obtenerMultasVigentes(){

        return listaMultas.stream()
                .filter(Multa::getEstaPagada)
                .collect(Collectors.toList());
    }

    //Obtiene las multas dentro de una ventana de tiempo de 2 semana
    public List<Multa> obtenerMultasRecientes(){
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaSemanaAnterior = fechaActual.minusWeeks(2);

        return listaMultas.stream()
                .filter(multa ->
                        multa.getFechaDeGeneracion().isAfter(fechaSemanaAnterior)
                )
                .collect(Collectors.toList());
    }

    public List<Multa> obtenerMultas(){
        return listaMultas;
    }
}
