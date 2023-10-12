package com.chethiya.application.dao.couchbase.repositories;


import com.chethiya.application.model.couchbase.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, String> {

    Application findByApplicationId(String applicationId);
}
