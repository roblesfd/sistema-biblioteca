package org.fernandodev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatosPrueba {

    public static List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("U001", "Juan", "Pérez", "Manriquez", "Enrique Segoviano 10"));
        usuarios.add(new Usuario("U002", "María", "Gómez", "Palacios", "Atalanta de Juarez 16"));
        return usuarios;
    }

    public static List<Libro> cargarLibros() {
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro( "Cien Años de Soledad", "Gabriel García Márquez","L001", true));
        libros.add(new Libro( "1984", "George Orwell", "L002", true));
        return libros;
    }

    public static List<Prestamo> cargarPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        prestamos.add(new Prestamo("P001", "U001", "L001", LocalDateTime.now().minusDays(10), LocalDateTime.now().plusDays(5)));
        prestamos.add(new Prestamo("P001","U002", "L002",  LocalDateTime.now().minusDays(15), LocalDateTime.now().plusDays(2)));
        return prestamos;
    }

    public static List<Multa> cargarMultas() {
        List<Multa> multas = new ArrayList<>();
        multas.add(new Multa("U001", "P001", MotivoMulta.RETRASO, 10));
        return multas;
    }
}
