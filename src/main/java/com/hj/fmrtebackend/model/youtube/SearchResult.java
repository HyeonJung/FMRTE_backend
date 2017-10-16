package com.hj.fmrtebackend.model.youtube;

import lombok.Data;

@Data
public class SearchResult {
	
	private String kind;
	private String etag;
	private Id id;
	private Snippet snippet;
	
}
