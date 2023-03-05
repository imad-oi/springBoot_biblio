package com.example.biblio.bean;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateEmprunt;
    @Temporal(TemporalType.DATE)
    private Date dateRestitutionPrevu;
    @Temporal(TemporalType.DATE)
    private Date dateRestitutionEffective;
    private String reference;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "emprunt")
    private List<EmpruntDetail> empruntDetails;

    public List<EmpruntDetail> getEmpruntDetails() {
        return empruntDetails;
    }

    public void setEmpruntDetails(List<EmpruntDetail> empruntDetails) {
        this.empruntDetails = empruntDetails;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRestitutionPrevu() {
        return dateRestitutionPrevu;
    }

    public void setDateRestitutionPrevu(Date dateRestitutionPrevu) {
        this.dateRestitutionPrevu = dateRestitutionPrevu;
    }

    public Date getDateRestitutionEffective() {
        return dateRestitutionEffective;
    }

    public void setDateRestitutionEffective(Date dateRestitutionEffective) {
        this.dateRestitutionEffective = dateRestitutionEffective;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
