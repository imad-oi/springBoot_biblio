package com.example.biblio.service.impl;

import com.example.biblio.bean.Client;
import com.example.biblio.dao.ClientDao;
import com.example.biblio.service.facade.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findByCin(String cin) {
        return clientDao.findByCin(cin);
    }

    @Override
    public int save(Client client) {
        Client foundedClient = findByCin(client.getCin());
        if (foundedClient != null) {
            return -1;
        } else {
            clientDao.save(client);
            return 1;
        }
    }


    @Override
    public List<Client> findByFiabilite() {
        return null;
    }

    @Override
    public List<Client> findNonFialble() {
        List<Client> clients = findAll();
        List<Client> res = new ArrayList<>();

        for (Client client : clients
        ) {
            if (client.getPointFiabilite() < 5) {
                res.add(client);
            }
        }
        return res;
    }

    @Override
    public List<Client> findByPointFiabilite(int pointFiabilite) {
        return clientDao.findByPointFiabilite(pointFiabilite);
    }
}
