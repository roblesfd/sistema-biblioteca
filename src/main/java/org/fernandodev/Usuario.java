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

    //Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public boolean getTieneMulta() {
        return tieneMulta;
    }

    //Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public void setTieneMulta(boolean tieneMulta) {
        this.tieneMulta = tieneMulta;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %s | Apellidos: %s | Dirección: %s | Libros prestados: %s | Tiene multa: %s",
                id, nombre, apellidoPaterno  + " " + apellidoMaterno, direccion, librosPrestados, tieneMulta ? "Si" : "No"
        );
    }
}
