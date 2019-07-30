package com.desafiouno.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RptServicio implements Serializable {


    private String id;
    private String fechaCreacion;
    private String fechaFin;
    private String fechas[];
    private List<String>   fechasFaltantes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String[] getFechas() {
        return fechas;
    }

    public void setFechas(String[] fechas) {
        this.fechas = fechas;
    }

    public List<String> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setFechasFaltantes(List<String> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }
}
