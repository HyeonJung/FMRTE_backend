package com.hj.fmrtebackend.model.youtube;

import java.util.Date;
import java.util.Map;

import lombok.Data;

@Data
public class Snippet {
	
	private Date publishedAt;
	private String channelId;
	private String title;
	private String description;
	private Map<String,Thumbnails> thumbnails;
	private String channelTitle;
	
}
