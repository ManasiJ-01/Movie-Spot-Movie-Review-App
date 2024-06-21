package com.example.demo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Review;


@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId>
{

}
