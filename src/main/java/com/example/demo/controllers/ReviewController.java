package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Review;
import com.example.demo.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController 
{
	@Autowired
	private ReviewService reviewServ;

	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload)   //converting the responsebody in map 
	{
		return new ResponseEntity<Review>(reviewServ.createReview(payload.get("reviewBody"),payload.get("imdbId")),HttpStatus.CREATED);
		
	}
}
