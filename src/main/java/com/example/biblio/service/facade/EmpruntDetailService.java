package com.example.biblio.service.facade;

import com.example.biblio.bean.Client;
import com.example.biblio.bean.Emprunt;
import com.example.biblio.bean.EmpruntDetail;

import java.util.Date;
import java.util.List;

public interface EmpruntDetailService {
    int save(Emprunt emprunt, List<EmpruntDetail> empruntDetails);
     boolean validateEmpruntDetails(Emprunt emprunt, List<EmpruntDetail> empruntDetails)  ;
}
