package com.pqtca.demo.repos;

import com.pqtca.demo.models.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepo extends CrudRepository<Application, Long> {
}
