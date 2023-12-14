package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.Blog;

import com.pfe.pfeoussama.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BlogRespository extends MongoRepository<Blog, String> {



    @Query(value = "{IdUser:?0}")
    List<Blog> findByIdUser(String IdUser);

}
