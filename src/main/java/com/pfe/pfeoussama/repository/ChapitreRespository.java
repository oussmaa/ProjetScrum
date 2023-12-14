package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.Chapitre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface ChapitreRespository extends MongoRepository<Chapitre, String>  {


    @Query(value = "{IdFormation:?0}")
    List<Chapitre> findByIdFormation(String IdFormation);
}
