package com.pqtca.repos;

<<<<<<< HEAD:src/main/java/com/pqtca/repos/ApplicationRepo.java
import com.pqtca.models.Application;
import com.pqtca.models.User;
=======
import com.pqtca.demo.models.Application;
import com.pqtca.demo.models.User;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.data.jpa.repository.Query;
>>>>>>> allies:src/main/java/com/pqtca/demo/repos/ApplicationRepo.java
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.List;

public interface ApplicationRepo extends CrudRepository<Application, Long> {
    List<Application> findAll();

    Application findBy(User user);

    @Override
    Application findOne(Long aLong);

    Long countByEthnicity(String ethnicity);

    Long countByCity(String city);
//    TODO will work whenever education is added into the application table.
}
