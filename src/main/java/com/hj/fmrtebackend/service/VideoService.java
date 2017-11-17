package com.hj.fmrtebackend.service;

import com.hj.fmrtebackend.model.Video;
import com.hj.fmrtebackend.model.VideoDto;

public interface VideoService {

	/**
	 * 비디오 저장
	 * @return
	 */
	Video saveVideo(VideoDto videoDto);
	
	/**
	 * 비디오 존재여부 확인
	 * @param videoId
	 * @return
	 */
	boolean videoExists(String videoId);
	
	/**
	 * 비디오 랜덤으로 가져오기
	 * @return
	 */
	Video getRandomVideo();
}
