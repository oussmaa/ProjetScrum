package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.SalonDisscussion;
 import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalonDisscussionRespository extends MongoRepository<SalonDisscussion, String> {
}
