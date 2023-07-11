package com.example.PaoKentin.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "fornada")
public class Fornada {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private int id;

   @ManyToOne
   @JoinColumn(name="pao_id", referencedColumnName = "id")
   private Pao pao;

   @Column(name = "inicio_fornada")
   private LocalTime inicioFornada;

   @Column(name = "final_fornada")
   private LocalTime finalFornada;

   @Column(name = "tempo_restante")
   private Long tempoRestante;

    public Long getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(Long tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    @Column(name = "status_fornada")
   private StatusFornada status = StatusFornada.EM_PREPARO;

    public StatusFornada getStatus() {
        return status;
    }

    public void setStatus(StatusFornada status) {
        this.status = status;
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
