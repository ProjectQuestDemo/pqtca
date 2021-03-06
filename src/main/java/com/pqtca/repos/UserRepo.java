package com.pqtca.repos;

import com.pqtca.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}
