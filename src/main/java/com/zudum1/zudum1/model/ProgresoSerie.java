package com.zudum1.zudum1.model;

import jakarta.persistence.*;

@Entity
public class ProgresoSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie;

    private Integer temporadaActual;
    private Integer episodioActual;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public ProgresoSerie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Integer getTemporadaActual() {
        return temporadaActual;
    }

    public void setTemporadaActual(Integer temporadaActual) {
        this.temporadaActual = temporadaActual;
    }

    public Integer getEpisodioActual() {
        return episodioActual;
    }

    public void setEpisodioActual(Integer episodioActual) {
        this.episodioActual = episodioActual;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // 🔹 Enum 4 estados de ZUDUM
    public enum Estado {
        VIENDO,
        TERMINADA,
        CONGELADA,
        DESEO_VER
    }
}
