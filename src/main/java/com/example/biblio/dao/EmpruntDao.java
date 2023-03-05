package com.example.biblio.dao;

import com.example.biblio.bean.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntDao extends JpaRepository<Emprunt, Long> {
    Emprunt findByReference(String reference);

}
