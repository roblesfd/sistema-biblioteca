package org.fernandodev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Biblioteca {
    private static Biblioteca instance;
    private  Collection<Libro> listaLibros;
    private  Collection<Usuario> listaUsuarios;

    private Biblioteca() {
        listaLibros = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
    }

    //Singleton para crear una instancia de Bilioteca
    public static Biblioteca getInstance() {
        if(instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }

    public void anadirLibro(Libro libro) {
        listaLibros.add(libro);
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

    public List<Libro> buscarLibrosPorISBN(String isbn){
        return listaLibros.stream()
                .filter(libro -> libro.getIsbn().equalsIgnoreCase((isbn)))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarLibrosPorAutor(String autor){
        return listaLibros.stream()
                .filter(libro -> libro.getAutor().equalsIgnoreCase((autor)))
                .collect(Collectors.toList());
    }

    public boolean eliminarLibroPorIsbn(String isbn){
        for(Libro libro: listaLibros) {
            if(libro.getIsbn().equals(isbn)) {
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

    public void buscarAutores(String autor){
        System.out.println("Autores ecnontrados: (Por implementar) ");
    }

    //Muestra autores por orden alfabetico
    public void mostrarAutores(){
        String autores = listaLibros.stream()
                .map(Libro::getAutor)
                .collect(Collectors.joining("\n"));
        if (autores.isEmpty()) {
            System.out.println("No hay autores en la biblioteca.");
        } else {
            System.out.println("=== Lista de autores ===\n" + autores);
        }
    }

    ////// METODOS PARA USUARIO ///////
    public void anadirUsuario(Usuario nuevoUsuario){
        this.listaUsuarios.add(nuevoUsuario);
    }

    public List<Usuario> obtenerListaUsuarios(){
        return new ArrayList<Usuario>(this.listaUsuarios);
    }

    public void mostrarUsuarios(){
        String result = this.listaUsuarios.stream()
                .map(Usuario::toString)
                .collect(Collectors.joining("\n"));
        if (result.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("=== Lista de Usuarios ===\n" + result);
        }
    }

    public boolean validarCamposObligatorios(List<String> campos) {
        return campos.stream()
                .anyMatch(campo -> campo == null || campo.trim().isEmpty());
    }

    public String generarUUID() {
        return UUID.randomUUID().toString();
    }
}
