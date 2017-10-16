package com.hj.fmrtebackend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hj.fmrtebackend.model.youtube.SearchListResponse;

@Service
public class SearchServiceImpl implements SearchService {

	@Value("${fmrte.apiKey}")
	private String apiKey;
	
	@Value("${fmrte.baseUrl}")
	private String baseUrl;
	
	private final RestTemplate restTemplate;
	
	public SearchServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	
	@Override
	public ResponseEntity<?> searchMusicVideo(String keyword) {
		
		String url = baseUrl + "search?part=snippet&key=" + apiKey + "&type=video&q=" + keyword;
		SearchListResponse response = this.restTemplate.getForObject(url, SearchListResponse.class);
		System.out.println(response);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
}
