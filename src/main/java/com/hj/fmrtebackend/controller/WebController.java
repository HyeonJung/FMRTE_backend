package com.hj.fmrtebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hj.fmrtebackend.model.Video;
import com.hj.fmrtebackend.model.VideoDto;
import com.hj.fmrtebackend.service.SearchService;
import com.hj.fmrtebackend.service.VideoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value= "/api")
@Api(tags="web")
public class WebController {

	@Autowired
	SearchService searchService;
	
	@Autowired
	VideoService videoService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> searchMusicVideo(@RequestParam String keyword) {
		
		return searchService.searchMusicVideo(keyword);
		
	}
	
	@RequestMapping(value = "/video", method = RequestMethod.POST)
	public ResponseEntity<?> registMusicVideo(@RequestBody VideoDto videoDto) {
		
		Video video = videoService.saveVideo(videoDto);
		
		return new ResponseEntity<>(video, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/video/random", method = RequestMethod.GET)
	public ResponseEntity<?> registMusicVideo() {
		
		Video video = videoService.getRandomVideo();
		
		return new ResponseEntity<>(video, HttpStatus.OK);
	}
	
}
