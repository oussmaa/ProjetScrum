package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.Leceon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LeceonRespository extends MongoRepository<Leceon, String> {


    @Query(value = "{IdChapitre:?0}")
    List<Leceon> findByIdChapitre(String IdChapitre);


}
