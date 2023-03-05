package com.example.biblio.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private  String cin ;
    private  int pointFiabilite ;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getPointFiabilite() {
        return pointFiabilite;
    }

    public void setPointFiabilite(int pointFiabilite) {
        this.pointFiabilite = pointFiabilite;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
