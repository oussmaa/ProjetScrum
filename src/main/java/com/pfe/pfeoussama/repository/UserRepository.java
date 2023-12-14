package com.pfe.pfeoussama.repository;


import com.pfe.pfeoussama.models.Leceon;
import com.pfe.pfeoussama.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByUsername(String username);


  @Query(value = "{Email:?0}")
  Optional<User> findByEmail(String email);

  Boolean existsByUsername(String username);


  @Override
  List<User> findAll();




  Boolean existsByEmail(String email);

  @Query(value = "{Roles:?0}")
  List<User> findByRoles(String Roles);




}
