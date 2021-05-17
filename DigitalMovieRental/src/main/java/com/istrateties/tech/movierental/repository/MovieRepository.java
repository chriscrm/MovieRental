package com.istrateties.tech.movierental.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.istrateties.tech.movierental.entity.MovieEntity;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<MovieEntity, Long>{
	MovieEntity findByTitle(String title);
}
