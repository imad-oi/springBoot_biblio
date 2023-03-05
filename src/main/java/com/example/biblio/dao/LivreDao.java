package com.example.biblio.dao;

import com.example.biblio.bean.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreDao extends JpaRepository<Livre, Long> {
    Livre findByIsbn(String isbn);
}
