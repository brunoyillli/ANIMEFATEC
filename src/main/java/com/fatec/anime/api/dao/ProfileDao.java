package com.fatec.anime.api.dao;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.fatec.anime.api.model.Profile;
import com.fatec.anime.api.repository.ProfileRepository;

@Service
public class ProfileDao {

	private ProfileRepository repository;

	public Profile get(Long id) {
		return repository.findById(id).get();
	}

	public void save(Profile profile) {
		repository.save(profile);
	}
}
