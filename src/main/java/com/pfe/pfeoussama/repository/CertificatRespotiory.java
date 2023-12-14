package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.Blog;
import com.pfe.pfeoussama.models.Certifica;
import com.pfe.pfeoussama.models.Chapitre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CertificatRespotiory extends MongoRepository<Certifica, String> {


    @Query(value = "{IdUser:?0}")
    List<Certifica> findByIdUser(String IdUser);


}
