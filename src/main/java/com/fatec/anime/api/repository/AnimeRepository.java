package com.fatec.anime.api.repository;

import com.fatec.anime.api.model.Anime;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
import org.springframework.data.repository.query.Param;
>>>>>>> ba067d5d59d36a2f49c057cb470022fe77ed8875

@Repository
public interface AnimeRepository extends CrudRepository<Anime, Long>{
	Set<Anime> findByStatus(String status);
	
	@Query("SELECT a FROM Anime a WHERE a.name LIKE :name%")
	Set<Anime> searchByNome(@Param("name")String name);
}
