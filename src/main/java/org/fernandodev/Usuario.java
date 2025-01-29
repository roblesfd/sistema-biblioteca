package org.fernandodev;

import java.util.ArrayList;
import java.util.UUID;

public class Usuario {
    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private ArrayList<Libro> librosPrestados;
    private boolean tieneMulta = false;

    public Usuario(String name, String firstLastname, String secondLastName, String address) {
        id = UUID.randomUUID().toString();
        nombre = name;
        apellidoPaterno = firstLastname;
        apellidoMaterno = secondLastName;
        direccion = address;
        librosPrestados = new ArrayList<>();
    }

    public Usuario anadirNuevo(String name, String firstLastname, String secondLastName, String address) {
        return new Usuario( name, firstLastname, secondLastName, address);
    }
    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %s | Apellidos: %s | Dirección: %s | Libros prestados: %s | Tiene multa: %s",
                id, nombre, apellidoPaterno  + " " + apellidoMaterno, direccion, librosPrestados, tieneMulta ? "Si" : "No"
        );
    }

    //public boolean eliminarPorId(String id) {
    //
    //    }

//    public void prestarLibro(ArrayList<Libro> librosAPrestar) {
//        if(debeLibros) {
//           System.out.println("Este usuario debe libros, prestamo cancelado");
//        }else{
//            for(Libro libro: librosAPrestar) {
//                if(!this.tieneLibro(libro.getIsbn())) {
//                    librosPrestados.add(libro);
//                }
//            }
//        }
//    }

//    public boolean tieneLibro (String isbn) {
//        for (Libro libro: librosPrestados) {
//            if(libro.getIsbn().equals(isbn)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
