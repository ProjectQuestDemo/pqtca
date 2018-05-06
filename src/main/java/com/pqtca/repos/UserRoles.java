package com.pqtca.repos;

import com.pqtca.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoles extends CrudRepository<UserRole, Long> {
    @Query("SELECT urole.role FROM UserRole urole, User user WHERE user.username =?1 AND urole.userId = user.id")
    List<String> ofUserWith(String username);
}
