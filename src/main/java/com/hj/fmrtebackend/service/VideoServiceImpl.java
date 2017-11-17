package com.hj.fmrtebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.fmrtebackend.model.Video;
import com.hj.fmrtebackend.model.VideoDto;
import com.hj.fmrtebackend.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {

	
	@Autowired
	VideoRepository videoRepository;
	
	@Override
	public Video saveVideo(VideoDto videoDto) {
		
		Video video = new Video(videoDto); 
		video = videoRepository.save(video);
		return video;
	}
	
	@Override
	public boolean videoExists(String videoId) {
		
		Video video = videoRepository.findByVideoId(videoId);
		
		if (video == null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public Video getRandomVideo() {
		
		Video video = videoRepository.findRandom();
		
		return video;
	}
	
}
