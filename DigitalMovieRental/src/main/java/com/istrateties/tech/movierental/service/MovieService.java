package com.istrateties.tech.movierental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.istrateties.tech.movierental.entity.MovieEntity;
import com.istrateties.tech.movierental.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	
	public List<MovieEntity> getAllMovies(int page, int limit, String sortBy){
		
		Pageable paging = PageRequest.of(page, limit, Sort.by(sortBy).ascending());
		
		Page<MovieEntity> pagedResult = movieRepository.findAll(paging);
		
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<MovieEntity>();
		}
		
	}

}
