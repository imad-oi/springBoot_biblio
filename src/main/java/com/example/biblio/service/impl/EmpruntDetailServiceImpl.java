package com.example.biblio.service.impl;

import com.example.biblio.bean.Client;
import com.example.biblio.bean.Emprunt;
import com.example.biblio.bean.EmpruntDetail;
import com.example.biblio.bean.Livre;
import com.example.biblio.dao.EmpruntDao;
import com.example.biblio.service.facade.ClientService;
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

        if (emprunt != null) {
            return -1;
        } else if (client == null) {
            return -2;
        } else if (client.getPointFiabilite() < 5) {
            return -4;
        } else if (!validateEmpruntDetails(emprunt, empruntDetails)) {
            return -5;
        } else {
            emprunt.setClient(client);
            //emprunt.setDateRestitutionEffective(null);

            emprunt.setDateEmprunt(new Date());
            // emprunt.setDateRestitutionPrevu(DateUtil.addDays(emprunt.getDateEmprunt(), livre.getNombreJourEmprunt()));
            empruntDao.save(emprunt);
            return 1;
        }
    }

    private boolean validateEmpruntDetails(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        List<Livre> valideLivres = new ArrayList<>();
        for (EmpruntDetail ed : empruntDetails
        ) {
            Livre livre = livreService.findByIsbn(ed.getLivre().getIsbn());
            if (livre != null) {
                valideLivres.add(livre);
            }
        }
        return valideLivres.size() == empruntDetails.size();
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
