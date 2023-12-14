package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.FixDate;
import com.pfe.pfeoussama.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FixDateRespository extends MongoRepository<FixDate, String> {


    @Query(value = "{IdFormateur:?0}")
    List<FixDate> findByIdFormateur(String IdFormateur);
}
