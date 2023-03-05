package com.example.biblio.dao;

import com.example.biblio.bean.EmpruntDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntDetailDao extends JpaRepository<EmpruntDetail, Long > {

}
