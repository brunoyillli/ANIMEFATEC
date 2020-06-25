package com.fatec.anime.api.dao;

import com.fatec.anime.api.model.Anime;
import com.fatec.anime.api.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeDao {
	
	@Autowired
	private AnimeRepository repository;
	
	public Iterable<Anime> obterTodos(){
		
		Iterable<Anime> anime = repository.findAll();
		
		return anime;
		
	}

	public void salvar(Anime anime){
		repository.save(anime);
	}
	
}