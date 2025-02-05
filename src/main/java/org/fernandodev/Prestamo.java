package org.fernandodev;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

public class Prestamo {
    public String id;
    public String usuarioID;
    public Libro libroPrestado;
    public LocalDateTime fechaDePrestamo;
    public LocalDateTime fechaDeEntrega;
    public boolean devueltoATiempo;

    public Prestamo(String userId, Libro borrrowedBook, LocalDateTime borrowingDate, LocalDateTime returnDate ){
        id = UUID.randomUUID().toString();
        usuarioID = userId;
        libroPrestado = borrrowedBook;
        fechaDePrestamo = borrowingDate;
        fechaDeEntrega = returnDate;
    }

    //GETTERS
    public String getId() {
        return id;
    }

    public String getUsuarioID() {
        return usuarioID;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public LocalDateTime getFechaDePrestamo() {
        return fechaDePrestamo;
    }

    public LocalDateTime getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public boolean getDevueltoATiempo() {
        return devueltoATiempo;
    }

    //SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setUsuarioID(String usuarioID) {
        this.usuarioID = usuarioID;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public void setFechaDePrestamo(LocalDateTime fechaDePrestamo) {
        this.fechaDePrestamo = fechaDePrestamo;
    }

    public void setFechaDeEntrega(LocalDateTime fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    public void setDevueltoATiempo(boolean devueltoATiempo) {
        this.devueltoATiempo = devueltoATiempo;
    }
}
