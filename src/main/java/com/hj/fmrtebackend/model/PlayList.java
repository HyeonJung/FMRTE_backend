package com.hj.fmrtebackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
@IdClass(PlayListPk.class)
public class PlayList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private Long userId;
	
	@Id
	@Column
	private String videoId;
	
}
