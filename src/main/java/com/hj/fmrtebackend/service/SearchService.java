package com.hj.fmrtebackend.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public interface SearchService {

	ResponseEntity<?> searchMusicVideo(String keyword, HttpServletRequest request);
}
