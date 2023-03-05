package com.example.biblio.service.impl;

import com.example.biblio.bean.Client;
import com.example.biblio.bean.Emprunt;
import com.example.biblio.bean.EmpruntDetail;
import com.example.biblio.bean.Livre;
import com.example.biblio.dao.EmpruntDao;
import com.example.biblio.service.facade.ClientService;
import com.example.biblio.service.facade.EmpruntDetailService;
import com.example.biblio.service.facade.EmpruntService;
import com.example.biblio.service.facade.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmpruntServiceImpl implements EmpruntService {
    @Autowired
    private EmpruntDao empruntDao;
    @Autowired
    private LivreService livreService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private EmpruntDetailService empruntDetailService;

    @Override
    public List<Emprunt> findAll() {
        return empruntDao.findAll();
    }

    @Override
    public Emprunt findByReference(String reference) {
        return empruntDao.findByReference(reference);
    }

    @Override
    public int save(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        Emprunt foundedEmprunt = findByReference(emprunt.getReference());
        Client client = clientService.findByCin(emprunt.getClient().getCin());

        if (foundedEmprunt != null) {
            return -1;
        } else if (client == null) {
            return -2;
        } else if (client.getPointFiabilite() < 5) {
            return -4;
        } else if (!empruntDetailService.validateEmpruntDetails(emprunt, empruntDetails)) {
            return -5;
        } else {
            emprunt.setClient(client);
            emprunt.setDateEmprunt(new Date());
            empruntDao.save(emprunt);
            empruntDetailService.save(emprunt, empruntDetails);
            return 1;
        }
    }

    @Override
    public int restituer(String reference, Date dateRestitutioEffective) {
        Emprunt emprunt = findByReference(reference);
        if (emprunt.getDateRestitutionEffective() != null) {
            return -1;
        } else if (emprunt == null) {
            return -2;
        } else {
            emprunt.setDateRestitutionEffective(dateRestitutioEffective);
            empruntDao.save(emprunt);
            return 1;
        }

    }
}
