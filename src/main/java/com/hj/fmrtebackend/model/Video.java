package com.hj.fmrtebackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.hj.fmrtebackend.common.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Video extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String videoId;
	@Column
	private Date publishedAT;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String thumbnail;
	@Column
	private String userDescription;
		
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", publishedAT=" + publishedAT + ", title=" + title + ", description="
				+ description + ", thumbnail=" + thumbnail + ", userDescription=" + userDescription + "]";
	}
	
}
