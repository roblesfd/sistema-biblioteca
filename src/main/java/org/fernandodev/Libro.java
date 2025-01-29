package org.fernandodev;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    public Libro(String title, String author, String isbn, boolean isAvailable) {
        this.titulo = title;
        this.autor = author;
        this.isbn = isbn;
        this.disponible = isAvailable;
    }

    public Libro() {}

    //Getters
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getIsbn() {
        return isbn;
    }
    public boolean getDisponible() {
        return disponible;
    }

    //Setters
    public void setTitulo(String title) {
        this.titulo = title;
    }
    public void setAutor(String author) {
        this.autor = author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setDisponible(boolean isAvailable) {
        this.disponible = isAvailable;
    }

    //Metodos de clase
    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | ISBN: %s | Disponible: %s",
                titulo, autor, isbn, disponible ? "Sí" : "No"
        );
    }
}
