package com.hj.fmrtebackend.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hj.fmrtebackend.common.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name="users")
@Data
@EqualsAndHashCode(callSuper=false)
@ToString
public class Users extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	@Column(unique=true)
    private String username;

    @Column
    private String name;
    
    @Column(unique=true)
    private String email;
    
    @Column
    @JsonIgnore
    private String password;
    
    @Column
    @JsonIgnore
    private boolean accountNonExpired = true;

    @Column
    @JsonIgnore
    private boolean accountNonLocked = true;
    
    @Column
    @JsonIgnore
    private boolean credentialsNonExpired = true;

    @Column
    @JsonIgnore
    private boolean enabled = true;
    
    @OneToMany(mappedBy="authorityRole.id", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JsonIgnore
    private Set<Authority> authorities;

    
 
}
