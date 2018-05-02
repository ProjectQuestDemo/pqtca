package com.pqtca.repos;

import com.pqtca.models.Application;
import com.pqtca.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepo extends CrudRepository<Application, Long> {
    List<Application> findAll();

    Application findBy(User user);

    @Override
    Application findOne(Long aLong);

    Long countByAEthnicity(String aEthnicity);

    Long countByBCity(String bCity);
//    TODO will work whenever education is added into the application table.
}
