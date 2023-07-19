package com.example.PaoKentin.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;


public class Pao {

    private int id;

    public Pao(String tipoPao, String descricao, int tempoPreparo) {
        this.tipoPao = tipoPao;
        this.descricao = descricao;
        this.tempoPreparo = tempoPreparo;
    }


    private String tipoPao;


    private String descricao;

    private int tempoPreparo;


   private List<Fornada> fornadas;

    public Pao() {

    }

    public List<Fornada> getFornadas() {
        return fornadas;
    }

    public void setFornadas(List<Fornada> fornadas) {
        this.fornadas = fornadas;
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
