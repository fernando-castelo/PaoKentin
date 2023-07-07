package com.example.PaoKentin.model;

import jakarta.persistence.*;

import java.time.LocalTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "pao")
public class Pao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private  int id;

    @Column(name = "tipo_pao")
    private String tipoPao;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tempo_preparo")
    private LocalTime tempoPreparo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPao() {
        return tipoPao;
    }

    public void setTipoPao(String tipoPao) {
        this.tipoPao = tipoPao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalTime getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(LocalTime tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
}
