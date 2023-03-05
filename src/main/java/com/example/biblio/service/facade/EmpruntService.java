package com.example.biblio.service.facade;

import com.example.biblio.bean.Emprunt;
import com.example.biblio.bean.EmpruntDetail;

import java.util.Date;
import java.util.List;

public interface EmpruntService {
    List<Emprunt> findAll();

    Emprunt findByReference(String reference);


    int save(Emprunt emprunt, List<EmpruntDetail> empruntDetails);

    int restituer(String reference, Date dateRestitutioEffective);

}
