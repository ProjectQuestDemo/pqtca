package com.pqtca.demo.repos;

import com.pqtca.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
