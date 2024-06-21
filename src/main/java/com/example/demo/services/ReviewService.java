package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.Movie;
import com.example.demo.Review;
import com.example.demo.repositories.ReviewRepository;

@Service
public class ReviewService 
{
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public Review createReview(String reviewBody, String imdbId)
	{
		Review review = new Review(reviewBody);
		reviewRepo.insert(review);
		
		
		mongoTemplate.update(Movie.class)
			.matching(Criteria.where("imdbId").is(imdbId))
			.apply(new Update().push("reviewIds").value(review))
			.first();
		
		return review;
	}
}
