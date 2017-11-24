package com.hj.fmrtebackend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hj.fmrtebackend.model.Users;
import com.hj.fmrtebackend.model.Video;
import com.hj.fmrtebackend.model.VideoDto;
import com.hj.fmrtebackend.service.SearchService;
import com.hj.fmrtebackend.service.UserService;
import com.hj.fmrtebackend.service.VideoService;
import com.hj.fmrtebackend.support.UserDto;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value= "/api")
@Api(tags="web")
public class WebController {

	@Autowired
	SearchService searchService;
	
	@Autowired
	VideoService videoService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> searchMusicVideo(@RequestParam String keyword, HttpServletRequest request) {
		
		return searchService.searchMusicVideo(keyword, request);
		
	}
	
	@RequestMapping(value = "/video", method = RequestMethod.POST)
	public ResponseEntity<?> registMusicVideo(@RequestBody VideoDto videoDto, HttpServletRequest request) {
		
		Video video = videoService.saveVideo(videoDto, request);
		
		return new ResponseEntity<>(video, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/video/random", method = RequestMethod.GET)
	public ResponseEntity<?> registMusicVideo(HttpServletRequest request) {
		
		Video video = videoService.getRandomVideo(request);
		
		if (video == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(video, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<?> registUser(@RequestBody UserDto userDto) {
		
		Users user = userService.saveUser(userDto);
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
}
