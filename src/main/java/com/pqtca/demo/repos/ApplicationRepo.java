package com.pqtca.demo.repos;

import com.pqtca.demo.models.Application;
import com.pqtca.demo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepo extends CrudRepository<Application, Long> {
    List<Application> findAll();

    Application findBy(User user);

    @Override
    Application findOne(Long aLong);
}
