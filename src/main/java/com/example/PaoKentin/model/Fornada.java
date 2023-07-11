package com.example.PaoKentin.model;

import jakarta.persistence.*;

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
