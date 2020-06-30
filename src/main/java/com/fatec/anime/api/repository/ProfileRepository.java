package com.fatec.anime.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.anime.api.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
}
