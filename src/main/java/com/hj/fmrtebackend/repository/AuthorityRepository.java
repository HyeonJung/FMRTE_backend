package com.hj.fmrtebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.fmrtebackend.model.Authority;
import com.hj.fmrtebackend.model.AuthorityRole;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityRole> {

}
