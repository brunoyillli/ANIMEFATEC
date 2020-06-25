package com.fatec.anime.api.repository;

import com.fatec.anime.api.model.Anime;
import org.springframework.data.repository.CrudRepository;


public interface AnimeRepository extends CrudRepository<Anime, Long> {

}
