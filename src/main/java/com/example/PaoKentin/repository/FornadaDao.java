package com.example.PaoKentin.repository;

import com.example.PaoKentin.model.Fornada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornadaDao extends CrudRepository<Fornada, Integer> {
}
