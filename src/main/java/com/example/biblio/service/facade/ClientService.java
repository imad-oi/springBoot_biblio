package com.example.biblio.service.facade;

import com.example.biblio.bean.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findByCin(String cin);

    int save(Client client);

    List<Client> findByFiabilite();
    List<Client> findNonFialble() ;

    List<Client> findByPointFiabilite(int pointFiabilite);

}
