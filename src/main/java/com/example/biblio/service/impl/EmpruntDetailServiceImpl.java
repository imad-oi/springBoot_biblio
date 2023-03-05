package com.example.biblio.service.impl;

import com.example.biblio.bean.Client;
import com.example.biblio.bean.Emprunt;
import com.example.biblio.bean.EmpruntDetail;
import com.example.biblio.bean.Livre;
import com.example.biblio.dao.EmpruntDao;
import com.example.biblio.dao.EmpruntDetailDao;
import com.example.biblio.service.facade.ClientService;
import com.example.biblio.service.facade.EmpruntDetailService;
import com.example.biblio.service.facade.EmpruntService;
import com.example.biblio.service.facade.LivreService;
import com.example.biblio.service.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmpruntDetailServiceImpl implements EmpruntDetailService {
    @Autowired
    private EmpruntDetailDao empruntDetailDao;

    @Autowired
    private ClientService clientService;
    @Autowired
    private LivreService livreService;


    @Override
    public int save(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        if (validateEmpruntDetails(emprunt, empruntDetails)) {
            empruntDetails.forEach(ed -> {
                ed.setEmprunt(emprunt);
                Livre foundedLivre = livreService.findByIsbn(ed.getLivre().getIsbn()) ;
                ed.setDateRestitutionPrevu(DateUtil.addDays(emprunt.getDateEmprunt(),foundedLivre.getNombreJourEmprunt()));
                empruntDetailDao.save(ed);
            });
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean validateEmpruntDetails(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
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
}
