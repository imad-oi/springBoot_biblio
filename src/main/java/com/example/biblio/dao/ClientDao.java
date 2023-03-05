package com.example.biblio.dao;

import com.example.biblio.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
    Client findByCin(String cin);

    List<Client> findByPointFiabilite(int pointFiabilite);
}
