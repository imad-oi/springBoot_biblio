package com.example.biblio.service.impl;

import com.example.biblio.bean.Livre;
import com.example.biblio.dao.LivreDao;
import com.example.biblio.service.facade.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivreServiceImpl implements LivreService {
    @Autowired
    private LivreDao livreDao ;

    @Override
    public List<Livre> findAll() {
        return livreDao.findAll() ;
    }

    @Override
    public Livre findByIsbn(String isbn) {
        return livreDao.findByIsbn(isbn);
    }

    @Override
    public int save(Livre livre) {
        Livre foundedLivre = findByIsbn(livre.getIsbn()) ;
        if(livre != null){
            return  -1  ;
        } else {
            livreDao.save(livre) ;
            return 1 ;         }
    }
}
