package com.nielo.springsecurityloginform.springsecurityloginform.repository;

import com.nielo.springsecurityloginform.springsecurityloginform.model.People;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends MongoRepository<People, String> {

    Optional<People> findPeopleByEmail(String email);
}
