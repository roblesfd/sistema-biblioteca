package org.fernandodev;

import java.time.LocalDateTime;
import java.util.UUID;

public class Multa {
    private String id;
    private String idUsuario;
    private String idPrestamo;
    private final int montoBase=20;
    private int montoAcumulado;
    private boolean estaPagada;
    private LocalDateTime fechaDeGeneracion; //cuando se genero la multa
    private LocalDateTime fechaDeLiquidacion; //cuando se pago la multa si es que se pago
    private MotivoMulta motivo;
    private int diasRetraso;

    // CONSTRUCTOR
    public Multa(String userId, String loanId, MotivoMulta motive, int daysLate) {
        this.id = UUID.randomUUID().toString();
        this.idUsuario = userId;
        this.idPrestamo = loanId;
        this.motivo = motive;
        this.diasRetraso = motive == MotivoMulta.RETRASO ? daysLate : 0; // Solo aplica a RETRASO
        this.montoAcumulado = calcularMontoAcumulado();
        this.estaPagada = false;
        this.fechaDeGeneracion = LocalDateTime.now();
    }


    //METODOS
    private int calcularMontoAcumulado() {
        switch(motivo) {
            case RETRASO:
                return this.montoBase + (diasRetraso + 5);
            case LIBRO_DANADO:
                return 50;
            case PERDIDA:
                return 150;
            default:
                return this.montoBase;
        }
    }

    public void pagarMulta() {
        this.estaPagada = true;
        this.fechaDeLiquidacion = LocalDateTime.now();
    }


    //GETTERS
    public String getId() {
        return id;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public int getMontoBase() {
        return montoBase;
    }

    public int getMontoAcumulado() {
        return montoAcumulado;
    }

    public boolean getEstaPagada() {
        return estaPagada;
    }

    public LocalDateTime getFechaDeGeneracion() {
        return fechaDeGeneracion;
    }

    public LocalDateTime getFechaDeLiquidacion() {
        return fechaDeLiquidacion;
    }

    public MotivoMulta getMotivo() {
        return motivo;
    }

    public int getDiasRetraso() {
        return diasRetraso;
    }


    //SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setMontoAcumulado(int montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }

    public void setEstaPagada(boolean estaPagada) {
        this.estaPagada = estaPagada;
    }

    public void setFechaDeLiquidacion(LocalDateTime fechaDeLiquidacion) {
        this.fechaDeLiquidacion = fechaDeLiquidacion;
    }

    public void setMotivo(MotivoMulta motivo) {
        this.motivo = motivo;
    }

    public void setDiasRetraso(int diasRetraso) {
        this.diasRetraso = diasRetraso;
    }
}
