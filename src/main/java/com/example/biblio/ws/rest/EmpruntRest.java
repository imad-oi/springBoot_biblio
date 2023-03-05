package com.example.biblio.ws.rest;

import com.example.biblio.bean.Emprunt;
import com.example.biblio.bean.EmpruntDetail;
import com.example.biblio.service.facade.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/biblio/emprunt")
public class EmpruntRest {

    @Autowired
    private EmpruntService empruntService;

    @GetMapping("/")
    public List<Emprunt> findAll() {
        return empruntService.findAll();
    }

    @GetMapping("/reference/{reference}")
    public Emprunt findByReference(@PathVariable String reference) {
        return empruntService.findByReference(reference);
    }

    @PostMapping("/")
    public int save(@RequestBody Emprunt emprunt) {
        return empruntService.save(emprunt, emprunt.getEmpruntDetails());
    }

    @PutMapping("/reference/{ref}/dateRestitutioEffective/{dateRestitutioEffective}")
    public int restituer(@PathVariable String reference, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateRestitutioEffective) {
        return empruntService.restituer(reference, dateRestitutioEffective);
    }
}
