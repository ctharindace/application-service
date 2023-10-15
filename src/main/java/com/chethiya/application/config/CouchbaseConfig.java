package com.chethiya.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;


@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.chethiya.application.dao.couchbase.repositories"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Autowired
    ConfigurableEnvironment env;

    @Override
    public String getBucketName() {
        return env.getProperty("spring.couchbase.bucket-name");
    }

    @Override
    public String getConnectionString() {
        return env.getProperty("spring.couchbase.connection-string");
    }

    @Override
    public String getUserName() {
        return env.getProperty("spring.couchbase.user-name");
    }

    @Override
    public String getPassword() {
        return env.getProperty("spring.couchbase.password");
    }
}