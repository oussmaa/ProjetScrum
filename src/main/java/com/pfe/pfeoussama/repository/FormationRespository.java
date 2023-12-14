package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.Fomation;
import com.pfe.pfeoussama.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FormationRespository extends MongoRepository<Fomation, String> {
    @Override
    List<Fomation> findAll();
}
