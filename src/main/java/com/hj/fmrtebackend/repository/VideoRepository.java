package com.hj.fmrtebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hj.fmrtebackend.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

	Video findByVideoId(String videoId);
	
	@Query(value = "SELECT * FROM video " 
			+ "ORDER BY RAND() " 
			+ "LIMIT 1",
			nativeQuery = true)
	Video findRandom();
}
