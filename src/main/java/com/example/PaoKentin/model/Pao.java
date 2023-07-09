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
    private int id;



    public Pao(String tipoPao, String descricao, int tempoPreparo) {
        this.tipoPao = tipoPao;
        this.descricao = descricao;
        this.tempoPreparo = tempoPreparo;
    }

    @Column(name = "tipo_pao")
    private String tipoPao;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tempo_preparo")
    private int tempoPreparo;

    public Pao() {

    }

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

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
}
