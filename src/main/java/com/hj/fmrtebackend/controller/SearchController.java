package com.hj.fmrtebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hj.fmrtebackend.service.SearchService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value= "/api")
@Api(tags="search")
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> searchMusicVideo(@RequestParam String keyword) {
		
		return searchService.searchMusicVideo(keyword);
		
	}
}
