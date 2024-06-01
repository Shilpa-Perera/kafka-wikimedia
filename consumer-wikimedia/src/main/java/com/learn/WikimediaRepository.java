package com.learn;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends MongoRepository<WikimediaEntity,String> {
    }
