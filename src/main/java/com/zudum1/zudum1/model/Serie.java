package com.zudum1.zudum1.model;

import jakarta.persistence.*;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tituloOriginal;

    private String tituloLatam;

    @Column(length = 500)
    private String descripcion = "Profe Vicente, esto lo daré en la evaluación 3";

    public Serie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTituloLatam() {
        return tituloLatam;
    }

    public void setTituloLatam(String tituloLatam) {
        this.tituloLatam = tituloLatam;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
