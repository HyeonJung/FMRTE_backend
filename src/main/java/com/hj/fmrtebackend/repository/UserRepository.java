package com.hj.fmrtebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.fmrtebackend.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByUsername(String username);
}
