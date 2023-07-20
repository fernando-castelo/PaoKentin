package com.example.PaoKentin.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;


public class Pao {

    private int id;

    private String tipoPao;

    private String descricao;

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
