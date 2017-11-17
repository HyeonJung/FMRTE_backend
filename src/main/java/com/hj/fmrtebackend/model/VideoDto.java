package com.hj.fmrtebackend.model;

import java.util.Date;

import lombok.Data;

@Data
public class VideoDto {
	
	private String videoId;
	private String title;
	private String description;
	private String thumbnail;
	private Date publishedAT;
	private boolean regist;
}
