package com.example.PaoKentin.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;


public class Fornada {

    private int id;


   private Pao pao;


   private LocalTime inicioFornada;

   private LocalTime finalFornada;

   private Long tempoRestante;

    public Long getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(Long tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public LocalTime getFinalFornada() {
        return finalFornada;
    }

    public void setFinalFornada(LocalTime finalFornada) {
        this.finalFornada = finalFornada;
    }

    public LocalTime getInicioFornada() {
        return inicioFornada;
    }

    public void setInicioFornada(LocalTime inicioFornada) {
        this.inicioFornada = inicioFornada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pao getPao() {
        return pao;
    }

    public void setPao(Pao pao) {
        this.pao = pao;
    }
}
