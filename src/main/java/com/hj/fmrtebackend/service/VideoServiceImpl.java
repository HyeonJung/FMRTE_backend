package com.hj.fmrtebackend.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.fmrtebackend.common.util.JwtUtil;
import com.hj.fmrtebackend.model.PlayList;
import com.hj.fmrtebackend.model.Users;
import com.hj.fmrtebackend.model.Video;
import com.hj.fmrtebackend.model.VideoDto;
import com.hj.fmrtebackend.repository.PlayListRepository;
import com.hj.fmrtebackend.repository.UserRepository;
import com.hj.fmrtebackend.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {
	
	private static Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	PlayListRepository playListRepository;
	
	@Override
	@Transactional
	public Video saveVideo(VideoDto videoDto, HttpServletRequest request) {
		
		Video video = videoRepository.findByVideoId(videoDto.getVideoId());
		String username = JwtUtil.getUsername(request);
		logger.debug("### username = {}",username);
		Users user = userRepository.findByUsername(username);
		
		if (video == null) {
			video = new Video(videoDto);
			video = videoRepository.save(video);
			
		}
		
		PlayList playList = new PlayList();
		playList.setUserId(user.getId());
		playList.setVideoId(videoDto.getVideoId());
		playListRepository.save(playList);
		
		
		logger.debug("### video = {}",video);
		return video;
	}
	
	@Override
	public boolean videoExists(String videoId, HttpServletRequest request) {
		
		String username = JwtUtil.getUsername(request);
		Users user = userRepository.findByUsername(username);
				
		PlayList playList = playListRepository.findByUserIdAndVideoId(user.getId(), videoId);
		
		if (playList == null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public Video getRandomVideo(HttpServletRequest request) {
		
		String username = JwtUtil.getUsername(request);
		Users user = userRepository.findByUsername(username);
		
		PlayList playList = playListRepository.findRandom(user.getId());
		logger.debug("### playList = {}",playList);
		
		Video video = null;
		
		if (playList != null) {
			video = videoRepository.findByVideoId(playList.getVideoId());
		}
		
		
		return video;
	}
	
}
