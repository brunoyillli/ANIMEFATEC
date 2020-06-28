package com.fatec.anime.api.repository;

import com.fatec.anime.api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}