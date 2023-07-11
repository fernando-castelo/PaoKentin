package com.example.PaoKentin.service;

import com.example.PaoKentin.model.Pao;
import com.example.PaoKentin.repository.PaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PaoService {

    @Autowired
    private PaoDao paoDao;

    public void createPao(String tipoPao, String descricao, int tempoPreparo) {

        Pao pao = new Pao(tipoPao, descricao, tempoPreparo);

        paoDao.save(pao);
    }

    public boolean checkIfPaoIsNull(int id) {

        Optional<Pao> pao = paoDao.findById(id);

        if(pao.isPresent()) {
            return true;
        }

        return false;
    }

    public void deletePao(int id) {
        if(checkIfPaoIsNull(id)) {
            paoDao.deleteById(id);
        }
    }

    public Optional<Pao> getPao(int id)  {
        if(checkIfPaoIsNull(id)) {
            return paoDao.findById(id);
        }
        return null;
    }



    public Iterable<Pao> getPaes() {
        Iterable<Pao> paes = paoDao.findAll();
        return paes;
    }
}
