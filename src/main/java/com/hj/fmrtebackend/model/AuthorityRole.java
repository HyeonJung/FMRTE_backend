package com.hj.fmrtebackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityRole implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID")
    private Long id;
	
	@Enumerated(EnumType.STRING)
    @Column(name="ROLE", length=20)
    private Role role;
    
}
