package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.Blog;
import com.pfe.pfeoussama.models.Message;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessageRespository   extends MongoRepository<Message, String> {




    @Query(value = "{room:?0}")
    List<Message> findByRoom(String room);

    @Query(value = "{idsend:?0}")
    List<Message> findByIdsend(String idsend);



    @Query(value = "{username:?0}")
    List<Message> findByUsername(String username);
}
