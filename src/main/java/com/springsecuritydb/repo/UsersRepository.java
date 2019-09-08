package com.springsecuritydb.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecuritydb.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String username);

}
