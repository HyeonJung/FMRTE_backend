package com.hj.fmrtebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hj.fmrtebackend.model.PlayList;
import com.hj.fmrtebackend.model.PlayListPk;

public interface PlayListRepository extends JpaRepository<PlayList, PlayListPk>{

	PlayList findByUserIdAndVideoId(Long userId, String videoId);
	
	@Query(value = "SELECT * FROM play_list "
			+ "WHERE user_id  = :user_id "
			+ "ORDER BY RAND() " 
			+ "LIMIT 1 ",
			nativeQuery = true)
	PlayList findRandom(@Param("user_id") Long id);
}
