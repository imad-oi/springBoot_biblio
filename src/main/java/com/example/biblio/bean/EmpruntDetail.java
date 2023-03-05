package com.example.biblio.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class EmpruntDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateRestitutionPrevu;
    @Temporal(TemporalType.DATE)
    private Date dateRestitutionEffective;
    @ManyToOne
    private Emprunt emprunt ;
    @ManyToOne
    private Livre livre  ;
    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRestitutionEffective() {
        return dateRestitutionEffective;
    }

    public void setDateRestitutionEffective(Date dateRestitutionEffective) {
        this.dateRestitutionEffective = dateRestitutionEffective;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Date getDateRestitutionPrevu() {
        return dateRestitutionPrevu;
    }

    public void setDateRestitutionPrevu(Date dateRestitutionPrevu) {
        this.dateRestitutionPrevu = dateRestitutionPrevu;
    }

    public Long getId() {
        return id;
    }
}
