package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Movie;
import com.example.demo.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController 
{
	@Autowired
	private MovieService movieServ;
	
	
	@GetMapping
	public ResponseEntity<List<Movie>>getAllMovies()
	{
		return new ResponseEntity<List<Movie>>(movieServ.allMovies(),HttpStatus.OK);
	}


	@GetMapping("/{imdbId}")
	
		public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId)
		{
		return new ResponseEntity<Optional<Movie>>(movieServ.singleMovie(imdbId),HttpStatus.OK);
			
		}
	}

