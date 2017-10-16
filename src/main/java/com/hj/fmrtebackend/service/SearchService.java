package com.hj.fmrtebackend.service;

import org.springframework.http.ResponseEntity;

public interface SearchService {

	ResponseEntity<?> searchMusicVideo(String keyword);
}
