package com.fatec.anime.api.dao;

import com.fatec.anime.api.model.Anime;
import com.fatec.anime.api.repository.AnimeRepository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeDao {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private AnimeRepository repository;
	
	public Iterable<Anime> obterTodos(){
		
		Iterable<Anime> anime = repository.findAll();
		return anime;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Anime> getAnimesTop(){
		return em.createNamedStoredProcedureQuery("firstProcedure").getResultList();
	}
	
	
	public Set<Anime> findByStatus(String nome) {
		return repository.findByStatus(nome);
	}

	public void salvar(Anime anime){
		repository.save(anime);
	}
	
	public Anime get(Long id) {
		return repository.findById(id).get();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Set<Anime> searchByNome(String name) {
		return repository.searchByNome(name);
	}

	
}