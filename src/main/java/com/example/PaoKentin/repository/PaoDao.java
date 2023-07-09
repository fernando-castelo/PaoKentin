package com.example.PaoKentin.repository;

import com.example.PaoKentin.model.Pao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaoDao extends CrudRepository<Pao, Integer> {
}
