package com.example.biblio.service.facade;

import com.example.biblio.bean.Client;
import com.example.biblio.bean.Livre;

import java.util.List;

public interface LivreService {
    List<Livre> findAll();

    Livre findByIsbn(String isbn);

    int save(Livre livre);
}
