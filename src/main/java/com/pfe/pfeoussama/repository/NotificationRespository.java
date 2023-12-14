package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRespository extends MongoRepository<Notification, String> {
}
