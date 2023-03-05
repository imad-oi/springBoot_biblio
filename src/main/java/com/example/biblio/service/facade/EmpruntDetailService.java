package com.example.biblio.service.facade;

import com.example.biblio.bean.Emprunt;

import java.util.Date;
import java.util.List;

public interface EmpruntService {
    List<Emprunt> findAll();

    Emprunt findByReference(String reference);

    int save(Emprunt emprunt);

    int restituer(String reference , Date dateRestitutioEffective) ;

}
