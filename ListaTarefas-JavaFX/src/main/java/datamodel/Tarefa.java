package datamodel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarefa {
    private String descripcion;
    private String detalles;
    private LocalDate dataLimite;

    public Tarefa() {
    }

    public Tarefa(String descripcion, String detalles, LocalDate dataLimite) {
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.dataLimite = dataLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
