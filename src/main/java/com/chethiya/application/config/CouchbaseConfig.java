package com.chethiya.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;


@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.chethiya.application.dao.couchbase.repositories"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "app_user";
    }

    @Override
    public String getPassword() {
        return "1s@secret";
    }

    @Override
    public String getBucketName() {
        return "application-bucket";
    }

}
