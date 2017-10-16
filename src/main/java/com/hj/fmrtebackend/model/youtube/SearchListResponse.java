package com.hj.fmrtebackend.model.youtube;

import java.util.List;

import lombok.Data;

@Data
public class SearchListResponse {

	private String kind;
	private String etag;
	private String nextPageToken;
	private String prevPageToken;
	private PageInfo pageInfo;
	private List<SearchResult> items;
}
