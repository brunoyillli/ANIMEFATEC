package com.fatec.anime.api.repository;

import com.fatec.anime.api.model.Anime;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface AnimeRepository extends CrudRepository<Anime, Long>{
	Set<Anime> findByStatus(String status);
	
	@Query("SELECT a FROM Anime a WHERE a.name LIKE :name%")
	Set<Anime> searchByNome(@Param("name")String name);
}
