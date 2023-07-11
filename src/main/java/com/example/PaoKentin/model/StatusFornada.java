package com.example.PaoKentin.model;

public enum StatusFornada {

    PRONTO("Pronto"), EM_PREPARO("Em preparo");

    private String texto;

    StatusFornada(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
