package org.fernandodev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GestionLibros extends Biblioteca{
    private Collection<Libro> listaLibros;

    public GestionLibros() {
        super();
        listaLibros = new ArrayList<>();
    }

    public void anadirLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public Libro buscarLibroPorISBN(String isbn){
        List<Libro> resultados =  listaLibros.stream()
                .filter(libro -> libro.getIsbn().equalsIgnoreCase((isbn)))
                .toList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo){
        List<Libro> resultados = new ArrayList<>();
        for(Libro libro: listaLibros) {
            if(libro.getTitulo().equals(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarLibrosPorAutor(String autor){
        return listaLibros.stream()
                .filter(libro -> libro.getAutor().equalsIgnoreCase((autor)))
                .collect(Collectors.toList());
    }

    public boolean eliminarLibroPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                listaLibros.remove(libro);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarLibroPorTitulo(String titulo){
        for(Libro libro: listaLibros) {
            if(libro.getTitulo().equals(titulo)) {
                listaLibros.remove(libro);
                return true;
            }
            System.out.println(libro);
        }
        return false;
    }

    public boolean eliminarLibrosPorAutor(String autor) {
        boolean alMenosUnoEliminado = false;
        var iterador = listaLibros.iterator();
        while (iterador.hasNext()) {
            Libro libro = iterador.next();
            if (libro.getAutor().equals(autor)) {
                iterador.remove();
                alMenosUnoEliminado = true;
                System.out.println(libro);
            }
        }
        return alMenosUnoEliminado;
    }

    public List<Libro> obtenerListaLibros(){
        return new ArrayList<Libro>(listaLibros);
    }

    public void mostrarLibros(){
        String result = listaLibros.stream()
                .map(Libro::toString)
                .collect(Collectors.joining("\n"));
        if (result.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("=== Lista de Libros ===\n" + result);
        }
    }

    public void mostrarLibrosPorTitulo(String titulo){
        String result = listaLibros.stream()
                .filter(libro -> libro.getTitulo().equals(titulo))
                .map(Libro::toString)
                .collect(Collectors.joining("\n"));
        if (result.isEmpty()) {
            System.out.println("No hay libros con el título " + titulo);
        } else {
            System.out.println("=== Lista de Libros ===\n" + result);
        }
    }

    public void mostrarLibrosPorAutor(String autor){
        String result = listaLibros.stream()
                .filter(libro -> libro.getAutor().equals(autor))
                .map(Libro::toString)
                .collect(Collectors.joining("\n"));
        if (result.isEmpty()) {
            System.out.println("No hay libros del autor " + autor);
        } else {
            System.out.println("=== Lista de Libros ===\n" + result);
        }
    }

}
