package br.com.ewerton.portfolioweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ewerton.portfolioweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
