package com.pfe.pfeoussama.repository;

 import com.pfe.pfeoussama.models.Metting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeetingRespository extends MongoRepository<Metting, String> {
}
