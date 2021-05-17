package com.istrateties.tech.movierental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.istrateties.tech.movierental.entity.MovieEntity;
import com.istrateties.tech.movierental.service.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {
	
	@Autowired
	MovieService service;

	@GetMapping
	public ResponseEntity<List<MovieEntity>> getAllMovies(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int limit,
			@RequestParam(defaultValue = "id") String sortBy){
		
		List<MovieEntity> listOfMovies = service.getAllMovies(page, limit, sortBy);
		
		return new ResponseEntity<List<MovieEntity>>(listOfMovies, new HttpHeaders(), HttpStatus.OK);
	}
	
	
}
