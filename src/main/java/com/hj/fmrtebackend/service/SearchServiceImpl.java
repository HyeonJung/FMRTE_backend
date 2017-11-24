package com.hj.fmrtebackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hj.fmrtebackend.model.VideoDto;
import com.hj.fmrtebackend.model.youtube.SearchListResponse;
import com.hj.fmrtebackend.model.youtube.SearchResult;

@Service
public class SearchServiceImpl implements SearchService {

	@Value("${fmrte.apiKey}")
	private String apiKey;
	
	@Value("${fmrte.baseUrl}")
	private String baseUrl;
	
	private final RestTemplate restTemplate;
	
	@Autowired
	VideoService videoService;
	
	public SearchServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	
	@Override
	public ResponseEntity<?> searchMusicVideo(String keyword, HttpServletRequest request) {
		
		List<VideoDto> videos = new ArrayList<VideoDto>();
		
		String url = baseUrl + "search?part=snippet&key=" + apiKey + "&maxResults=10&type=video&q=" + keyword;
		SearchListResponse response = this.restTemplate.getForObject(url, SearchListResponse.class);
		
		for (SearchResult result : response.getItems()) {
			VideoDto video = new VideoDto();
			video.setVideoId(result.getId().getVideoId());
			video.setThumbnail(result.getSnippet().getThumbnails().get("default").getUrl());
			video.setTitle(result.getSnippet().getTitle());
			video.setDescription(result.getSnippet().getDescription());
			video.setRegist(videoService.videoExists(result.getId().getVideoId(), request));
			
			videos.add(video);
		}
		
		return new ResponseEntity<>(videos, HttpStatus.OK);
		
	}
}
