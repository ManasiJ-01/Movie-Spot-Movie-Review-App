package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Movie;
import com.example.demo.repositories.MovieRepository;

@Service
public class MovieService 
{
	@Autowired
	private MovieRepository movieRepo;
	
	public List<Movie> allMovies()
	{
		
		return movieRepo.findAll();
	}
	
	public Optional<Movie> singleMovie(String imdbId)
	{
		return movieRepo.findMovieByImdbId(imdbId);                   // if id doesnt exist then it may return null hence used Optional
	}

}
