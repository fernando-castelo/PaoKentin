package com.example.PaoKentin.service;

import com.example.PaoKentin.model.Fornada;
import com.example.PaoKentin.repository.FornadaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class FornadaService {

    @Autowired
    private FornadaDao fornadaDao;

    public void createFornada(Fornada fornada) {

        fornadaDao.save(fornada);
    }

    public boolean checkIfFornadaIsNull(int id) {

        Optional<Fornada> fornada = fornadaDao.findById(id);

        if(fornada.isPresent()) {
            return false;
        }

        return false;
    }

    public void deleteFornada(int id) {
        if(checkIfFornadaIsNull(id)) {
            fornadaDao.deleteById(id);
        }
    }

    public Optional<Fornada> getFornada(int id) {
        if(checkIfFornadaIsNull(id)) {
            return fornadaDao.findById(id);
        }

        return null;
    }

    public Iterable<Fornada> getFornada() {
        Iterable<Fornada> fornadas = fornadaDao.findAll();
        return fornadas;
    }
}
