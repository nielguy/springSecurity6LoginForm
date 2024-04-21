package com.nielo.springsecurityloginform.springsecurityloginform.repository;

import com.nielo.springsecurityloginform.springsecurityloginform.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
}
